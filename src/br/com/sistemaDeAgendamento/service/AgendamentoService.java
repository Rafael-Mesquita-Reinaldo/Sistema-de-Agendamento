package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.AgendamentoDAO;
import br.com.sistemaDeAgendamento.model.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoService {
    private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

    public void CadastrarAgendamento(Agendamento agendamento) {
        if(agendamento.getData().isBefore(LocalDate.now())){
            throw new RuntimeException("Não é possivel agendar data no passado");
        }
        if (agendamento.getHora().isBefore(LocalTime.of(8,0)) ||  agendamento.getHora().isAfter(LocalTime.of(18,0))){
            throw new RuntimeException("Fora do Horário de atendimento");
        }
        boolean conflito = AgendamentoDAO.verificarConflitoDAO(agendamento);

        boolean respostaDao = agendamentoDAO.cadastrarAgendamento(agendamento);
        if (!respostaDao){
            throw new RuntimeException("Erro ao fazer o agendamento");
        }


    }
}
