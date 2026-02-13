package br.com.sistemaDeAgendamento.views;

import java.util.Scanner;

public class MenuADM {
    private final MenuCliente menuCliente = new MenuCliente();
    private final MenuProfissional menuProfissional = new MenuProfissional();
    private final MenuServico menuServico = new MenuServico();



    public void menu(Scanner scanner){
        int opcaoMenu;
        do {

            System.out.print("1 - Opções sobre cliente\n2 - Opções sobre profissional\n3 - Opções sobre serviço\n0 - Sair\nEscolha(Digita o número):");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();
            if(opcaoMenu == 1){
                menuCliente.opcoesCliente(scanner);
            } else if (opcaoMenu == 2) {
                menuProfissional.opcoesProfissional(scanner);
            } else if (opcaoMenu == 3) {
                menuServico.opcoesServico(scanner);

            }
        }while (opcaoMenu !=0);

    }














}
