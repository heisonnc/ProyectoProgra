/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.puestos.listado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistemadeactivos.logic.Puesto;
import sistemadeactivos.presentation.jeferrhh.puestos.edicion.*;
import sistemadeactivos.presentation.tablemodel.PuestoTableModel;

/**
 *
 * @author xxxx
 */
public class PuestosModel extends Observable{
    
    PuestoTableModel puestos;
    Puesto filter;

    public PuestosModel() {
        reset();
    }
    
    
    public void reset(){ 
        filter = new Puesto();
        List<Puesto> rows = new ArrayList<>();        
        this.setPuestos(rows);
        refresh();
    }

    
    public PuestoTableModel getPuestos() {
        return puestos;
    }

    public void setPuestos(List<Puesto> puesto) {
        int[] cols={PuestoTableModel.ID,PuestoTableModel.DEPENDENCIA, PuestoTableModel.FUNCIONARIO, PuestoTableModel.ROL};
        this.puestos =new PuestoTableModel(cols,puesto);
    }

    public Puesto getFilter() {
        return filter;
    }

    public void setFilter(Puesto filter) {
        this.filter = filter;
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        refresh();
    }
    
    public void refresh(){
        setChanged();
        notifyObservers();
    }
}
