package br.com.sistemaDeAgendamento.model;

public class Servico {
    private  int id;
    private String descricao;
    private int duracaoMinutos;

    public Servico( String descricao, int duracaoMinutos) {
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}
