package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.pe.grupo2.entities.Favoritos;
import pe.edu.pe.grupo2.entities.User;

import java.util.List;

public interface IFavoritosRepository extends JpaRepository<Favoritos, Integer> {

    /** Obtener todos los usuarios que tienen un centro específico como favorito */
    @Query("SELECT f.user FROM Favoritos f WHERE f.centroReciclaje.idCentroReciclaje = :idCentro")
    List<User> findUsuariosByCentro(@Param("idCentro") int idCentro);
}
