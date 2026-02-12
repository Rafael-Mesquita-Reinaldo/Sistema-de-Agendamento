package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.ServicoDAO;
import br.com.sistemaDeAgendamento.model.Servico;

import java.util.List;

public class ServicoService {
    ServicoDAO servicoDAO = new ServicoDAO();

    public void cadastrarServico(Servico servico){
        if(servico.getDescricao().isBlank()){
            throw new RuntimeException("Descrição inválida");
        } else if (servico.getDuracaoMinutos() <=0) {
            throw new RuntimeException("Duração do serviço inválida");
        }
        boolean respostaDAO = servicoDAO.cadastrarServico(servico);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao cadastrar serviço");
        }
    }

    public List<Servico> listarServico() {
        List<Servico> servicos = servicoDAO.listarServico();
        return servicos;
    }

    public void atualizarServDescricao(int id, String novaDescricao) {
        if(novaDescricao.isBlank()){
            throw new RuntimeException("Descrição inválida");
        }
        boolean respostaDAO = servicoDAO.atualizarServDescricao(id,novaDescricao);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao atualizar a descrição");
        }
    }

    public void atualizarServDuracao(int id,int novaDuracao) {
        if(novaDuracao<=0){
            throw new RuntimeException("Duração inválida");
        }
        boolean respostaDAO = servicoDAO.atualizarServDuracao(id,novaDuracao);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao atualizar a duração");
        }
    }

    public void deletarServico(int id) {
        boolean respostaDAO = servicoDAO.deletarServico(id);
        if (!respostaDAO){
            throw new RuntimeException("Serviço não encontrado");
        }
    }
}
