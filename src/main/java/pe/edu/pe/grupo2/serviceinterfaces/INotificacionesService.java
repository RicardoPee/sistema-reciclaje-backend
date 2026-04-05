package pe.edu.pe.grupo2.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.pe.grupo2.entities.Notificaciones;

import java.time.LocalDate;
import java.util.List;

public interface INotificacionesService {

    public List<Notificaciones> list();
    public void insert(Notificaciones n);
    public Notificaciones listId(int id);
    public void delete(int id);
    public void update(Notificaciones n);

    public List<String[]> PromedioNotificacionesPorDiaUsuario(LocalDate fechaInicio,LocalDate fechaFin, int userId);
    public List<String[]> Top3UsuariosConMasNotificaciones(LocalDate fechaInicio, LocalDate fechaFin);


}
