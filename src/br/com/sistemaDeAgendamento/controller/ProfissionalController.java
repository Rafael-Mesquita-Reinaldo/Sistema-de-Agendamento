package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.service.ProfissionalService;

import java.util.List;

public class ProfissionalController {
    private ProfissionalService profissionalService = new ProfissionalService();

    public void cadastrarProfissional(String nome,String especialidade){
        Profissional profissional = new Profissional(nome,especialidade);
        profissionalService.cadastrarProfissional(profissional);
    }

    public List<Profissional> listarProfissional() {
        return profissionalService.listarProfissional();
    }

    public void atualizarProNome(int id, String nomeNovo) {
        profissionalService.atualizarProNome(id,nomeNovo);
    }
    public void atualizarProEspecialidade(int id, String nomeNovo) {
        profissionalService.atualizarProEspecialidade(id,nomeNovo);
    }

    public void deletarProfissional(int id) {
        profissionalService.deletarProfissional(id);
    }
}
