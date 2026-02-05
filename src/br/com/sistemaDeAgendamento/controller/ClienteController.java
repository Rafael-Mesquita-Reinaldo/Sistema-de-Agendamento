package br.com.sistemaDeAgendamento.controller;

import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.service.ClienteService;

public class ClienteController {
    private ClienteService clienteService = new ClienteService();

    public void cadastrarCli(String nome,String telefone,String email){
        Cliente cliente = new Cliente(nome,telefone,email);
         clienteService.verificarCli(cliente);
    }
}
