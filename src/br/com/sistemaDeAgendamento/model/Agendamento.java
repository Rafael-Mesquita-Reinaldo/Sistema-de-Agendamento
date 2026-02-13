package br.com.sistemaDeAgendamento.model;

import java.time.LocalDateTime;

public class Agendamento {
    private  int id;
    private Cliente cliente;
    private Profissional profissional;
    private Servico servico;
    private LocalDateTime dataHora;


    public Agendamento( Cliente cliente, Profissional profissional, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
