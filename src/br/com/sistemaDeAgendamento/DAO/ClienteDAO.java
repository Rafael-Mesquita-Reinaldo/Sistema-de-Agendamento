package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {


    public boolean incluirCli(Cliente cliente){
        String sql = "INSERT INTO clientes(nome,telefone,email) VALUES(?,?,?)";
        try (Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1, cliente.getNome());
            prestmt.setString(2, cliente.getTelefone());
            prestmt.setString(3, cliente.getEmail());
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente");
        }

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
        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,nomeNovo);
            prestmt.setInt(2,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar o nome");
        }

    }

    public boolean atualizarCliTelefone(int id,String novoTelefone){
        String sql = "UPDATE clientes SET telefone = ? WHERE id  = ?";

        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,novoTelefone);
            prestmt.setInt(2,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar o telefone");
        }

    }

    public boolean atualizarCliEmail(int id,String novoEmail){
        String sql = "UPDATE clientes SET email = ? WHERE id  = ?";

        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,novoEmail);
            prestmt.setInt(2,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar o Email");
        }

    }

    public boolean deletarCli(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setInt(1,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}
