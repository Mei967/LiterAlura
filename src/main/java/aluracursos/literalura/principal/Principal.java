package aluracursos.literalura.principal;

import aluracursos.literalura.dto.DatosRespuestaDTO;
import aluracursos.literalura.model.Libro;
import aluracursos.literalura.repository.AutorRepository;
import aluracursos.literalura.repository.LibroRepository;
import aluracursos.literalura.service.ConsumoAPI;
import aluracursos.literalura.service.ConversorDeDatos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private final ConsumoAPI consumo = new ConsumoAPI();
    private final ConversorDeDatos conversor = new ConversorDeDatos();

    @Override
    public void run(String... args) throws Exception {
        int opcion = -1;

        while (opcion != 8) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                   case 2:
                       listarLibros();
                //        break;
                  //  case 3:
                  //      listarAutores();
                  //      break;
                 //   case 4:
                 //       listarAutoresVivosPorAnio();
                 //       break;
                 //   case 5:
                 //       listarLibrosPorIdioma();
                 //       break;
                  //  case 6:
                   //     buscarAutorPorNombre();
                     //   break;
                  //  case 7:
                   //     top10LibrosDescargados();
                   //     break;
                    case 8:
                        System.out.println("Hasta pronto ");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("""
                
                ✦✦✦  Catálogo de Libros - Literalura ✦✦✦
                1 - Buscar libros por título
                2 - Listar libros registrados
                3 - Listar autores registrados
                4 - Lista de autores vivos en un año determinado
                5 - Lista de libros por idioma
                6 - Buscar autores por nombre
                7 - Top 10 de libros más descargados
                8 - Salir
                Selecciona una opción:
                """);
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el nombre del libro que desea buscar: ");
        String tituloBuscado = teclado.nextLine();

        String json = consumo.obtenerDatos(URL_BASE + tituloBuscado.replace(" ", "%20"));

        try {
            ObjectMapper mapper = new ObjectMapper();
            DatosRespuestaDTO respuesta = mapper.readValue(json, DatosRespuestaDTO.class);

            if (respuesta.results().isEmpty()) {
                System.out.println(" Libro no encontrado.");
                return;
            }

            var dto = respuesta.results().get(0); // tomamos el primero
            Libro libro = conversor.convertirADominio(dto);

            Optional<Libro> libroExistente = libroRepository.findAll().stream()
                    .filter(l -> l.getTitulo().equalsIgnoreCase(libro.getTitulo()))
                    .findFirst();

            if (libroExistente.isPresent()) {
                System.out.println(" Este libro ya está registrado:");
                System.out.println(libroExistente.get());
                return;
            }

            autorRepository.save(libro.getAutor());
            libroRepository.save(libro);
            System.out.println(" Libro guardado: " + libro);

        } catch (Exception e) {
            System.out.println("Error al procesar el libro: " + e.getMessage());
        }
    }

    private void listarLibros() {
        var libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("\n No hay libros registrados.");
        } else {
            System.out.println("\n Libros registrados:");
            libros.forEach(System.out::println);
        }
    }

}