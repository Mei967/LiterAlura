package aluracursos.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer descargas;

    @ManyToOne
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String idioma, Integer descargas, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.descargas = descargas;
        this.autor = autor;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "\n Título: " + titulo +
                "\n Autor: " + autor.getNombre() +
                "\n Idioma: " + idioma +
                "\n Descargas: " + descargas;

    }

}