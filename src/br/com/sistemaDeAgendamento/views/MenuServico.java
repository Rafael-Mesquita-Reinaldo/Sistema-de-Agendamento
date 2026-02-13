package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ServicoController;
import br.com.sistemaDeAgendamento.model.Servico;

import java.util.List;
import java.util.Scanner;

public class MenuServico {
    private ServicoController servicoController = new ServicoController();

    public void opcoesServico(Scanner scanner) {
        int opcaoServico;

        do {
            System.out.print("1 - Cadastrar serviço\n2 - Listar tipos de serviço\n3 - Atualizar serviço\n4 - Deletar serviço\n0 - Sair\nEscolha(Digita o número): ");
            opcaoServico = scanner.nextInt();
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
            }
        }while (opcaoServico !=0);
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
            System.out.println(e.getMessage());
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

    private void atualizarServico(Scanner scanner) {
        System.out.println("Lista de Serviços:");
        listarServico(scanner);
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
            System.out.print("ID do Serviço: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova Duração: ");
            int novaDuracao = scanner.nextInt();
            scanner.nextLine();

            servicoController.atualizarServDuracao(id,novaDuracao);
            System.out.println("Duração alterada com sucesso");

        }
    }

    private void deletarServico(Scanner scanner) {
        System.out.println("Lista de Serviços:");
        listarServico(scanner);
        System.out.print("ID do Serviço: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        servicoController.deletarServico(id);
        System.out.println("Serviço deletado com sucesso!");
    }
}
