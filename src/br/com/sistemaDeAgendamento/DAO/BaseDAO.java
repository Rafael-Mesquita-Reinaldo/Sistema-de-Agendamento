package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;
import br.com.sistemaDeAgendamento.model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public abstract class BaseDAO {

    public boolean cadastrar(String sql,Object... parametros){
        try(Connection connection  = ConnectionFactory.getConexao()){
            PreparedStatement preStmt = connection.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                preStmt.setObject(i+1,parametros[i]);
            }
            return preStmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar dados no Banco",e);
        }
    }

    public boolean atualizar(String sql, Object... parametros){
       try(Connection connection = ConnectionFactory.getConexao()){
           PreparedStatement preStmt = connection.prepareStatement(sql);
           for (int i = 0; i < parametros.length; i++) {
               preStmt.setObject(i+1,parametros[i]);
           }
           return preStmt.executeUpdate()>0;
       } catch (SQLException e) {
           throw new RuntimeException("Erro ao atualizar dados no Banco",e);
       }

    }

    public boolean deletar(String sql ,Object... parametros){
        try(Connection connection = ConnectionFactory.getConexao()){
            PreparedStatement preStmt = connection.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                preStmt.setObject(i+1,parametros[i]);
            }
            return preStmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar dados do Banco",e);
        }
    }
}
