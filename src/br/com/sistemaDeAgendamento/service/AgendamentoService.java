package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.AgendamentoDAO;
import br.com.sistemaDeAgendamento.model.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendamentoService {
    private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

    public void CadastrarAgendamento(Agendamento agendamento) {
        if(agendamento.getData().isBefore(LocalDate.now())){
            throw new RuntimeException("Não é possível agendar data no passado");
        }
        if (agendamento.getHora().isBefore(LocalTime.of(8,0)) ||  agendamento.getHora().isAfter(LocalTime.of(18,0))){
            throw new RuntimeException("Fora do Horário de atendimento");
        }
        boolean conflito = agendamentoDAO.verificarConflitoDAO(agendamento.getProfissional().getId(),agendamento.getData(),agendamento.getHora());
        if(conflito){
            throw new RuntimeException("Horário ocupado");
        }

        boolean respostaDao = agendamentoDAO.cadastrarAgendamento(agendamento);
        if (!respostaDao){
            throw new RuntimeException("Erro ao fazer o agendamento");
        }


    }

    public List<Agendamento> listarAgendamento() {
        return agendamentoDAO.listarAgendamento();
    }

    public void atualizarNomeCli(int idAgendamento, int idNovoCli) {
      boolean respostaDAO = agendamentoDAO.atualizarNomeCli(idAgendamento,idNovoCli);
      if (!respostaDAO){
          throw new RuntimeException("Erro ao Atualizar o novo cliente");
      }

    }

    public void atualizarNomeProfissional(int idAgendamento, int idNovoProfissional) {
        boolean respostaDAO = agendamentoDAO.atualizarNomeProfissional(idAgendamento,idNovoProfissional);
        if (!respostaDAO){
            throw new RuntimeException("Erro ao Atualizar o novo profissional");
        }
    }

    public void atualizarDescServico(int idAgendamento, int idNovoServico) {
        boolean respostaDAO = agendamentoDAO.atualizarDescServico(idAgendamento,idNovoServico);
        if (!respostaDAO){
            throw new RuntimeException("Erro ao Atualizar o novo serviço");
        }
    }

    public void atualizarDataHora(int idAgendamento, LocalDate data, LocalTime novoHorario,int idProfissional) {
        if(data.isBefore(LocalDate.now())){
            throw new RuntimeException("Não é possível marcar data no passado");
        }
        if (novoHorario.isBefore(LocalTime.of(8,0)) || novoHorario.isAfter(LocalTime.of(18,0))){
            throw new RuntimeException("Fora do Horário de atendimento");
        }
        boolean conflito = agendamentoDAO.verificarConflitoDAO(idProfissional,data,novoHorario);
        if(conflito){
            throw new RuntimeException("Horário ocupado");
        }

        boolean respostaDao = agendamentoDAO.atualizarDataHora(idAgendamento,data,novoHorario);
        if (!respostaDao){
            throw new RuntimeException("Erro ao atualizar data e horário");
        }
    }

    public void deletarAgendamento(int id) {
        boolean respostaDAO = agendamentoDAO.deletarAgendamento(id);
        if(!respostaDAO){
            throw new RuntimeException("Agendamento não encontrado");
        }
    }
}
