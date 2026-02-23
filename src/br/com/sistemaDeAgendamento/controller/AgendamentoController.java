package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Agendamento;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;
import br.com.sistemaDeAgendamento.service.AgendamentoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendamentoController {
    AgendamentoService agendamentoService = new AgendamentoService();
    public void cadastrarAgendamento(Cliente cliente, Servico servico, Profissional profissional, LocalDate data, LocalTime horario) {
        Agendamento agendamento = new Agendamento(cliente,profissional,servico,data,horario);
        agendamentoService.CadastrarAgendamento(agendamento);
    }

    public List<Agendamento> listarAgendamento() {
        return agendamentoService.listarAgendamento();
    }

    public void atualizarNomeCli(int idAgendamento, int idNovoCli) {
        agendamentoService.atualizarNomeCli(idAgendamento,idNovoCli);
    }

    public void atualizarNomeProfissional(int idNovoProfissional, int idAgendamento) {
        agendamentoService.atualizarNomeProfissional(idAgendamento,idNovoProfissional);
    }

    public void atualizarDescServico(int idAgendamento, int idNovoServico) {
        agendamentoService.atualizarDescServico(idAgendamento,idNovoServico);
    }

    public void atualizarDataHora(int idAgendamento, LocalDate data, LocalTime novoHorario,int idProfissional) {
        agendamentoService.atualizarDataHora(idAgendamento,data,novoHorario,idProfissional);
    }

    public void deletarAgendamento(int id) {
        agendamentoService.deletarAgendamento(id);
    }
}
