/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import sistemadeactivos.Application;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Usuario;


/**
 *
 * @author book
 */
public class PersonalModel extends java.util.Observable{
    
    // es el edicon de los funcionarios, pero cualquier funcionario primero tiene que 
    private Funcionario current;// ser regsitrado como un usuario
    private Usuario user;
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

    public Funcionario getCurrent() {
        return current;
    }

    public int getModo() {
        return modo;
    }
    
     public void reset(int modo, Funcionario current){
        this.setModo(modo);
        this.setCurrent(current);
        this.commit();
    }
    
    public void reset(){
        this.reset(Application.MODO_AGREGAR,new Funcionario());     
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
