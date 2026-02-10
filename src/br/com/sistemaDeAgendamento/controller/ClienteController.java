package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.service.ClienteService;

import java.util.List;

public class ClienteController {
    private ClienteService clienteService = new ClienteService();

    public void cadastrarCli(String nome,String telefone,String email){
        Cliente cliente = new Cliente(nome,telefone,email);
         clienteService.cadastrarCli(cliente);
    }

    public List<Cliente> listarCli(){
         return clienteService.listarCli();
    }

    public void atualizarCliNome(int id,String nomeNovo){
        clienteService.atualizarCliNome(id,nomeNovo);
    }
    public void atualizarCliTelefone(int id,String novoTelefone){
        clienteService.atualizarCliTelefone(id,novoTelefone);
    }
    public void atualizarCliEmail(int id,String novoEmail){
        clienteService.atualizarCliEmail(id,novoEmail);
    }

    public void deletarCli(int id){
        clienteService.deletarCli(id);

    }
}
