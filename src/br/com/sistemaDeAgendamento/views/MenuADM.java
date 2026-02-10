package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ClienteController;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class MenuADM {
    private ClienteController clienteController = new ClienteController();


    public void menu(Scanner scanner){
        System.out.print("1 - Opções sobre cliente\n2 - Opções sobre profissional\n3 - Opções sobre serviço\nEscolha(Digita o número):");
        int opcaoMenu = scanner.nextInt();
        scanner.nextLine();
        if(opcaoMenu == 1){
            opcoesCliente(scanner);
        }

    }

    public void opcoesCliente(Scanner scanner){
        System.out.print("1 - Cadastrar cliente\n2 - Listar clientes\n3 - Atualizar dados cliente\n4 - Deletar cliente\nEscolha(Digita o número): ");
        int opcaoCliente = scanner.nextInt();
        scanner.nextLine();
        switch (opcaoCliente){
            case 1:
                cadastrarCliente(scanner);
                break;
            case 2:
                listarCliente(scanner);
                break;
            case 3:
                atualizarCliente(scanner);
                break;
            case 4:
                deletarCliente(scanner);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public void cadastrarCliente(Scanner scanner){
        System.out.print("nome:");
        String nome = scanner.nextLine();

        System.out.print("telefone:");
        String telefone = scanner.nextLine();

        System.out.print("email(opcional):");
        String email = scanner.nextLine();

        try {
            clienteController.cadastrarCli(nome,telefone,email);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void listarCliente(Scanner scanner){
        List<Cliente> clientes = clienteController.listarCli();
        if (clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado");
            return;
        }
        for (Cliente cliente :clientes){
            System.out.println(cliente);
        }
    }
    public void atualizarCliente(Scanner scanner){
        System.out.print("Deseja atulizar qual dado\n1 - nome\n2 - telefone\n3 - email\nEscolhar(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            System.out.print("ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Novo nome: ");
            String nomeNovo = scanner.nextLine();

            clienteController.atualizarCliNome(id,nomeNovo);
        } else if (opcao == 2) {
            System.out.print("ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Novo telefone: ");
            String novoTelefone = scanner.nextLine();
            clienteController.atualizarCliTelefone(id,novoTelefone);

        }else if (opcao == 3) {

            System.out.print("ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Novo email: ");
            String novoEmail = scanner.nextLine();
            clienteController.atualizarCliEmail(id,novoEmail);
        }
    }
    public void deletarCliente(Scanner scanner){
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        clienteController.deletarCli(id);
        System.out.println("Cliente deletado com sucesso!");

    }

}
