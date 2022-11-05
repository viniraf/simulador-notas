/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.model.MateriaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class MateriaDAO {

    public boolean cadastrarMateria(MateriaModel materia) throws ExceptionDAO {
        String sql = "INSERT INTO materias (nome) VALUE (?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionSN().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, materia.getNome());
            pStatement.execute();
            return true;
            
        } catch(SQLException erro){
            throw new ExceptionDAO ("Erro ao cadastrar matéria: " + erro);
            
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
