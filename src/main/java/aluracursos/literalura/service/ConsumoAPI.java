package aluracursos.literalura.service;

import aluracursos.literalura.dto.DatosRespuestaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public DatosRespuestaDTO obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            DatosRespuestaDTO datos = objectMapper.readValue(json, DatosRespuestaDTO.class);

            return datos;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener o procesar los datos de la API", e);
        }
    }
}


