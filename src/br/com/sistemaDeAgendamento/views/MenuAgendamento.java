package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.AgendamentoController;
import br.com.sistemaDeAgendamento.controller.ClienteController;
import br.com.sistemaDeAgendamento.controller.ProfissionalController;
import br.com.sistemaDeAgendamento.controller.ServicoController;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }while (opcaoServico !=0);
    }

    private void cadastrarAgendamento(Scanner scanner) {

        System.out.println("Digita o número do Cliente: ");
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
}
