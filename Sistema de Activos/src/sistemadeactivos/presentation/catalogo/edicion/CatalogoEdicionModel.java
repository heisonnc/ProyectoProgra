/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.catalogo.edicion;

import sistemadeactivos.Application;
import sistemadeactivos.logic.Activo;

/**
 *
 * @author book
 */
public class CatalogoEdicionModel extends java.util.Observable {
    Activo current;
    int modo;    

    public CatalogoEdicionModel() {
        this.reset();
    }
    
    public void reset(int modo, Activo current){
        this.setModo(modo);
        this.setCurrent(current);
        this.commit();
    }
    
    public void reset(){
        this.reset(Application.MODO_AGREGAR, new Activo());
    }   

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Activo getCurrent() {
        return current;
    }

    public void setCurrent(Activo current) {
        this.current = current;   
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    } 
}
