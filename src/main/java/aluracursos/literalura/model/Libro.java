package aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("authors")
    @ElementCollection
    private List<Autor> autores;

    @JsonProperty("summaries")
    @Column(length = 1000)
    private String descripcion;

    @JsonProperty("languages")
    @ElementCollection
    private List<String> idiomas;

    @JsonProperty("download_count")
    private Integer cantidadDescargas;

    @JsonProperty("bookshelves")
    @ElementCollection
    private List<String> estanterias;

}


