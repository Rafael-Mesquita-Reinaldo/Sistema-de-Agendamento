package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendamentoDAO {
    public static boolean verificarConflitoDAO(Agendamento agendamento) {
        String sql = "SELECT COUNT(*) FROM agendamentos WHERE profissional_id = ? AND data = ? AND hora = ? ";
        try (Connection connection = ConnectionFactory.getConexao()) {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1, agendamento.getProfissional().getId());
            preStmt.setObject(2, agendamento.getData());
            preStmt.setObject(2, agendamento.getHora());
            return preStmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar Conflito");
        }
    }
}
