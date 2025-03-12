package br.com.petshop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetShop {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Animal> animais = new ArrayList<>();
    
    // Listas de raças e cores permitidas
    private static final List<String> racasCachorro = List.of("Labrador", "Poodle", "Bulldog", "Beagle");
    private static final List<String> coresGato = List.of("Preto", "Branco", "Cinza", "Tigrado");

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarAnimal("cachorro");
                    break;
                case 2:
                    cadastrarAnimal("gato");
                    break;
                case 3:
                    exibirAnimais();
                    break;
                case 4:
                    removerTodosAnimais();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Cadastrar Cachorro");
        System.out.println("2 - Cadastrar Gato");
        System.out.println("3 - Exibir Animais");
        System.out.println("4 - Remover Todos os Animais");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        int opcao = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        return opcao;
    }

    private static void cadastrarAnimal(String tipo) {
        System.out.print("Nome do " + tipo + ": ");
        String nome = scanner.nextLine();
        System.out.print("Idade do " + tipo + ": ");
        int idade = lerIdade();
        
        if (tipo.equals("cachorro")) {
            String raca = escolherRaca();
            animais.add(new Cachorro(nome, idade, raca));
            System.out.println("Cachorro cadastrado com sucesso!");
        } else if (tipo.equals("gato")) {
            String corPelo = escolherCor();
            animais.add(new Gato(nome, idade, corPelo));
            System.out.println("Gato cadastrado com sucesso!");
        }
    }

    private static String escolherRaca() {
        System.out.println("Escolha a raça do cachorro:");
        for (int i = 0; i < racasCachorro.size(); i++) {
            System.out.println((i + 1) + " - " + racasCachorro.get(i));
        }
        int escolha = lerOpcaoEntre(1, racasCachorro.size());
        return racasCachorro.get(escolha - 1);
    }

    private static String escolherCor() {
        System.out.println("Escolha a cor do pelo do gato:");
        for (int i = 0; i < coresGato.size(); i++) {
            System.out.println((i + 1) + " - " + coresGato.get(i));
        }
        int escolha = lerOpcaoEntre(1, coresGato.size());
        return coresGato.get(escolha - 1);
    }

    private static int lerOpcaoEntre(int min, int max) {
        int opcao = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                if (opcao < min || opcao > max) {
                    System.out.println("Por favor, escolha uma opção válida entre " + min + " e " + max + ".");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        return opcao;
    }

    private static void exibirAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            System.out.println("\n=== Lista de Animais ===");
            for (Animal animal : animais) {
                animal.exibirInfo();
            }
        }
    }

    private static void removerTodosAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Não há animais cadastrados para remover.");
        } else {
            animais.clear();
            System.out.println("Todos os animais foram removidos com sucesso!");
        }
    }

    private static int lerIdade() {
        int idade = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                idade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                if (idade < 0) {
                    System.out.println("A idade deve ser um número positivo. Tente novamente.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        return idade;
    }
}
