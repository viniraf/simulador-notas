/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dao.ExceptionDAO;
import app.model.UsuarioModel;
import app.view.CadastroUsuarioView;
import app.view.LoginView;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CadastroUsuarioController {
    private CadastroUsuarioView view;

    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
    }
    
    public void limparTela(){
        view.setjTextFieldUsuarioSetText("");
        view.setjPasswordFieldSenhaSetText("");
    }
    
    
     public void fecharTelaCadastroUsuario() {
        view.setVisible(false);
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
    
    public void cadastrarUsuario() throws ExceptionDAO{

        String nomeUsuarioDig = view.getjTextFieldUsuario().getText();
        String senhaDig = view.getjPasswordFieldSenha().getText();
        
        
        if (nomeUsuarioDig != null && nomeUsuarioDig.length() > 0 && senhaDig != null && senhaDig.length() > 0) {
            UsuarioModel usuario = new UsuarioModel(nomeUsuarioDig, senhaDig);
            usuario.cadastrarUsuario(usuario);
            JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso");
            limparTela();
        } else {
            JOptionPane.showMessageDialog(view, "Preencha o campo corretamente.");
        }  
    }
}
