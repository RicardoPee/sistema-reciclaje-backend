package pe.edu.pe.grupo2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.pe.grupo2.entities.Rol;
import pe.edu.pe.grupo2.repositories.IRolRepository;

@Configuration
public class RoleInitializer {

    @Bean
    public CommandLineRunner initRoles(IRolRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                Rol admin = new Rol();
                admin.setNombreRol("ADMIN");
                roleRepository.save(admin);

                Rol cliente = new Rol();
                cliente.setNombreRol("CLIENTE");
                roleRepository.save(cliente);

                Rol reciclador = new Rol();
                reciclador.setNombreRol("RECICLADOR");
                roleRepository.save(reciclador);
                
                System.out.println("Roles inicializados correctamente en la BD vacía.");
            }
        };
    }
}
