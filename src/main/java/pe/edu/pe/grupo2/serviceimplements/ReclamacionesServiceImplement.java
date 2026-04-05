package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Reclamaciones;
import pe.edu.pe.grupo2.entities.Recompensas;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.IReclamacionesRepository;
import pe.edu.pe.grupo2.repositories.IRecompensasRepository;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IReclamacionesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamacionesServiceImplement implements IReclamacionesService {

    @Autowired
    private IReclamacionesRepository rR;

    @Autowired
    private UserRepository uR;

    @Autowired
    private IRecompensasRepository recR;

    @Override
    @Transactional
    public void insert(Reclamaciones reclamaciones) {
        if (reclamaciones.getUsuario() == null || reclamaciones.getRecompensa() == null) {
            throw new RuntimeException("Datos de reclamación incompletos.");
        }

        User u = uR.findById(reclamaciones.getUsuario().getIdUser())
                   .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        Recompensas r = recR.findById(reclamaciones.getRecompensa().getIdRecompensas())
                            .orElseThrow(() -> new RuntimeException("Recompensa no encontrada."));

        // ── Validación de stock ──────────────────────────────────────
        // stock == -1 → ilimitado (sin validación)
        // stock == 0  → AGOTADO
        // stock > 0   → disponible, decrementar
        if (r.getStock() == 0) {
            throw new RuntimeException("STOCK_AGOTADO: Esta recompensa ya no tiene stock disponible.");
        }

        // ── Validación de puntos ─────────────────────────────────────
        if (u.getPuntosAcumulados() < r.getCostoPuntos()) {
            throw new RuntimeException("Puntos insuficientes para canjear esta recompensa.");
        }

        // ── Descontar puntos ─────────────────────────────────────────
        u.setPuntosAcumulados(u.getPuntosAcumulados() - r.getCostoPuntos());
        uR.save(u);

        // ── Decrementar stock (si no es ilimitado) ───────────────────
        if (r.getStock() > 0) {
            r.setStock(r.getStock() - 1);
            recR.save(r);
        }

        rR.save(reclamaciones);
    }

    @Override
    public List<Reclamaciones> list() {
        return rR.findAll();
    }

    @Override
    public Reclamaciones listId(int idReclamaciones) {
        return rR.findById(idReclamaciones).orElse(new Reclamaciones());
    }

    @Override
    public void delete(int idReclamaciones) {
        // Al eliminar una reclamación, devolver el stock
        Reclamaciones rec = rR.findById(idReclamaciones).orElse(null);
        if (rec != null && rec.getRecompensa() != null) {
            Recompensas r = recR.findById(rec.getRecompensa().getIdRecompensas()).orElse(null);
            if (r != null && r.getStock() >= 0) { // No tocar si es ilimitado (-1)
                r.setStock(r.getStock() + 1);
                recR.save(r);
            }
        }
        rR.deleteById(idReclamaciones);
    }

    @Override
    public void update(Reclamaciones reclamaciones) {
        rR.save(reclamaciones);
    }

    @Override
    public List<String[]> cantidadReclamaciones() {
        return rR.cantidadReclamaciones();
    }
}
