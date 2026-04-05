package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Notificaciones;
import pe.edu.pe.grupo2.entities.Reclamaciones;
import pe.edu.pe.grupo2.entities.Recompensas;

import java.util.List;

public interface IReclamacionesService {
    public void insert(Reclamaciones reclamaciones);
    public List<Reclamaciones> list();
    public Reclamaciones listId(int idReclamaciones);
    public void delete(int idReclamaciones);
    public void update(Reclamaciones reclamaciones);
    public List<String[]> cantidadReclamaciones();

}
