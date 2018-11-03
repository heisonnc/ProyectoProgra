/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.edicion;

import java.util.Observable;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Dependencia;

/**
 *
 * @author mauri
 */
public class DependenciaModel extends Observable{
    Dependencia current;
    int modo;    

    public DependenciaModel() {
        this.reset();
    }
    
    public void reset(int modo, Dependencia current){
        this.setModo(modo);
        this.setCurrent(current);
        this.commit();
    }
    
    public void reset(){
        this.reset(Application.MODO_AGREGAR, new Dependencia());
    }   

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Dependencia getCurrent() {
        return current;
    }

    public void setCurrent(Dependencia current) {
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
