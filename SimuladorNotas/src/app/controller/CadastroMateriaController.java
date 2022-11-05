/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dao.ExceptionDAO;
import app.model.MateriaModel;
import app.view.CadastroMateriaView;
import app.view.MenuPrincipalView;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CadastroMateriaController {
    
    private CadastroMateriaView view;

    public CadastroMateriaController(CadastroMateriaView view) {
        this.view = view;
    }

    
    public void fecharCadastroMateria(){
        view.setVisible(false);
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
    }
    
    public void cadastrarMateria() throws ExceptionDAO{

        String nomeMateriaDig = view.getjTextFieldNomeMateria().getText();
        
        
        if (nomeMateriaDig != null && nomeMateriaDig.length() > 0) {
            MateriaModel materia = new MateriaModel(nomeMateriaDig);
            materia.cadastrarMateria(materia);
            JOptionPane.showMessageDialog(view, "Matéria cadastrada com sucesso");
            view.limparTela();
        } else {
            JOptionPane.showMessageDialog(view, "Preencha o campo corretamente.");
        }
        
        
    }
    
    
}
