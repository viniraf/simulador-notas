/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class UsuarioDAO {
    
    
    public void cadastrarUsuario (UsuarioModel usuario) throws ExceptionDAO {
        
        String sql = "INSERT INTO usuarios (usuario, senha) VALUE (?, ?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionSN().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getUsuario());
            pStatement.setString(2, usuario.getSenha());
            pStatement.execute();
            
        } catch(SQLException erro){
            throw new ExceptionDAO ("Erro ao cadastrar usuário: " + erro);
            
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                } 
            } catch (SQLException erro) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + erro);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException erro) {
                throw new ExceptionDAO("Erro ao fechar a conexao: " + erro);
            }
        }
    }
}
