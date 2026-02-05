package br.com.sistemaDeAgendamento.service;

import br.com.sistemaDeAgendamento.model.TipoUsuario;

public class AuthService {
    private static final int SENHA_ADM = 12345678;

    public static TipoUsuario autenticarAdm(int senha){
        if (senha == SENHA_ADM){
            return TipoUsuario.ADM;
        }else {
            throw new RuntimeException("Senha incorreta");
        }
    }

}
