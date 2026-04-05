package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.repositories.IActividadRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;

import java.util.List;
import java.util.Random;

@Service
public class ActividadServiceImplement implements IActividadService {

    @Autowired
    private IActividadRepository aR;

    @Autowired
    private pe.edu.pe.grupo2.repositories.UserRepository uR;

    private static final String CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

    /** Genera un código único tipo REC-4F7A */
    private String generarCodigo() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder("REC-");
        for (int i = 0; i < 4; i++) {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    @Override
    public List<Actividad> list() { return aR.findAll(); }

    @Override
    @Transactional
    public void insert(Actividad a) {
        // Al crear, estado=PENDIENTE y generar código único. Los puntos NO se suman todavía.
        a.setEstado("PENDIENTE");
        String codigo;
        do {
            codigo = generarCodigo();
        } while (aR.existsByCodigoReserva(codigo)); // garantizar unicidad
        a.setCodigoReserva(codigo);
        aR.save(a);
    }

    @Override
    public Actividad listId(int id) { return aR.findById(id).orElse(new Actividad()); }

    @Override
    @Transactional
    public void update(Actividad a) {
        // Solo ADMI/EMPLEADO; recalcular delta si cambian los puntos
        Actividad anterior = aR.findById(a.getIdActividad()).orElse(null);
        if (anterior != null && "APROBADA".equals(anterior.getEstado()) && anterior.getU() != null) {
            pe.edu.pe.grupo2.entities.User user = uR.findById(anterior.getU().getIdUser()).orElse(null);
            if (user != null) {
                int delta = a.getPuntos() - anterior.getPuntos();
                user.setPuntosAcumulados(Math.max(0, user.getPuntosAcumulados() + delta));
                uR.save(user);
            }
        }
        aR.save(a);
    }

    @Override
    @Transactional
    public void aprobar(int id) {
        Actividad a = aR.findById(id).orElseThrow(() -> new RuntimeException("Actividad no encontrada: " + id));
        if (!"PENDIENTE".equals(a.getEstado())) {
            throw new RuntimeException("Solo se pueden aprobar actividades en estado PENDIENTE");
        }
        a.setEstado("APROBADA");
        aR.save(a);
        // Ahora SÍ sumamos los puntos al usuario
        if (a.getU() != null && a.getPuntos() > 0) {
            pe.edu.pe.grupo2.entities.User user = uR.findById(a.getU().getIdUser()).orElse(null);
            if (user != null) {
                user.setPuntosAcumulados(user.getPuntosAcumulados() + a.getPuntos());
                uR.save(user);
            }
        }
    }

    @Override
    @Transactional
    public void rechazar(int id) {
        Actividad a = aR.findById(id).orElseThrow(() -> new RuntimeException("Actividad no encontrada: " + id));
        if (!"PENDIENTE".equals(a.getEstado())) {
            throw new RuntimeException("Solo se pueden rechazar actividades en estado PENDIENTE");
        }
        a.setEstado("RECHAZADA");
        aR.save(a);
        // No se suman puntos. Si ya los tenía (no debería), no se restan.
    }

    @Override
    @Transactional
    public void delete(int id) {
        Actividad a = aR.findById(id).orElse(null);
        // Solo restar puntos si la actividad estaba APROBADA
        if (a != null && "APROBADA".equals(a.getEstado()) && a.getU() != null && a.getPuntos() > 0) {
            pe.edu.pe.grupo2.entities.User user = uR.findById(a.getU().getIdUser()).orElse(null);
            if (user != null) {
                user.setPuntosAcumulados(Math.max(0, user.getPuntosAcumulados() - a.getPuntos()));
                uR.save(user);
            }
        }
        aR.deleteById(id);
    }

    @Override
    public List<String[]> ActividadesporCentro() { return aR.ActividadesporCentro(); }

    @Override
    public List<String[]> ActividadesporUsuario() { return aR.ActividadesporUsuario(); }

    @Override
    public List<String[]> rankingPorDistrito(String distrito) { return aR.rankingPorDistrito(distrito); }
}
