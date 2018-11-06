/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.listado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.presentation.tablemodel.DependenciaTableModel;

/**
 *
 * @author mauri
 */
public class DependenciasModel extends java.util.Observable{
    Dependencia filter; 
    DependenciaTableModel personas;
    Dependencia seleccionado;
    
    int modo;

    public DependenciasModel() {
        this.reset();
    }

    public void reset(){ 
        filter = new Dependencia();
        List<Dependencia> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setDependencias(rows);
        this.commit();  
    }
    
    public void setDependencias(List<Dependencia> personas){
        int[] cols={DependenciaTableModel.DESCRIPCION,DependenciaTableModel.FUNCIONARIO};
        this.personas =new DependenciaTableModel(cols,personas);    
    }
    
    public Dependencia getFilter() {
        return filter;
    }
    
    public void setFilter(Dependencia filter) {
        this.filter = filter;
    }
    
     public DependenciaTableModel getDependencias() {
        return personas;
    }

    public Dependencia getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Dependencia seleccionado) {
        this.seleccionado = seleccionado;
    }
  
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();   
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    }
}
