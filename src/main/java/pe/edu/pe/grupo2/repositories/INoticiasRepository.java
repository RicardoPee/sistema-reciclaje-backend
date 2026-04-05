package pe.edu.pe.grupo2.repositories;

import org.aspectj.weaver.ast.Not;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.Noticias;

import java.util.List;

@Repository
public interface INoticiasRepository extends JpaRepository<Noticias, Integer> {
    @Query("select ur from Noticias ur where ur.titulo like %:titulo%")
    public List<Noticias> BuscarTitulo(@Param("titulo") String Titulo);
}
