package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ClienteController;

import java.util.Scanner;

public class MenuCliente {
    private ClienteController clienteController = new ClienteController();

    public void menu(Scanner scanner){
        System.out.print("1 - Cadastro\n2 - Agendadmento\nEscolha(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){

            System.out.print("nome:");
            String nome = scanner.nextLine();

            System.out.print("telefone:");
            String telefone = scanner.nextLine();

            System.out.print("email(opcional):");
            String email = scanner.nextLine();
            try {
                clienteController.cadastrarCli(nome,telefone,email);
                System.out.print("Cliente cadastrado com sucesso!");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }
        }else {
            //ainda vou adicionar
        }
    }


}
