/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import app.dao.ExceptionDAO;
import app.dao.MateriaDAO;


/**
 *
 * @author vinic
 */
public class MateriaModel {
    private int id;
    private String nome;

    public MateriaModel() {
    }

    public MateriaModel(String nome) {
        this.nome = nome;
    }

    public MateriaModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean cadastrarMateria(MateriaModel materia) throws ExceptionDAO {
        boolean sucesso;
        sucesso = new MateriaDAO().cadastrarMateria(materia);
        return true;
    }
    
    
}
