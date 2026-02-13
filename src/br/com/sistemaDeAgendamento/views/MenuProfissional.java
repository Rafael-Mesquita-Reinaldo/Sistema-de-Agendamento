package br.com.sistemaDeAgendamento.views;

import br.com.sistemaDeAgendamento.controller.ProfissionalController;
import br.com.sistemaDeAgendamento.model.Profissional;

import java.util.List;
import java.util.Scanner;

public class MenuProfissional {
    private ProfissionalController profissionalController = new ProfissionalController();

    public void opcoesProfissional(Scanner scanner){
        int opcao;
        do {
            System.out.print("1 - Cadastrar profissional\n2 - Listar profissionais\n3 - Atualizar dados profissional\n4 - Deletar profissional\n0 - Sair\nEscolha(Digita o número): ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    cadastrarProfissional(scanner);
                    break;
                case 2:
                    listarProfissional(scanner);
                    break;
                case 3:
                    atualizarProfissional(scanner);
                    break;
                case 4:
                    deletarProfissional(scanner);
                    break;
            }

        }while (opcao !=0);

    }

    private void cadastrarProfissional(Scanner scanner){

        System.out.print("nome:");
        String nome = scanner.nextLine();

        System.out.print("Especialidade:");
        String especialidade = scanner.nextLine();

        try {
            profissionalController.cadastrarProfissional(nome,especialidade);
            System.out.println("Profissional cadastrado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarProfissional(Scanner scanner) {
        List<Profissional> profissionais = profissionalController.listarProfissional();
        if(profissionais.isEmpty()){
            throw new RuntimeException("Nenhum profissional cadastrado");
        }
        for(Profissional profissional : profissionais){
            System.out.println(profissional);
        }

    }

    private void atualizarProfissional(Scanner scanner) {
        System.out.println("Lista de profissionais: ");
        listarProfissional(scanner);

        System.out.print("Deseja atulizar qual dado\n1 - nome\n2 - especialidade\n(Digita o número):");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1){
            System.out.print("ID do profissional: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Novo nome: ");
            String nomeNovo = scanner.nextLine();

            profissionalController.atualizarProNome(id,nomeNovo);
            System.out.println("Nome alterado com sucesso");

        } else if (opcao == 2) {
            System.out.print("ID do profissional: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova Especialidade: ");
            String novaEspecialidade = scanner.nextLine();

            profissionalController.atualizarProEspecialidade(id,novaEspecialidade);
            System.out.println("Especialidade alterado com sucesso");

        }
    }

    private void deletarProfissional(Scanner scanner) {
        System.out.println("Lista de profissionais: ");
        listarProfissional(scanner);

        System.out.print("ID do profissional: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        profissionalController.deletarProfissional(id);
        System.out.println("Profissional deletado com sucesso!");

    }
}
