/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.catalogo.listado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.presentation.tablemodel.BienTableModel;

/**
 *
 * @author book
 */
public class CatalogosModel  extends java.util.Observable{
    Bien filter; 
    BienTableModel personas;
    Bien seleccionado;

    public CatalogosModel() {
        this.reset();
    }

    public void reset(){ 
        filter = new Bien();
        List<Bien> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setBienes(rows);
        this.commit();  
    }
    
    public void setBienes(List<Bien> bienes){
        int[] cols={BienTableModel.MARCA,BienTableModel.MODELO, BienTableModel.DESCRIPCION, BienTableModel.PRECIO};
        this.personas =new BienTableModel(cols,bienes);    
    }
    
    public Bien getFilter() {
        return filter;
    }
    
    public void setFilter(Bien filter) {
        this.filter = filter;
    }
    
     public BienTableModel getPersonas() {
        return personas;
    }

    public Bien getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Bien seleccionado) {
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
