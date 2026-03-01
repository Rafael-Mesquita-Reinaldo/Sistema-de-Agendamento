package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.model.TipoUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       TipoUsuario tipoUsuario = LoginUsuario.escolherUsuario(scanner);

       if (tipoUsuario == TipoUsuario.ADM){
           System.out.println("Você entrou como adm");
           MenuADM menuADM = new MenuADM();
           menuADM.menu(scanner);
       }else {
           MenuCliente menuCliente = new MenuCliente();
           menuCliente.menuCli(scanner);
       }

    }
}
