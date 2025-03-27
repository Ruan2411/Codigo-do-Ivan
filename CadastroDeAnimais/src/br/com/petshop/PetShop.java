package br.com.petshop;

import java.util.ArrayList;

import java.util.Scanner;

public class petshop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animais = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n======================\n CADASTRO DE ANIMAIS\n======================\n");
            System.out.println("[1] - CADASTRAR CACHORRO");
            System.out.println("[2] - CADASTRAR GATO");
            System.out.println("[3] - CADASTRAR HAMSTER");
            System.out.println("[4] - EXIBIR CADASTROS");
            System.out.println("[5] - SAIR\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
            case 1:
                String nomeCachorro = Validacao.validarS(scanner, "NOME: ");
                String racaCachorro = Validacao.validarS(scanner, "RAÇA: ");
                int idadeCachorro = Validacao.validarI(scanner, "IDADE: ");

                animais.add(new Cachorro(nomeCachorro, idadeCachorro, racaCachorro));
                System.out.print("CACHORRO CADASTRADO!.");
                break;
            case 2:
                String nomeGato = Validacao.validarS(scanner, "NOME: ");
                String corPelo = Validacao.validarS(scanner, "COR DO PELO: ");
                int idadeGato = Validacao.validarI(scanner, "IDADE: ");
                animais.add(new Gato(nomeGato, idadeGato, corPelo));
                System.out.print("GATO CADASTRADO!.");
                break;
            case 3:
                String nomeHamster = Validacao.validarS(scanner, "NOME: ");
                String racaHamster = Validacao.validarS(scanner, "RAÇA: ");
                int idadeHamster = Validacao.validarI(scanner, "IDADE: ");
                animais.add(new Hamster(nomeHamster, idadeHamster, racaHamster)); 
                System.out.print("HAMSTER CADASTRADO!.");
                break;		
            case 4:
                System.out.println("\n===  LISTA DE CADASTROS  ===");
                for (Animal animal : animais) {
                    animal.exibirInfo();
                    System.out.println();
                }
                break;
            case 5:
                System.out.println("ENCERRANDO...");
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                break;
            }
        } while (opcao != 5);
        scanner.close();
    }
}
