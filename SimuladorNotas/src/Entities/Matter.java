/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

public class Matter {
    
    private String name;
    
    public Matter () {
        
    }
    
    public Matter (String name) {
        this.name = name;
    }
    
    
    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

}
