package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ClienteController;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class MenuCliente {
    private final ClienteController clienteController = new ClienteController();

    public void menu(Scanner scanner){
        System.out.print("1 - Cadastro\n2 - Agendadmento\nEscolha(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){

            System.out.print("nome:");
            String nome = scanner.nextLine();

            System.out.print("telefone:");
            String telefone = scanner.nextLine();

            System.out.print("email(opcional):");
            String email = scanner.nextLine();
            try {
                clienteController.cadastrarCli(nome,telefone,email);
                System.out.print("Cliente cadastrado com sucesso!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }else {
            //ainda vou adicionar
        }
    }


    // Para o Administrado!!

    public void opcoesCliente(Scanner scanner){
        int opcao;
        do {
            System.out.print("1 - Cadastrar cliente\n2 - Listar clientes\n3 - Atualizar dados cliente\n4 - Deletar cliente\n0 - Sair \nEscolha(Digita o número): ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
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
            }

        }while (opcao != 0);
    }

    private void cadastrarCliente(Scanner scanner){
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
            System.out.println(e.getMessage());
        }
    }

    private void listarCliente(Scanner scanner){
        List<Cliente> clientes = clienteController.listarCli();
        if (clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado");
            return;
        }
        for (Cliente cliente :clientes){
            System.out.println(cliente);
        }
    }

    private void atualizarCliente(Scanner scanner){
        System.out.println("Lista de clientes: ");
        listarCliente(scanner);

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


    private void deletarCliente(Scanner scanner){
        System.out.println("Lista de clientes: ");
        listarCliente(scanner);

        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        clienteController.deletarCli(id);
        System.out.println("Cliente deletado com sucesso!");

    }

}
