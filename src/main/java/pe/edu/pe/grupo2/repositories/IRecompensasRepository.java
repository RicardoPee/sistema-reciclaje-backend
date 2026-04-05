package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.grupo2.entities.Recompensas;

import java.util.List;

public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> {

    @Query(value = "SELECT nombre_recompensa, COUNT(id_recompensas) AS cantidad_reclamada, fecha_vencimiento\n" +
            " FROM recompensas\n" +
    " GROUP BY nombre_recompensa, fecha_vencimiento\n" +
      " ORDER BY cantidad_reclamada DESC;", nativeQuery = true)
      public List<String[]> cantidadRecompensas();

    @Query(value = "SELECT nombre_recompensa, fecha_vencimiento\n" +
            " FROM Recompensas\n" +
            " ORDER BY fecha_vencimiento ASC;", nativeQuery = true)
    public List<String[]> proximoVencimiento();
}

