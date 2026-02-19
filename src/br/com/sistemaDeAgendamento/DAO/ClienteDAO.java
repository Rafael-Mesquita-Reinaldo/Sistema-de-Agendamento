package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  extends BaseDAO{


    public boolean incluirCli(Cliente cliente){
        String sql = "INSERT INTO clientes(nome,telefone,email) VALUES(?,?,?)";
        return cadastrar(sql,cliente.getNome(),cliente.getTelefone(),cliente.getEmail());
    }

    public List<Cliente> listarCli(){
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConexao()){
           PreparedStatement prestmt = connection.prepareStatement(sql);
           ResultSet resultSet = prestmt.executeQuery();

           while (resultSet.next()){
               Cliente cliente = new Cliente(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("telefone"),resultSet.getString("email"));
               clientes.add(cliente);
           }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Clientes");
        }
        return clientes;
    }

    public boolean atualizarCliNome(int id,String nomeNovo){
        String sql = "UPDATE clientes SET nome = ? WHERE id  = ?";
        return atualizar(sql,nomeNovo,id);
    }

    public boolean atualizarCliTelefone(int id,String novoTelefone){
        String sql = "UPDATE clientes SET telefone = ? WHERE id  = ?";
        return atualizar(sql,novoTelefone,id);

    }

    public boolean atualizarCliEmail(int id,String novoEmail){
        String sql = "UPDATE clientes SET email = ? WHERE id  = ?";
        return atualizar(sql,novoEmail,id);

    }

    public boolean deletarCli(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
        return deletar(sql,id);
    }
}
