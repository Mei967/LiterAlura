package aluracursos.literalura.dto;

import aluracursos.literalura.model.Autor;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public record LibroDTO(
        @JsonProperty("title")
        String titulo,

       @JsonProperty("authors")
       List<AutorDTO> autores,

       @JsonProperty("summaries")
       String descripcion,

       @JsonProperty("languages")
        List<String> idiomas,

       @JsonProperty("download_count")
       Integer cantidadDescargas,

       @JsonProperty("bookshelves")
        List<String> estanterias) {


}
