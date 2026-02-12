package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Servico;
import br.com.sistemaDeAgendamento.service.ServicoService;

import java.util.List;

public class ServicoController {
    private ServicoService servicoService  = new ServicoService();

    public void cadastrarServico(String descricao, int duracaoMinutos) {
        Servico servico = new Servico(descricao,duracaoMinutos);
        servicoService.cadastrarServico(servico);
    }

    public List<Servico> listarServico() {
        return servicoService.listarServico();

    }

    public void atualizarServDescricao(int id, String novaDescricao) {
        servicoService.atualizarServDescricao(id,novaDescricao);

    }
    public void atualizarServDuracao(int id, int novaDuracao) {
        servicoService.atualizarServDuracao(id,novaDuracao);

    }

    public void deletarServico(int id) {
        servicoService.deletarServico(id);
    }
}
