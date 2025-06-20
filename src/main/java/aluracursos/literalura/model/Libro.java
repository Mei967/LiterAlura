package aluracursos.literalura.model;

import aluracursos.literalura.dto.LibroDTO;
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
    @ManyToMany(cascade = CascadeType.ALL)
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

    // Constructor vacío requerido por JPA
    public Libro() {}

    public Libro(LibroDTO dto) {
        this.titulo = dto.titulo();
        this.descripcion = dto.descripcion();
        this.idiomas = dto.idiomas();
        this.cantidadDescargas = dto.cantidadDescargas();
        this.estanterias = dto.estanterias();

        // Convertir la lista de AutorDTO a lista de Autor
        this.autores = dto.autores().stream()
                .map(Autor::new)
                .toList();
    }



    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Integer cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public List<String> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(List<String> estanterias) {
        this.estanterias = estanterias;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo +
                ", Idiomas: " + idiomas +
                ", Descargas: " + cantidadDescargas;
    }

}

