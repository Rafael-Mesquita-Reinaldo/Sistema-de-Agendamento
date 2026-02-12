package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ClienteController;
import br.com.sistemaDeAgendamento.controller.ProfissionalController;
import br.com.sistemaDeAgendamento.controller.ServicoController;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuADM {
    private ClienteController clienteController = new ClienteController();
    private ProfissionalController profissionalController = new ProfissionalController();
    private ServicoController servicoController = new ServicoController();


    public void menu(Scanner scanner){
        System.out.print("1 - Opções sobre cliente\n2 - Opções sobre profissional\n3 - Opções sobre serviço\nEscolha(Digita o número):");
        int opcaoMenu = scanner.nextInt();
        scanner.nextLine();
        if(opcaoMenu == 1){
            opcoesCliente(scanner);
        } else if (opcaoMenu == 2) {
            opcoesProfissional(scanner);
        } else if (opcaoMenu == 3) {
            opcoesServico(scanner);

        }

    }

    private void opcoesServico(Scanner scanner) {
        System.out.print("1 - Cadastrar serviço\n2 - Listar tipos de serviço\n3 - Atualizar serviço\n4 - Deletar serviço\nEscolha(Digita o número): ");
        int opcaoServico = scanner.nextInt();
        scanner.nextLine();
        switch (opcaoServico){
            case 1:
                cadastrarServico(scanner);
                break;
            case 2:
                listarServico(scanner);
                break;
            case 3:
                atualizarServico(scanner);
                break;
            case 4:
                deletarServico(scanner);
                break;
            default:
                System.out.println("Opção inválida");
        }

    }

    private void deletarServico(Scanner scanner) {
        System.out.print("ID do Serviço: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        servicoController.deletarServico(id);
        System.out.println("Serviço deletado com sucesso!");
    }

    private void atualizarServico(Scanner scanner) {
        System.out.print("Deseja atulizar qual dado\n1 - Descrição\n2 - Duração do serviço\n(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1){
            System.out.print("ID do serviço: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova descrição: ");
            String novaDescricao = scanner.nextLine();

            servicoController.atualizarServDescricao(id,novaDescricao);
            System.out.println("Descrição alterada com sucesso");

        } else if (opcao == 2) {
            System.out.print("ID do profissional: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova Duração: ");
            int novaDuracao = scanner.nextInt();

            servicoController.atualizarServDuracao(id,novaDuracao);
            System.out.println("Especialidade alterado com sucesso");

        }
    }

    private void listarServico(Scanner scanner) {
        List<Servico> servicos = servicoController.listarServico();
        if(servicos.isEmpty()){
            System.out.println("Nenhum serviço cadastrado");
            return;
        }
        for (Servico servico: servicos){
            System.out.println(servico);
        }
    }

    private void cadastrarServico(Scanner scanner) {
        System.out.print("Descrição do Serviço:");
        String descricao = scanner.nextLine();

        System.out.print("Duração do Serviço:");
        int duracaoMinutos = scanner.nextInt();

        try {
            servicoController.cadastrarServico(descricao,duracaoMinutos);
            System.out.println("Serviço cadastrado com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void opcoesProfissional(Scanner scanner){
        System.out.print("1 - Cadastrar profissional\n2 - Listar profissionais\n3 - Atualizar dados profissional\n4 - Deletar profissional\nEscolha(Digita o número): ");
        int opcaoProfissional = scanner.nextInt();
        scanner.nextLine();
        switch (opcaoProfissional){
            case 1:
                cadastrarProfissional(scanner);
                break;
            case 2:
                listarProfissional(scanner);
                break;
            case 3:
                atualizarProfissional(scanner);
                break;
            case 4:
                deletarProfissional(scanner);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private void deletarProfissional(Scanner scanner) {
        System.out.print("ID do profissional: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        profissionalController.deletarProfissional(id);
        System.out.println("Profissional deletado com sucesso!");

    }

    private void atualizarProfissional(Scanner scanner) {
        System.out.print("Deseja atulizar qual dado\n1 - nome\n2 - especialidade\n(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1){
            System.out.print("ID do profissional: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Novo nome: ");
            String nomeNovo = scanner.nextLine();

            profissionalController.atualizarProNome(id,nomeNovo);
            System.out.println("Nome alterado com sucesso");

        } else if (opcao == 2) {
            System.out.print("ID do profissional: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova Especialidade: ");
            String novaEspecialidade = scanner.nextLine();

            profissionalController.atualizarProEspecialidade(id,novaEspecialidade);
            System.out.println("Especialidade alterado com sucesso");

        }
    }

    private void listarProfissional(Scanner scanner) {
        List<Profissional> profissionais = profissionalController.listarProfissional();
        if(profissionais.isEmpty()){
            throw new RuntimeException("Nenhum profissional cadastrado");
        }
        for(Profissional profissional : profissionais){
            System.out.println(profissional);
        }

    }

    private void cadastrarProfissional(Scanner scanner){

        System.out.print("nome:");
        String nome = scanner.nextLine();

        System.out.print("Especialidade:");
        String especialidade = scanner.nextLine();

        try {
            profissionalController.cadastrarProfissional(nome,especialidade);
            System.out.println("Profissional cadastrado com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
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
