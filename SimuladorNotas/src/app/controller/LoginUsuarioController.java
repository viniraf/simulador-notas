/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dao.ExceptionDAO;
import app.dao.UsuarioDAO;
import app.model.UsuarioModel;
import app.view.LoginView;
import app.view.MenuPrincipalView;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class LoginUsuarioController {

    private LoginView view;

    public LoginUsuarioController(LoginView view) {
        this.view = view;
    }

     public void autenticar() throws ExceptionDAO {
        
        // Buscar um usuario da view
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        UsuarioModel usuarioAutenticar = new UsuarioModel(usuario, senha);
        
        
        // Verificar se existe no banco de dados
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        boolean existe = usuarioDAO.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        // Se existir, direciona para tela principal
        
        if(existe) {
            MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
            menuPrincipalView.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Usuario ou senha inválidos");
        }
        
       
    }
}
