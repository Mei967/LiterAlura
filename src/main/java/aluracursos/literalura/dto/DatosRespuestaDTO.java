package aluracursos.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DatosRespuestaDTO(
        @JsonProperty("results")
        List<LibroDTO> resultados){

}
