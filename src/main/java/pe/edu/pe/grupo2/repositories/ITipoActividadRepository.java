package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.TipoActividad;

import java.util.List;

@Repository
public interface ITipoActividadRepository extends JpaRepository<TipoActividad, Integer> {


}
