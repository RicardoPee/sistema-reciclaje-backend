package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.grupo2.entities.Reclamaciones;

import java.util.List;

public interface IReclamacionesRepository extends JpaRepository<Reclamaciones, Integer> {

    @Query(value = "SELECT r.nombre_recompensa, COUNT(rec.id_reclamacion) AS cantidad_reclamada, r.fecha_vencimiento " +
            "FROM reclamaciones rec " +
            "JOIN recompensas r ON rec.id_recompensa = r.id_recompensas " +
            "GROUP BY r.nombre_recompensa, r.fecha_vencimiento " +
            "ORDER BY cantidad_reclamada DESC", nativeQuery = true)
    public List<String[]> cantidadReclamaciones();

}
