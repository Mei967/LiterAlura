package aluracursos.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRespuestaDTO(
        List<LibroDTO> results
) {}
