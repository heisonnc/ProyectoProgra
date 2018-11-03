/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class Puesto {
     private int id;
     private Dependencia dependencia;
     private Funcionario funcionario;
     private Rol rol;

    public Puesto() {
    }

    public Puesto(Dependencia dependencia, Funcionario funcionario, Rol rol) {
       this.dependencia = dependencia;
       this.funcionario = funcionario;
       this.rol = rol;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Dependencia getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
