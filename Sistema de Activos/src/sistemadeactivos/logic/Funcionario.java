/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.logic;


/**
 *
 * @author mauri
 */
public class Funcionario {
     private int id;
     private String nombre;

    public Funcionario() {
        this.nombre = "";
    }

    public Funcionario(String nombre) {
       this.nombre = nombre;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
