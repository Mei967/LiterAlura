package aluracursos.literalura.service;

import aluracursos.literalura.dto.AutorDTO;
import aluracursos.literalura.dto.LibroDTO;
import aluracursos.literalura.model.Autor;
import aluracursos.literalura.model.Libro;

public class ConversorDeDatos {

    public Libro convertirADominio(LibroDTO datos) {
        AutorDTO datosAutor = datos.autores().get(0);

        Autor autor = new Autor(
                datosAutor.nombre(),
                datosAutor.nacimiento(),
                datosAutor.fallecimiento()
        );

        String idioma = datos.idiomas().isEmpty() ? "desconocido" : datos.idiomas().get(0);

        return new Libro(
                datos.titulo(),
                idioma,
                datos.descargas(),
                autor
        );
    }
}


