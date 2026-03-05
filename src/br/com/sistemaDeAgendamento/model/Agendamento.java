package br.com.sistemaDeAgendamento.model;


import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    private  int id;
    private Cliente cliente;
    private Profissional profissional;
    private Servico servico;
    private LocalDate data;
    private LocalTime hora;


    public Agendamento( Cliente cliente, Profissional profissional, Servico servico,LocalDate data, LocalTime hora) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(int id, Cliente cliente, Profissional profissional, Servico servico, LocalDate data, LocalTime hora) {
        this.id = id;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nCliente: %s\nProfissional: %s\nDescrição do Serviço: %s\nData/Hora:"+ getData() + " "+getHora(),getId(),getCliente().getNome(),getProfissional().getNome(),getServico().getDescricao());
    }
}
