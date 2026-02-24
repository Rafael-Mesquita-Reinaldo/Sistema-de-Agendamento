package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.AgendamentoController;
import br.com.sistemaDeAgendamento.controller.ClienteController;
import br.com.sistemaDeAgendamento.controller.ProfissionalController;
import br.com.sistemaDeAgendamento.controller.ServicoController;
import br.com.sistemaDeAgendamento.model.Agendamento;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuAgendamento {
    private ServicoController servicoController = new ServicoController();
    private ProfissionalController profissionalController = new ProfissionalController();
    private ClienteController clienteController  = new ClienteController();
    private AgendamentoController agendamentoController = new AgendamentoController();

    public void opcoesAgendamento(Scanner scanner) {
        int opcaoServico;

        do {
            System.out.print("1 - Cadastrar agendamento\n2 - Listar agendamentos\n3 - Atualizar agendamento\n4 - Deletar agendamento\n0 - Sair\nEscolha(Digita o número): ");
            opcaoServico = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoServico){
                case 1:
                   cadastrarAgendamento(scanner);
                    break;
                case 2:
                    listarAgendamento();
                    break;
                case 3:
                    atualizarAgendamento(scanner);
                    break;
                case 4:
                    deletarAgendamento(scanner);

                    break;
            }
        }while (opcaoServico !=0);
    }

    private void cadastrarAgendamento(Scanner scanner) {

        System.out.print("Digita o número do Cliente: ");
        String numeroCliente = scanner.nextLine();
        Cliente cliente  = clienteController.selecionarCli(numeroCliente);

        System.out.println("Seleciona um serviço pelo ID");
        servicoController.listarServico();
        System.out.print("Escolhar: ");
        int opcaoServico = scanner.nextInt();
        scanner.nextLine();
        Servico servico = servicoController.selecionarServico(opcaoServico);

        System.out.println("Seleciona um profissional pelo ID ");
        profissionalController.listarProfissional();
        System.out.print("Escolhar: ");
        int opcaoProfissional = scanner.nextInt();
        scanner.nextLine();
        Profissional profissional = profissionalController.selecionarProfissional(opcaoProfissional);

        System.out.println("Escolha o dia e mês(dd/mm): ");
        String dataAtendimento = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataAtendimento+"/"+LocalDate.now().getYear(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Escolha o horário(H:M): ");
        LocalTime horario =  LocalTime.parse(scanner.nextLine());

        try {
            agendamentoController.cadastrarAgendamento(cliente,servico,profissional,data,horario);
            System.out.println("Agendamento realizado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    // Menu de agendamento para cliente
    public void cadastrarAgendamentoCli(Scanner scanner) {

        System.out.print("Digita seu telefone do Cliente: ");
        String numeroCliente = scanner.nextLine();
        Cliente cliente  = clienteController.selecionarCli(numeroCliente);

        System.out.println("Seleciona um serviço pelo ID");
        servicoController.listarServico();
        System.out.print("Escolhar: ");
        int opcaoServico = scanner.nextInt();
        scanner.nextLine();
        Servico servico = servicoController.selecionarServico(opcaoServico);

        System.out.println("Seleciona um profissional pelo ID ");
        profissionalController.listarProfissional();
        System.out.print("Escolhar: ");
        int opcaoProfissional = scanner.nextInt();
        scanner.nextLine();
        Profissional profissional = profissionalController.selecionarProfissional(opcaoProfissional);

        System.out.println("Escolha o dia e mês(dd/mm): ");
        String dataAtendimento = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataAtendimento+"/"+LocalDate.now().getYear(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Escolha o horário(H:M): ");
        LocalTime horario =  LocalTime.parse(scanner.nextLine());

        try {
            agendamentoController.cadastrarAgendamento(cliente,servico,profissional,data,horario);
            System.out.println("Agendamento realizado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAgendamento() {
        List<Agendamento> agendamentos = agendamentoController.listarAgendamento();
        if(agendamentos.isEmpty()){
            System.out.println("Nenhum agendamento cadastrado");
            return;
        }
        for (Agendamento agendamento : agendamentos){
            System.out.println(agendamento);
        }

    }

    private void atualizarAgendamento(Scanner scanner) {
        System.out.println("Lista de Agendamentos: ");
        listarAgendamento();
        System.out.print("Digita o ID do agendamento: ");
        int idAgendamento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Deseja atulizar qual dado\n1 - Trocar Cliente\n2 - Trocar profissional\n3 - Trocar serviço\n4 - Mudar data e hora\nEscolhar(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            List<Cliente> clientes = clienteController.listarCli();
            System.out.println("Lista de clientes:");
            for (Cliente cliente: clientes){
                System.out.println(cliente);
            }
            System.out.print("Seleciona o novo cliente para esse agendamento(Digita o ID): ");
            int idNovoCli = scanner.nextInt();
            try {
                agendamentoController.atualizarNomeCli(idAgendamento,idNovoCli);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Cliente alterado com sucesso");
        } else if (opcao == 2) {

            List<Profissional> profissionais = profissionalController.listarProfissional();
            System.out.println("Lista de profissionais:");
            for (Profissional profissional: profissionais){
                System.out.println(profissional);
            }
            System.out.print("Seleciona o novo profissional para esse agendamento(Digita o ID): ");
            int idNovoProfissional = scanner.nextInt();

            agendamentoController.atualizarNomeProfissional(idNovoProfissional,idAgendamento);
            System.out.println("Profissional alterado com sucesso");

        } else if (opcao == 3) {
            List<Servico> servicos = servicoController.listarServico();
            System.out.println("Lista de serviços:");
            for (Servico servico: servicos){
                System.out.println(servico);
            }
            System.out.print("Seleciona o novo serviço para esse agendamento(Digita o ID): ");
            int idNovoServico = scanner.nextInt();
            agendamentoController.atualizarDescServico(idAgendamento,idNovoServico);
            System.out.println("Serviço alterado com sucesso");

        }else if (opcao == 4) {
            System.out.println("Digita o ID do profissional:");
            int idProfissional = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Escolha o novo dia e mês(dd/mm): ");
            String novaDataAtendimento = scanner.nextLine();
            LocalDate data = LocalDate.parse(novaDataAtendimento+"/"+LocalDate.now().getYear(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Escolha o novo horário(H:M): ");
            LocalTime novoHorario =  LocalTime.parse(scanner.nextLine());

            agendamentoController.atualizarDataHora(idAgendamento,data,novoHorario,idProfissional);
            System.out.println("Nova data e horário alterado com sucesso");

        }

    }

    private void deletarAgendamento(Scanner scanner) {
        System.out.println("Lista de Agendamentos: ");
        listarAgendamento();

        System.out.print("ID do agendamento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        agendamentoController.deletarAgendamento(id);
        System.out.println("Agendamento deletado com sucesso!");
    }
}
