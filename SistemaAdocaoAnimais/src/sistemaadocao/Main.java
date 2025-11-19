package sistemaadocao;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BancoDeDados bd = BancoDeDados.carregar();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA DE ADOÇÃO DE ANIMAIS =====");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Listar animais");
            System.out.println("3 - Cadastrar adotante");
            System.out.println("4 - Listar adotantes");
            System.out.println("5 - Realizar adoção");
            System.out.println("6 - Listar adoções");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String linha = scanner.nextLine();

            try {
                opcao = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarAnimal(scanner, bd);
                    break;
                case 2:
                    listarAnimais(bd);
                    break;
                case 3:
                    cadastrarAdotante(scanner, bd);
                    break;
                case 4:
                    listarAdotantes(bd);
                    break;
                case 5:
                    realizarAdocao(scanner, bd);
                    break;
                case 6:
                    listarAdocoes(bd);
                    break;
                case 0:
                    System.out.println("Saindo... Até mais!");
                    bd.salvar();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }


    private static void cadastrarAnimal(Scanner scanner, BancoDeDados bd) {
        System.out.println("\n--- Cadastro de Animal ---");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.print("Tipo: ");
        String tipoStr = scanner.nextLine();

        int tipo;
        try {
            tipo = Integer.parseInt(tipoStr);
        } catch (NumberFormatException e) {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade;
        try {
            idade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida.");
            return;
        }

        System.out.print("Raça: ");
        String raca = scanner.nextLine();

        int id = bd.gerarIdAnimal();
        Animal animal = null;

        if (tipo == 1) {
            animal = new Cachorro(id, nome, idade, raca);
        } else if (tipo == 2) {
            animal = new Gato(id, nome, idade, raca);
        } else {
            System.out.println("Tipo de animal inválido.");
            return;
        }

        bd.getAnimais().add(animal);
        bd.salvar();
        System.out.println("Animal cadastrado com sucesso! ID = " + id);
    }

    private static void listarAnimais(BancoDeDados bd) {
        System.out.println("\n--- Lista de Animais ---");
        List<Animal> lista = bd.getAnimais();
        if (lista.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal a : lista) {
                System.out.println(a);
            }
        }
    }

    private static void cadastrarAdotante(Scanner scanner, BancoDeDados bd) {
        System.out.println("\n--- Cadastro de Adotante ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        int id = bd.gerarIdAdotante();
        Adotante adotante = new Adotante(id, nome, cpf, telefone);

        bd.getAdotantes().add(adotante);
        bd.salvar();

        System.out.println("Adotante cadastrado com sucesso! ID = " + id);
    }

    private static void listarAdotantes(BancoDeDados bd) {
        System.out.println("\n--- Lista de Adotantes ---");
        List<Adotante> lista = bd.getAdotantes();
        if (lista.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
        } else {
            for (Adotante a : lista) {
                System.out.println(a);
            }
        }
    }

    private static void realizarAdocao(Scanner scanner, BancoDeDados bd) {
        System.out.println("\n--- Realizar Adoção ---");

        System.out.print("ID do adotante: ");
        int idAdotante;
        try {
            idAdotante = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        System.out.print("ID do animal: ");
        int idAnimal;
        try {
            idAnimal = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        try {
            bd.realizarAdocao(idAdotante, idAnimal);
        } catch (LimiteAdocoesException | AnimalIndisponivelException e) {
            System.out.println("Erro na adoção: " + e.getMessage());
        }
    }

    private static void listarAdocoes(BancoDeDados bd) {
        System.out.println("\n--- Lista de Adoções ---");
        List<Adocao> lista = bd.getAdocoes();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma adoção registrada.");
        } else {
            for (Adocao a : lista) {
                System.out.println(a);
            }
        }
    }
}
