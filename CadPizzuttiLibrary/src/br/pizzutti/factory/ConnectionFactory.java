package br.pizzutti.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Pedro
 * Classe destinada a criação da conexão com o banco de dados
 */
public class ConnectionFactory {
   
    public static Connection con;
    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        
        if (con == null){
            
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            
            String url = "jdbc:mysql://localhost:3307/mylibrary";
            String user = "root";
            String password = "root";
            
            con = DriverManager.getConnection(url, user, password);
            
            return con;
            
        } else {
            
            return con;
        }
    /**
    * Método que estabelece a conexão com o servidor,
    * caso a conexão não esteja estabelecida.
    * @return Connection.
    */
   
    }
}
