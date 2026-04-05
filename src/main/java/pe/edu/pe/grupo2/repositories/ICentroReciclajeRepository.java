package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.CentroReciclaje;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ICentroReciclajeRepository extends JpaRepository<CentroReciclaje, Integer> {
    @Query("SELECT acr FROM CentroReciclaje acr WHERE acr.direccion LIKE %:direccion%")
    public List<CentroReciclaje> findByDireccion(@Param("direccion") String direccion);


    @Query(value = "SELECT c.direccion, COUNT(f.id_centro_reciclaje) AS cantidad_favoritos\n" +
            "FROM centro_reciclaje c \n" +
            "LEFT JOIN favoritos f ON c.id_centro_reciclaje = f.id_centro_reciclaje\n" +
            "WHERE f.id_centro_reciclaje IS NOT NULL\n" +
            "GROUP BY c.direccion\n" +
            "ORDER BY cantidad_favoritos DESC", nativeQuery = true)
    public List<String[]> centroFavoritos();

    @Query(value ="SELECT c.direccion, COUNT(DISTINCT a.id_User) AS cantidadUsuarios \n" +
            " FROM centro_reciclaje c \n" +
            " INNER JOIN actividad a ON c.id_centro_Reciclaje = a.id_centro_reciclaje \n" +
            " GROUP BY c.direccion \n" +
            " ORDER BY cantidadUsuarios DESC", nativeQuery = true)
    public List<String[]> centroUsuarios();

}