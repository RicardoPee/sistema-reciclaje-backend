package pe.edu.pe.grupo2.serviceinterfaces;

import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Rol;

import java.time.LocalDate;
import java.util.List;

public interface IRolService {
    public void insert(Rol rol);

    public List<Rol> list();

    public void delete(int idRol);

    Rol listId(int idRol);

    public void update(Rol rol);

    public List<String[]> cantidadUsuariosPorRol();
}
