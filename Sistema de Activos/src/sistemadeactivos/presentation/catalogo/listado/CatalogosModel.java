/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.catalogo.listado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistemadeactivos.logic.Activo;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.presentation.tablemodel.ActivoTableModel;
import sistemadeactivos.presentation.tablemodel.BienTableModel;

/**
 *
 * @author book
 */
public class CatalogosModel  extends java.util.Observable{
    Activo filter; 
    ActivoTableModel activos;
    Activo seleccionado;

    public CatalogosModel() {
        this.reset();
    }

    public void reset(){ 
        filter = new Activo();
        List<Activo> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setBienes(rows);
        this.commit();  
    }
    
    public void setBienes(List<Activo> activos){
        int[] cols={ActivoTableModel.ID,ActivoTableModel.DESCRIPCION};
        this.activos =new ActivoTableModel(cols,activos);    
    }
    
    public Activo getFilter() {
        return filter;
    }
    
    public void setFilter(Activo filter) {
        this.filter = filter;
    }
    
     public ActivoTableModel getBienes() {
        return activos;
    }

    public Activo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Activo seleccionado) {
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
