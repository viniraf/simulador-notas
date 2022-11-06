/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.view.ConsultaMateriaView;
import app.view.MenuPrincipalView;

/**
 *
 * @author vinic
 */
public class ConsultaMateriaController {
    
    private ConsultaMateriaView view;

    public ConsultaMateriaController(ConsultaMateriaView view) {
        this.view = view;
    }

    public void fecharTelaConsultaMateria() {
        view.setVisible(false);
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
    }
}
