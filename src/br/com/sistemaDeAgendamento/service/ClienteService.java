package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.DAO.ClienteDAO;
import br.com.sistemaDeAgendamento.model.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void verificarCli(Cliente cliente){
        if(cliente.getNome().isBlank() || !validarTelefoneCli(cliente.getTelefone())){
            throw new RuntimeException("Dados errados");
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

}
