package br.com.sistemaDeAgendamento.model;

import java.util.Properties;

public class Profissional {
    private int id;
    private String nome;
    private String especialidade;

    public Profissional( String nome,String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Profissional(int id,String nome,String especialidade){
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nEspecialidade: %s",getId(),getNome(),getEspecialidade());
    }
}
