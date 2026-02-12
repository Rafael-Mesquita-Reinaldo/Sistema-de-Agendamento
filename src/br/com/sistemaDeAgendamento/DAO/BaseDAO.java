package br.com.sistemaDeAgendamento.DAO;

import br.com.sistemaDeAgendamento.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseDAO {

    public boolean executarUpdate(String sql, Object... parametros){
       try(Connection connection = ConnectionFactory.getConexao()){
           PreparedStatement prestmt = connection.prepareStatement(sql);
           for (int i = 0; i < parametros.length; i++) {
               prestmt.setObject(i+1,parametros[i]);
           }
           return prestmt.executeUpdate()>0;
       } catch (SQLException e) {
           throw new RuntimeException("Erro ao executar operação no Banco",e);
       }

    }

}
