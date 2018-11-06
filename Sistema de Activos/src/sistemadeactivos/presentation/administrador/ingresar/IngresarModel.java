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
    List<Bien> rows;
    int modo;

    public IngresarModel() {
        reset();
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void reset(int modo, Solicitud sol){
        this.setModo(modo);
        this.setSolicitud(solicitud);
        commit();
        
    }
    
    public void reset(){ 
        solicitud = new Solicitud();
        rows = new ArrayList<>();
        this.setBienes(rows);
        this.commit();  
    }

    public BienTableModel getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        int[] cols={BienTableModel.MARCA, BienTableModel.MODELO, BienTableModel.DESCRIPCION, BienTableModel.PRECIO, BienTableModel.CANTIDAD};
        this.bienes =new BienTableModel(cols,bienes);  
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public List<Bien> getRows() {
        return rows;
    }

    public void setRows(List<Bien> rows) {
        this.rows = rows;
    }
    
    public void agregarBien(Bien b) throws Exception{
        rows.add(b);
        this.setBienes(rows);
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
