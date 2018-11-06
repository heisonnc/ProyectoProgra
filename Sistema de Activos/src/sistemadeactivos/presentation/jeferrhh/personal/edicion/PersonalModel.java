/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import sistemadeactivos.Application;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Puesto;
import sistemadeactivos.logic.Usuario;


/**
 *
 * @author book
 */
public class PersonalModel extends java.util.Observable{
    
    // es el edicon de los funcionarios, pero cualquier funcionario primero tiene que 
    private Funcionario current;// ser regsitrado como un usuario
    private Usuario user;
    private Dependencia dependencia;
    private Puesto puesto;
    int modo; 

    
    
    
    public PersonalModel(){
        this.reset();
    }

    public void setCurrent(Funcionario current) {
        this.current = current;
    }
    public void setUser(Usuario user){
        this.user= user;
    }
    
    public void setModo(int modo) {
        this.modo = modo;
    }

    public Usuario getUser() {
        return user;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Funcionario getCurrent() {
        return current;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    
    public int getModo() {
        return modo;
    }
    
     public void reset(int modo, Funcionario current, Usuario userr){
        this.setModo(modo);
        this.setUser(userr);
        this.setCurrent(current);
        this.commit();
    }
    
    public void reset(){
        this.reset(Application.MODO_AGREGAR,new Funcionario(), new Usuario());     
    } 
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.commit();
    }
    
    // actualizar
    public void commit(){
        setChanged();
        notifyObservers();       
    }  
    
}
