package com.alura.literalura.controller;

import com.alura.literalura.model.Livro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.LivroRepositorio;
import com.alura.literalura.repository.AutorRepositorio;
import com.alura.literalura.service.ServicoLiteralura;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Scanner;

/**
 * Classe que representa o menu principal da aplicação,
 * exibido no console após a inicialização da aplicação Spring Boot.
 */
@Component
public class MenuPrincipal {

    @Autowired
    private ServicoLiteralura servicoLiteralura;

    @Autowired
    private LivroRepositorio livroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    private final Scanner scanner = new Scanner(System.in);


    public void iniciarMenu() {
        int opcao = -1;

        while (opcao != 4) {
            exibirMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> buscarLivro();
                case 2 -> listarLivros();
                case 3 -> listarAutores();
                case 4 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n===== Menu Principal LiterAlura =====");
        System.out.println("1 - Buscar livro por título");
        System.out.println("2 - Listar livros registrados");
        System.out.println("3 - Listar autores registrados");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void buscarLivro() {
        System.out.print("Digite o título do livro que deseja buscar: ");
        String titulo = scanner.nextLine();
        servicoLiteralura.buscarELancarLivro(titulo);
    }

    private void listarLivros() {
        List<Livro> livros = livroRepositorio.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            livros.forEach(livro -> System.out.println(
                    "📚 " + livro.getTitulo() + " | Autor: " + livro.getAutor().getNome() +
                            " | Idioma: " + livro.getIdioma() +
                            " | Downloads: " + livro.getNumeroDownloads()
            ));
        }
    }

    private void listarAutores() {
        List<Autor> autores = autorRepositorio.findAll();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado.");
        } else {
            autores.forEach(autor -> System.out.println(
                    "👤 " + autor.getNome() +
                            " | Nascimento: " + autor.getAnoNascimento() +
                            " | Falecimento: " + autor.getAnoFalecimento()
            ));
        }
    }
}
