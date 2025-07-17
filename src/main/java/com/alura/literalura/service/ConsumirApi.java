package com.alura.literalura.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsumirApi {
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private final HttpClient cliente = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Busca livros pelo título informado, chamando a API Gutendex.
     * @param titulo título a ser pesquisado
     * @return nó JSON com os dados retornados
     */
    public JsonNode buscarLivroPorTitulo(String titulo) {
        String url = URL_BASE + titulo.replace(" ", "%20");

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readTree(resposta.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao buscar dados da API: " + e.getMessage());
            return null;
        }
    }
}