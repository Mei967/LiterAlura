package aluracursos.literalura.repository;

import aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :anio AND (a.fallecimiento IS NULL OR a.fallecimiento > :anio)")
    List<Autor> autoresVivosEnAnio(Integer anio);
}
