package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Rol;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

       /* user.getRol().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));
        });*/
        Rol rol = user.getRol();
        roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, roles);
        return ud;
    }


    public User getUserByUsername(String username) {
        return repo.findByUsername(username);
    }
}
