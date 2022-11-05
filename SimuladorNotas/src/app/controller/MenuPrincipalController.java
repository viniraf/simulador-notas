/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.view.CadastroMateriaView;
import app.view.MenuPrincipalView;

/**
 *
 * @author vinic
 */
public class MenuPrincipalController {
    
    private MenuPrincipalView view;

    public MenuPrincipalController(MenuPrincipalView view) {
        this.view = view;
    }

    public void abrirCadastroMateria() {
        CadastroMateriaView cadastroMateriaView = new CadastroMateriaView();
        cadastroMateriaView.setVisible(true);
        view.dispose();
    }
    
    
}
