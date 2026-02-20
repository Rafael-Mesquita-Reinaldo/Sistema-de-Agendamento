package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.ProfissionalDAO;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;

import java.util.List;

public class ProfissionalService {
    private ProfissionalDAO profissionalDAO = new ProfissionalDAO();

    public void cadastrarProfissional(Profissional profissional){
        if(profissional.getNome().isBlank() || profissional.getEspecialidade().isBlank()){
            throw new RuntimeException("Nome ou especilidade inválido");
        }
        boolean respostaDAO = profissionalDAO.incluirProfissional(profissional);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao cadastrar o profissional");
        }
    }

    public List<Profissional> listarProfissional() {
        return profissionalDAO.listarProfissional();
    }

    public void atualizarProNome(int id, String nomeNovo) {
        if(nomeNovo.isBlank()){
            throw new RuntimeException("Nome inválido");
        }
        boolean respostaDAO = profissionalDAO.atualizarProNome(id,nomeNovo);
        if (!respostaDAO){
            throw new RuntimeException("Erro ao atualizar nome");
        }
    }

    public void atualizarProEspecialidade(int id, String especialidadeNova) {
        if(especialidadeNova.isBlank()){
            throw new RuntimeException("Especialidade inválida");
        }
        boolean respostaDAO = profissionalDAO.atualizarProEspecialidade(id,especialidadeNova);
        if (!respostaDAO){
            throw new RuntimeException("Erro ao atualizar a especialidade");
        }
    }

    public void deletarProfissional(int id) {
        boolean respostaDAO = profissionalDAO.deletarProfissional(id);
        if(!respostaDAO){
            throw new RuntimeException("Profissional não encontrado");
        }
    }

    public Profissional selecionarProfissional(int id) {
        if(id <=0 ){
            throw new RuntimeException("Id inválido");
        }
        Profissional profissional = profissionalDAO.selecionarProfissional(id);
        if(profissional == null){
            throw new RuntimeException("Nenhum profissional encontrado");
        }
        return profissional;

    }
}
