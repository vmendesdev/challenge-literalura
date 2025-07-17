package com.alura.literalura.controller;

import java.util.Scanner;

// Esta classe gerencia o menu interativo que será exibido no terminal.
public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);
    private boolean executando = true;

    public void exibir() {
        while (executando) {
            System.out.println("\n=== MENU LITERALURA ===");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros por idioma");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    buscarLivroPorTitulo();
                    break;
                case "2":
                    listarLivrosRegistrados();
                    break;
                case "3":
                    listarAutoresRegistrados();
                    break;
                case "4":
                    listarAutoresVivosPorAno();
                    break;
                case "5":
                    listarLivrosPorIdioma();
                    break;
                case "6":
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Chamado quando o usuário escolhe "1"
    private void buscarLivroPorTitulo() {
        System.out.println(">>> Funcionalidade de buscar livro por título ainda será implementada.");
    }

    private void listarLivrosRegistrados() {
        System.out.println(">>> Funcionalidade de listar livros será implementada.");
    }

    private void listarAutoresRegistrados() {
        System.out.println(">>> Funcionalidade de listar autores será implementada.");
    }

    private void listarAutoresVivosPorAno() {
        System.out.println(">>> Funcionalidade de listar autores vivos será implementada.");
    }

    private void listarLivrosPorIdioma() {
        System.out.println(">>> Funcionalidade de listar livros por idioma será implementada.");
    }

    private void sair() {
        System.out.println("Saindo do programa...");
        executando = false;
    }
}
