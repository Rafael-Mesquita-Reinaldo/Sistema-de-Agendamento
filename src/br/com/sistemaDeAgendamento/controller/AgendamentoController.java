package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Agendamento;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;
import br.com.sistemaDeAgendamento.service.AgendamentoService;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoController {
    AgendamentoService agendamentoService = new AgendamentoService();
    public void cadastrarAgendamento(Cliente cliente, Servico servico, Profissional profissional, LocalDate data, LocalTime horario) {
        Agendamento agendamento = new Agendamento(cliente,profissional,servico,data,horario);
        agendamentoService.CadastrarAgendamento(agendamento);
    }
}
