/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dao.ExceptionDAO;
import app.model.UsuarioModel;
import app.view.CadastroUsuarioView;

/**
 *
 * @author vinic
 */
public class CadastroUsuarioController {
    private CadastroUsuarioView view;

    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
    }
    
    public boolean salvarUsuario() throws ExceptionDAO{
        
        
        String usuarioDig = view.getjTextFieldUsuario().getText();
        String senhaDig = view.getjPasswordFieldSenha().getText();
        
        if (usuarioDig != null && usuarioDig.length() > 0 && senhaDig != null && senhaDig.length() > 0) {
            UsuarioModel usuario = new UsuarioModel(usuarioDig, senhaDig);
            usuario.cadastrarUsuario(usuario);
            return true;
        }
        return false;
    }
    
}
