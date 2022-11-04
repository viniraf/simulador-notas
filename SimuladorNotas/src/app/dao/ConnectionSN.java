/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

// Import classes necessárias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class ConnectionSN {
    
    
    // Método de conexão
    public Connection getConnection(){
        
        // Primeiro cria uma conexão vazia (nula)
        Connection conn = null;
        
        
        // Tentar carregar o driver sql e se não der mostra o erro
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
        // Criação connection string com o banco
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mvc?user=root";
            conn = DriverManager.getConnection(url);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
