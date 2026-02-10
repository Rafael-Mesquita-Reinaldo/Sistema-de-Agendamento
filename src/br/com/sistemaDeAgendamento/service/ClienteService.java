package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.ClienteDAO;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarCli(Cliente cliente){
        if(cliente.getNome().isBlank() || !validarTelefoneCli(cliente.getTelefone())){
            throw new RuntimeException("Nome ou telefone inválido");
        }
        boolean respostaDAO = clienteDAO.incluirCli(cliente);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao cadastrar o cliente");
        }

    }
    private boolean validarTelefoneCli(String telefone){
        String telefoneLimpo = telefone.replaceAll("[^\\d]","");
        return telefoneLimpo.matches("\\d{10,11}");
    }

    public List<Cliente> listarCli(){
        return clienteDAO.listarCli();
    }

    public void atualizarCliNome(int id,String nomeNovo){
        if(nomeNovo.isBlank()){
            throw new RuntimeException("Nome inválido");
        }
        boolean respostaDAO = clienteDAO.atualizarCliNome(id,nomeNovo);

        if(!respostaDAO){
            throw new RuntimeException("Erro ao atualizar nome");
        }

    }
    public void atualizarCliTelefone(int id, String novoTelefone){
        if(!validarTelefoneCli(novoTelefone)){
            throw new RuntimeException("Telefone inválido");
        }
        boolean respostaDAO = clienteDAO.atualizarCliTelefone(id,novoTelefone);
        if(!respostaDAO){
            throw new RuntimeException("Erro ao atualizar telefone");
        }

    }

    public void atualizarCliEmail(int id, String novoEmail){
        if(novoEmail.isBlank()){
            throw new RuntimeException("Email inválido");
        }
        boolean respostaDAO = clienteDAO.atualizarCliEmail(id,novoEmail);

        if(!respostaDAO){
            throw new RuntimeException("Erro ao email ");
        }

    }

    public void deletarCli(int id){
        boolean respostaDAO = clienteDAO.deletarCli(id);
        if (!respostaDAO){
            throw new RuntimeException("Cliente não encontrado");
        }
    }

}
