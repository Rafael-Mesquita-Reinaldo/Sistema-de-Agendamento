package br.com.sistemaDeAgendamento.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConexao(){
        try{
            Properties properties = getPropertis();
            String stringConnection = properties.getProperty("banco.url");
            String usuario = properties.getProperty("banco.user");
            String senha = properties.getProperty("banco.password");
            return DriverManager.getConnection(stringConnection,usuario,senha);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static Properties getPropertis() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);
        return properties;
    }
}
