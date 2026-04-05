package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Notificaciones;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.INotificacionesRepository;
import pe.edu.pe.grupo2.serviceinterfaces.INotificacionesService;

import java.time.LocalDate;
import java.util.List;
@Service
public class NotificacionesServiceImplement implements INotificacionesService {

    @Autowired
    private INotificacionesRepository nR;


    @Override
    public List<Notificaciones> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificaciones n) {
        nR.save(n);
    }

    @Override
    public Notificaciones listId(int id) {
        return nR.findById(id).orElse(new Notificaciones());
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);

    }

    @Override
    public void update(Notificaciones n) {
        nR.save(nR.save(n));

    }

    @Override
    public List<String[]> PromedioNotificacionesPorDiaUsuario(LocalDate fechaInicio, LocalDate fechaFin, int userId) {
        return nR.PromedioNotificacionesPorDiaUsuario(fechaInicio, fechaFin, userId);
    }

    @Override
    public List<String[]> Top3UsuariosConMasNotificaciones(LocalDate fechaInicio, LocalDate fechaFin) {
        return nR.Top3UsuariosConMasNotificaciones(fechaInicio, fechaFin);
    }


}
