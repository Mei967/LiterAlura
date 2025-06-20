package aluracursos.literalura.principal;

import aluracursos.literalura.dto.DatosRespuestaDTO;
import aluracursos.literalura.dto.LibroDTO;
import aluracursos.literalura.service.ConsumoApi;

public class Principal {
    public static void main(String[] args) {
        ConsumoApi consumo = new ConsumoApi();
        String url = "https://gutendex.com/books";
        DatosRespuestaDTO respuesta = consumo.obtenerDatos(url);

        // Recorremos los libros recibidos
        for (LibroDTO libro : respuesta.resultados()) {
            System.out.println("📚 Título: " + libro.titulo());
            System.out.println("Idiomas: " + libro.idiomas());
            System.out.println("Descargas: " + libro.cantidadDescargas());
            System.out.println("---------------------------------");
        }
    }
}
