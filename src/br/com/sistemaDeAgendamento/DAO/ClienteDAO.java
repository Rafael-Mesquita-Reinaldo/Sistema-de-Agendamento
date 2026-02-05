package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
