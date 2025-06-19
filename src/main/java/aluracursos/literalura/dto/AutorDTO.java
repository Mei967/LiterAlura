package aluracursos.literalura.dto;

       import com.fasterxml.jackson.annotation.JsonProperty;

        public record AutorDTO(

        @JsonProperty("name")
                String nombre,

       @JsonProperty("birth_year")
       Integer fechaDeNacimiento,

       @JsonProperty("death_year")
       Integer fechaDeMuerte){


        }


