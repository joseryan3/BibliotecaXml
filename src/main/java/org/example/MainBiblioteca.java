package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainBiblioteca {

    private static final BibliotecaManager manager = new BibliotecaManager("biblioteca.xml");
    private static final Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca;




    public static void main(String[] args) {
      biblioteca = manager.carregar();
      System.out.println("Bem-vindo ao Gerenciador de Java.Biblioteca!");
      System.out.println(biblioteca.getLivros().size() + "Livro(s) carregado(s).");



      int opcao = 0;
      while (opcao != 3) {
          exibirMenu();
          try {
              opcao = scanner.nextInt();
              scanner.nextInt(); //limpar buffer


              switch (opcao) {
                  case 1:
                      adiconarLivro();
                      break;
                  case 2:
                      listarLivros();
                      break;
                  case 3:
                      System.out.println("salvando e saindo...");
                      break;
                  default: System.out.println("opção invalida!"); break;
              }
          }catch (InputMismatchException e){
              System.out.println("erro: por favor, digite um número. ");
              scanner.nextLine(); //Descarte a entrada inválida
          }
      }

      manager.salvar(biblioteca);
      System.out.println("Java.Biblioteca salva em 'biblioteca.xml'. Até mais! ");
      scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n---- MENU ----");
        System.out.println("1. Adicionar novo livro");
        System.out.println("2. listar todos os livros");
        System.out.println("3. Sair e SAlvar");
        System.out.println("Escolha uma opção");
    }

    private static void adiconarLivro() {
        System.out.println("\n----- Adicionar Java.livro -----");
        try {
            System.out.println("Titulo: ");
            String titulo = scanner.nextLine();
            System.out.println("Auto: ");
            String autor = scanner.nextLine();
            System.out.println("Ano de publicação: ");
            int ano = scanner.nextInt();
            scanner.nextLine(); //Limpa o buffer

            biblioteca.getLivros().add(new Livro(titulo, autor, ano));
            System.out.println("Java.livro adicionando com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: O ano deve ser um némero");
            scanner.nextLine();// Limpa o buffer

        }
    }
    private static void listarLivros() {
        System.out.println("\n--- Livros na java.biblioteca ---");
        if (biblioteca.getLivros().isEmpty()){
            System.out.println("Nenhum livros cadastrados");
        } else {
            biblioteca.getLivros().forEach(System.out::println);
        }
    }
}