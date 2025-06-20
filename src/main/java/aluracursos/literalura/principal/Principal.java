package aluracursos.literalura.principal;

import aluracursos.literalura.dto.DatosRespuestaDTO;
import aluracursos.literalura.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class Principal implements CommandLineRunner {

    private Scanner teclado = new Scanner(System.in);
    private  LibroRepository repositorio;
    private ConsumoAPI consumo = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    DatosRespuestaDTO respuesta = consumo.obtenerDatos(URL_BASE);

    public Principal(LIbroRepository repositorio) {
        this.repositorio = repositorio;
    }

        @Override
        public void run(String... args) throws Exception {

        }
        public void muestraElMenu() {
            var opcion = -1;
            while (opcion != 0) {

                var menu = """
                        1 - Buscar libros por título 
                        2 - Listar libros registrados
                        3 - Listar autores
                        4 - Lista de autores vivos en un año determinado
                        5 - Lista de libros por idioma
                        6 - Buscar autor por nombre
                        7 - Top 10 libros más descargados
                        
                        0 - Salir
                        """;
                System.out.println("\n--- MENÚ DE LITERALURA ---");
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibrosPorTitulo();
                        break;
                    case 2:
                        mostrarLibrosRegistrados();
                        break;
                    case 3:
                        mostrarListaDeAutores();
                        break;
                    case 4:
                        mostrarListaAutoresVivosEnUnAnoDeterminado();
                        break;
                    case 5:
                        buscarLibrosPorIdioma();
                        break;
                    case 6:
                        buscarAutorPorNombre();
                        break;
                    case 7:
                        mostrarTop10LibrosMasDescargados();
                        break;
                    case 0:
                        System.out.println("Salir de la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");

                }

            }
        }


    private void buscarLibrosPorTitulo() {}
    private void mostrarLibrosRegistrados() {}
    private void mostrarListaDeAutores() {}
    private void mostrarListaAutoresVivosEnUnAnoDeterminado() {}
    private void buscarLibrosPorIdioma() {}
    private void buscarAutorPorNombre() {}
    private void mostrarTop10LibrosMasDescargados() {}


}