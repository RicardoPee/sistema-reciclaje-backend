package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.pe.grupo2.entities.Notificaciones;

import java.time.LocalDate;
import java.util.List;

public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    @Query(value = "SELECT u.nombres, ROUND(AVG(subquery.daily_count), 2) AS promedio_notificaciones_diario " +
            "FROM ( " +
            "    SELECT n.id_user, COUNT(n.id_notificaciones) AS daily_count " +
            "    FROM notificaciones AS n " +
            "    WHERE n.fecha_notificacion BETWEEN :fechaInicio AND :fechaFin " +
            "    AND n.id_user = :userId " +
            "    GROUP BY DATE(n.fecha_notificacion), n.id_user " +
            ") AS subquery " +
            "INNER JOIN usuario AS u ON subquery.id_user = u.id_user " +
            "GROUP BY u.nombres",
            nativeQuery = true)
    public List<String[]> PromedioNotificacionesPorDiaUsuario(@Param("fechaInicio") LocalDate fechaInicio,
                                                              @Param("fechaFin") LocalDate fechaFin,
                                                              @Param("userId") int userId);

    @Query(value = "SELECT u.nombres, COUNT(n.id_notificaciones) AS total_notificaciones " +
            "FROM usuario AS u " +
            "INNER JOIN notificaciones AS n ON u.id_user = n.id_user " +
            "WHERE n.fecha_notificacion BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY u.nombres " +
            "ORDER BY total_notificaciones DESC " +
            "LIMIT 3",
            nativeQuery = true)
    public List<String[]> Top3UsuariosConMasNotificaciones(@Param("fechaInicio") LocalDate fechaInicio,
                                                            @Param("fechaFin") LocalDate fechaFin);
}
