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
public class Usuario {
     private String id;
     private Funcionario funcionario;
     private Rol rol;
     private String clave;

    public Usuario() {
        this.id = "";
        this.clave = "";
    }
	
    public Usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
    }
    
    public Usuario(String id, Funcionario funcionario, Rol rol, String clave) {
       this.id = id;
       this.funcionario = funcionario;
       this.rol = rol;
       this.clave = clave;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
}
