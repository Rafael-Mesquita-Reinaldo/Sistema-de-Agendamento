package br.com.sistemaDeAgendamento.model;

import java.util.Properties;

public class Profissional {
    private final int id;
    private String nome;
    private String especialidade;

    public Profissional(int id, String nome,String especialidade){
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
}
