package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT r.nombre_rol, COUNT(u.id_user) AS cantidad_usuarios " +
            "FROM rol AS r " +
            "LEFT JOIN usuario AS u ON u.rol_id = r.id_rol " +
            "GROUP BY r.nombre_rol",
            nativeQuery = true)
    public List<String[]> cantidadUsuariosPorRol();
}
