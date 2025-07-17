package com.alura.literalura.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepositorio;
import com.alura.literalura.repository.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Classe de serviço responsável por processar e salvar livros e autores
@Service
public class ServicoLiteralura {

    @Autowired
    private ConsumirApi consumoApi;

    @Autowired
    private LivroRepositorio livroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    /**
     * Busca um livro na API pelo título, cria os objetos Livro e Autor,
     * e os salva no banco de dados.
     *
     * @param titulo título do livro a ser buscado
     */
    public void buscarELancarLivro(String titulo) {
        JsonNode resultado = consumoApi.buscarLivroPorTitulo(titulo);

        if (resultado != null && resultado.has("results") && resultado.get("results").size() > 0) {
            JsonNode livroJson = resultado.get("results").get(0); // pega o primeiro resultado

            String tituloLivro = livroJson.get("title").asText();
            String idioma = livroJson.get("languages").get(0).asText();
            int numeroDownloads = livroJson.get("download_count").asInt();

            // Extrair dados do autor
            JsonNode autorJson = livroJson.get("authors").get(0);
            String nomeAutor = autorJson.get("name").asText();
            Integer anoNascimento = autorJson.has("birth_year") && !autorJson.get("birth_year").isNull()
                    ? autorJson.get("birth_year").asInt() : null;
            Integer anoFalecimento = autorJson.has("death_year") && !autorJson.get("death_year").isNull()
                    ? autorJson.get("death_year").asInt() : null;

            // Verifica se o autor já existe
            Optional<Autor> autorExistente = autorRepositorio.findByNomeAndAnoNascimento(nomeAutor, anoNascimento);
            Autor autor = autorExistente.orElseGet(() -> {
                Autor novoAutor = new Autor();
                novoAutor.setNome(nomeAutor);
                novoAutor.setAnoNascimento(anoNascimento);
                novoAutor.setAnoFalecimento(anoFalecimento);
                return autorRepositorio.save(novoAutor);
            });

            // Verifica se o livro já existe
            boolean livroJaExiste = livroRepositorio.existsByTituloAndIdioma(tituloLivro, idioma);
            if (!livroJaExiste) {
                Livro livro = new Livro();
                livro.setTitulo(tituloLivro);
                livro.setIdioma(idioma);
                livro.setNumeroDownloads(numeroDownloads);
                livro.setAutor(autor);

                livroRepositorio.save(livro);
                System.out.println("Livro salvo com sucesso: " + tituloLivro);
            } else {
                System.out.println("Livro já registrado no banco de dados.");
            }
        } else {
            System.out.println("Nenhum livro encontrado com o título informado.");
        }
    }
}
