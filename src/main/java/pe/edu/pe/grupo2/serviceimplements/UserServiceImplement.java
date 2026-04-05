package pe.edu.pe.grupo2.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;


import java.time.LocalDate;

import java.time.LocalTime;

import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository uR;
    @Autowired
    private pe.edu.pe.grupo2.repositories.IRolRepository rR;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void insert(User u) {
        String encryptedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptedPassword);

        // Prevenir nulos y forzar 0 puntos al iniciar para Gamificación
        u.setPuntosAcumulados(0);
        
        // 1. Asignar activado por defecto si viene nulo desde la Web
        if (u.getEnabled() == null) {
            u.setEnabled(true);
        }

        // 2. Asignar Rol por defecto (ID 1) si la Web no envía uno válido
        if (u.getRol() != null && u.getRol().getIdRol() > 0) {
            u.setRol(rR.findById(u.getRol().getIdRol()).orElse(rR.findById(1).orElse(null)));
        } else {
            u.setRol(rR.findById(1).orElse(null));
        }

        uR.save(u);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }

    @Override
    public void update(User ur) {
        User existingUser = uR.findById(ur.getIdUser()).orElse(null);

        if (existingUser != null) {
            // Verificar si el campo de contraseña no está vacío o nulo
            if (ur.getPassword() != null && !ur.getPassword().isEmpty()) {
                // Encriptar y actualizar la nueva contraseña
                existingUser.setPassword(passwordEncoder.encode(ur.getPassword()));
            }

            // Actualizar otros campos
            existingUser.setNombres(ur.getNombres());
            existingUser.setApellidos(ur.getApellidos());
            existingUser.setUsername(ur.getUsername());
            existingUser.setDni(ur.getDni());
            existingUser.setEdad(ur.getEdad());
            existingUser.setGenero(ur.getGenero());
            existingUser.setDistrito(ur.getDistrito());
            existingUser.setTelefono(ur.getTelefono());
            existingUser.setCorreo(ur.getCorreo());
            existingUser.setEnabled(ur.getEnabled());
            if (ur.getRol() != null && ur.getRol().getIdRol() > 0) {
                existingUser.setRol(rR.findById(ur.getRol().getIdRol()).orElse(null));
            } else {
                existingUser.setRol(ur.getRol());
            }

            // Guardar los cambios en la base de datos
            uR.save(existingUser);
        }
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);

    }

    @Override
    public List<User> BuscarDistrito(String distrito) {
        return uR.BuscarDistrito(distrito);
    }


    @Override
    public List<String[]> Cantidadnotificaciones_deusuario_rangodias(LocalDate diaInicio, LocalDate diaFin) {
        return uR.Cantidadnotificaciones_deusuario_rangodias(diaInicio, diaFin);
    }

    @Override
    public List<String[]> ObtenerCantidadUsuariosPorDistrito() {
        return uR.ObtenerCantidadUsuariosPorDistrito();
    }

    /*@Override
    public List<User> getAllUsers() {
        return uR.findAll(); // Devuelve todos los usuarios de la base de datos
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        // Busca el usuario por su username
        User user = uR.findByUsername(username);
        return user != null ? List.of(user) : List.of(); // Si el usuario existe, lo devuelve, si no, lista vacía
    }*/

}
