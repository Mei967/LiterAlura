package aluracursos.literalura.principal;

import aluracursos.literalura.service.ConsumoAPI;


    public class Principal {
        public static void main(String[] args) {
            ConsumoAPI consumo = new ConsumoAPI();
            String url = "https://gutendex.com/books";
            String json = consumo.obtenerDatos(url);
            System.out.println("Respuesta JSON recibida:");

            System.out.println(json); // Verifica si trae bien los datos
        }
    }

