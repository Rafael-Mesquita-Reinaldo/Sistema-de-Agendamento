package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Agendamento;
import br.com.sistemaDeAgendamento.model.Cliente;
import br.com.sistemaDeAgendamento.model.Profissional;
import br.com.sistemaDeAgendamento.model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO extends BaseDAO {
    public boolean verificarConflitoDAO(int idProfissional,LocalDate data, LocalTime horario) {
        String sql = "SELECT EXISTS(SELECT 1 FROM agendamentos WHERE profissionais_id = ? AND data = ? AND hora = ?) ";
        try (Connection connection = ConnectionFactory.getConexao()) {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1, idProfissional);
            preStmt.setObject(2, data);
            preStmt.setObject(3, horario);
            ResultSet resultSet = preStmt.executeQuery();

            if (resultSet.next()){
                return resultSet.getBoolean(1);
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar Conflito");
        }
    }

    public boolean cadastrarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos(cliente_id,profissional_id,servico_id,data,hora)";
        return cadastrar(sql,agendamento.getCliente().getId(),agendamento.getProfissional().getId(),agendamento.getServico().getId(),agendamento.getData(),agendamento.getHora());
    }


    public List<Agendamento> listarAgendamento() {
        String sql = """
                SELECT
                    agend.id as id,
                    cli.nome AS cliente,
                    profi.nome AS profissional,
                    serv.descricao AS descricao,
                    agend.data AS data,
                    agend.hora AS hora
                FROM
                    agendamentos agend
                INNER JOIN
                    clientes cli ON cli.id = agend.cliente_id
                INNER JOIN
                    profissionais profi ON profi.id = agend.profissional_id
                INNER JOIN
                    servicos serv ON serv.id = agend.servico_id""";


        List<Agendamento> agendamentos = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement preStmt = connection.prepareStatement(sql);
            ResultSet resultSet = preStmt.executeQuery();

            while (resultSet.next()){
                agendamentos.add(new Agendamento(resultSet.getInt("id"),
                        new Cliente(resultSet.getString("cliente")),
                        new Profissional(resultSet.getString("profissional")),
                        new Servico(resultSet.getString("descricao")),
                        resultSet.getDate("data").toLocalDate(),
                        resultSet.getTime("hora").toLocalTime()));
            }
            return agendamentos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar agendamentos do banco");
        }

    }

    public boolean atualizarNomeCli(int idAgendamento, int idNovoCli) {
        String sql = "UPDATE agendamentos SET cliente_id = ? WHERE id  = ?";
        return atualizar(sql,idNovoCli,idAgendamento);

    }

    public boolean atualizarNomeProfissional(int idAgendamento, int idNovoProfissional) {
        String sql = "UPDATE agendamentos SET profissional_id = ? WHERE id  = ?";
        return atualizar(sql,idNovoProfissional,idAgendamento);
    }

    public boolean atualizarDescServico(int idAgendamento, int idNovoServico) {
        String sql = "UPDATE agendamentos SET servico_id = ? WHERE id  = ?";
        return atualizar(sql,idNovoServico,idAgendamento);
    }

    public boolean atualizarDataHora(int idAgendamento, LocalDate data, LocalTime novoHorario) {
        String sql = "UPDATE agendamentos SET data = ?, hora = ? WHERE id  = ?";
        return atualizar(sql,data,novoHorario,idAgendamento);
    }

    public boolean deletarAgendamento(int id) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";
        return deletar(sql,id);
    }
}
