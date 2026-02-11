package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Profissional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {

    public boolean incluirProfissional(Profissional profissional) {
        String sql = "INSERT INTO profissionais(nome,especialidade) VALUES(?,?)";
        try (Connection connection = ConnectionFactory.getConexao()) {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setString(1, profissional.getNome());
            preStmt.setString(2, profissional.getEspecialidade());
            return preStmt.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar profissional");
        }
    }

    public List<Profissional> listarProfissional() {
        String sql = "SELECT * FROM profissionais";
        List<Profissional> profissionais = new ArrayList<>();
        try(Connection connection  = ConnectionFactory.getConexao()) {
            PreparedStatement prestmt = connection.prepareStatement(sql);
            ResultSet resultSet = prestmt.executeQuery();

            while (resultSet.next()){
                Profissional profissional = new Profissional(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("especialidade"));
                profissionais.add(profissional);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar profissionais");
        }
        return profissionais;
    }

    public boolean atualizarProNome(int id, String nomeNovo) {
        String sql = "UPDATE profissionais SET nome = ? WHERE id  = ?";
        try(Connection connection  = ConnectionFactory.getConexao()) {
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,nomeNovo);
            prestmt.setInt(2,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o profissional");
        }
    }

    public boolean atualizarProEspecialidade(int id, String especialidadeNova) {
        String sql = "UPDATE profissionais SET especialidade = ? WHERE id  = ?";
        try(Connection connection  = ConnectionFactory.getConexao()) {
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,especialidadeNova);
            prestmt.setInt(2,id);
            return prestmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o profissional");
        }
    }

    public boolean deletarProfissional(int id) {
        String sql = "DELETE FROM profissionais WHERE id = ?";
        try(Connection connection = ConnectionFactory.getConexao()) {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1,id);
            return preStmt.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar profissional");
        }
    }
}
