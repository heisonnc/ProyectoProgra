/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.administrador.ingresar;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Solicitud;
import sistemadeactivos.presentation.tablemodel.BienTableModel;

/**
 *
 * @author mauri
 */
public class IngresarModel extends java.util.Observable{
    
    BienTableModel bienes;
    Solicitud solicitud;

    public IngresarModel() {
        reset();
    }

    public void reset(){ 
        solicitud = new Solicitud();
        List<Bien> rows = new ArrayList<>();
        this.setBienes(rows);
        this.commit();  
    }

    public BienTableModel getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        int[] cols={BienTableModel.MARCA, BienTableModel.MODELO, BienTableModel.DESCRIPCION, BienTableModel.PRECIO};
        this.bienes =new BienTableModel(cols,bienes);  
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
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
