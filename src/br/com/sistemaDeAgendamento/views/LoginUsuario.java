package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.model.TipoUsuario;
import br.com.sistemaDeAgendamento.service.AuthService;

import java.util.Scanner;

public class LoginUsuario {

    public static TipoUsuario escolherUsuario(Scanner scanner){

        System.out.print("1 - Administrador\n2 - Cliente\nEscolha(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if(opcao == 1){
            System.out.print("Senha do Administrador: ");
            int senha  = scanner.nextInt();
            try {
                return AuthService.autenticarAdm(senha);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return escolherUsuario(scanner);
            }
        }
        return TipoUsuario.CLIENTE;

    }

}
