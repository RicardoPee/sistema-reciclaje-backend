package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.Actividad;

import java.util.List;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer> {

    boolean existsByCodigoReserva(String codigoReserva);

        @Query(value = "SELECT \n" +
                        "    c.direccion AS nombre_centro, \n" +
                        "    COUNT(a.id_actividad) AS numero_actividades\n" +
                        "FROM \n" +
                        "    actividad a\n" +
                        "INNER JOIN \n" +
                        "    centro_reciclaje c ON a.id_centro_reciclaje = c.id_centro_reciclaje\n" +
                        "GROUP BY \n" +
                        "    c.direccion\n" +
                        "ORDER BY \n" +
                        "    numero_actividades DESC", nativeQuery = true)
        public List<String[]> ActividadesporCentro();

        @Query(value = "SELECT \n" +
                        "    u.username AS username, \n" +
                        "    COUNT(a.id_actividad) AS numero_actividades, \n" +
                        "    SUM(CAST(a.puntos AS INTEGER)) AS total_puntos\n" +
                        "FROM \n" +
                        "    actividad a \n" +
                        "INNER JOIN \n" +
                        "    usuario u ON a.id_user = u.id_user\n" +
                        "GROUP BY \n" +
                        "    u.username\n" +
                        "ORDER BY \n" +
                        "    numero_actividades DESC", nativeQuery = true)
        public List<String[]> ActividadesporUsuario();

        /** Top 10 recicladores de un distrito en la semana actual (actividades APROBADAS) */
        @Query(value = "SELECT " +
                        "    u.username, " +
                        "    u.nombres, " +
                        "    u.apellidos, " +
                        "    COUNT(a.id_actividad) AS total_actividades, " +
                        "    COALESCE(SUM(CAST(a.puntos AS INTEGER)), 0) AS total_puntos " +
                        "FROM actividad a " +
                        "INNER JOIN usuario u ON a.id_user = u.id_user " +
                        "WHERE u.distrito = :distrito " +
                        "  AND a.estado = 'APROBADA' " +
                        "  AND a.fecha_recepcion >= CURRENT_DATE - INTERVAL '7 days' " +
                        "GROUP BY u.id_user, u.username, u.nombres, u.apellidos " +
                        "ORDER BY total_actividades DESC, total_puntos DESC " +
                        "LIMIT 10", nativeQuery = true)
        List<String[]> rankingPorDistrito(@Param("distrito") String distrito);
}
