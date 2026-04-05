package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.entities.Recompensas;

import java.util.List;

public interface IRecompensasService {
    public void insert(Recompensas recompensas);
    public List<Recompensas> list();
    public Recompensas listId(int idRecompensas);
    public void delete(int idRecompensas);
    public void update(Recompensas recompensas);

    public List<String[]> proximoVencimiento();
    public List<String[]> cantidadRecompensas();
}
