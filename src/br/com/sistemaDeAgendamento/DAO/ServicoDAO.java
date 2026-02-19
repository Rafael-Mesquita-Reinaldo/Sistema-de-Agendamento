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
        return cadastrar(sql,servico.getDescricao(),servico.getDuracaoMinutos());
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
        return  atualizar(sql,novaDescricao,id);
    }

    public boolean atualizarServDuracao(int id, int novaDuracao) {
        String sql = "UPDATE servicos SET duracaoMinutos = ? WHERE id = ?";
        return atualizar(sql, novaDuracao, id);
    }

    public boolean deletarServico(int id) {
        String sql = "DELETE FROM servicos WHERE id = ?";
        return deletar(sql,id);
    }
}
