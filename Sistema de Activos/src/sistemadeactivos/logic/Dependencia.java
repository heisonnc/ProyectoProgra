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
public class Dependencia {
     private Funcionario funcionario;
     private String descripcion;

    public Dependencia() {
        this.descripcion = "";
    }
    
    public Dependencia(Funcionario funcionario, String descripcion) {
       this.funcionario = funcionario;
       this.descripcion = descripcion;
    }
    
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
