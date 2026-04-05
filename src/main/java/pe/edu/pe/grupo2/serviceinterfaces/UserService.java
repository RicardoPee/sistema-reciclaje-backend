package pe.edu.pe.grupo2.serviceinterfaces;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public interface UserService {

    public List<User> list();
    public void insert(User u);
    public User listId(int id);
    public void update(User ur);
    public void delete(int id);
    public List<User> BuscarDistrito(String distrito);

    public List<String[]> Cantidadnotificaciones_deusuario_rangodias(LocalDate diaInicio, LocalDate diaFin);
    public List<String[]> ObtenerCantidadUsuariosPorDistrito();


}
