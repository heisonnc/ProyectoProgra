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
public class Categoria {
     private int id;
     private String descripcion;

    public Categoria() {
        this.descripcion = "";
    }

	
    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
