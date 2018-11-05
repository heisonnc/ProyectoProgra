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
public class Activo {
     private int id;
     private Bien bien;
     private Puesto puesto;
     private Funcionario encargado;

    public Activo() {
    }

    public Activo(Bien bien, Puesto puesto) {
       this.bien = bien;
       this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bien getBien() {
        return bien;
    }

    public Funcionario getEncargado() {
        return encargado;
    }

    public void setEncargado(Funcionario encargado) {
        this.encargado = encargado;
    }

    
    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    
}
