package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO extends BaseDAO {

    public boolean cadastrarServico(Servico servico){
        String sql  = "INSERT INTO servicos(descricao,duracaoMinutos) VALUES(?,?)";
        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,servico.getDescricao());
            prestmt.setInt(2,servico.getDuracaoMinutos());
            return prestmt.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Serviço");
        }
    }

    public List<Servico> listarServico() {
        List<Servico> servicos = new ArrayList<>();
        String sql  = "SELECT * FROM servicos";
        try(Connection connection  = ConnectionFactory.getConexao()){
            PreparedStatement prestmt  = connection.prepareStatement(sql);
            ResultSet resultSet = prestmt.executeQuery();

            while (resultSet.next()){
                Servico servico = new Servico(resultSet.getInt("id"),resultSet.getString("descricao"),resultSet.getInt("duracaoMinutos"));
                servicos.add(servico);
            }
            return servicos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Listar serviço");
        }
    }

    public boolean atualizarServDescricao(int id, String novaDescricao) {
        String sql = "UPDATE servicos SET descricao = ? WHERE id = ?";
        return  executarUpdate(sql,novaDescricao,id);
    }

    public boolean atualizarServDuracao(int id, int novaDuracao) {
        String sql = "UPDATE servicos SET duracaoMinutos = ? WHERE id = ?";
        return executarUpdate(sql, novaDuracao, id);
    }

    public boolean deletarServico(int id) {
        String sql = "DELETE FROM servicos WHERE id = ?";
        try(Connection connection = ConnectionFactory.getConexao()) {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1,id);
            return preStmt.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar serviço");
        }
    }
}
