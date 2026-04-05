package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.entities.TipoActividad;

import java.util.List;

public interface ITipoActividadService {
    void insert(TipoActividad tipoactividad);
    List<TipoActividad> list();
    public TipoActividad listId(int id);
    public void update(TipoActividad tipoActividad);
    public void delete(int id);
    // Métodos para las nuevas queries

}
