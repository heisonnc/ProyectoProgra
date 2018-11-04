/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.secretaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistemadeactivos.logic.Solicitud;
import sistemadeactivos.presentation.tablemodel.SolicitudTableModel;


public class SecretariaModel extends Observable{
    Solicitud filter; 
    SolicitudTableModel solicitudes;
    Solicitud seleccionado;

    public SecretariaModel() {
        this.reset();
    }

    public void reset(){ 
        filter = new Solicitud();
        List<Solicitud> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setSolicitudes(rows);
        this.commit();  
    }
    
    public void setSolicitudes(List<Solicitud> solicitud){
        int[] cols={SolicitudTableModel.DATE,SolicitudTableModel.FUNCIONARIO,SolicitudTableModel.COMBROBANTE,
            SolicitudTableModel.CANTIDAD_BIENES, SolicitudTableModel.MONTO_TOTAL,
            SolicitudTableModel.DEPENDENCIA,SolicitudTableModel.ADQUISICION,
            SolicitudTableModel.ESTADO,SolicitudTableModel.RECHAZO};
        this.solicitudes =new SolicitudTableModel(cols,solicitud);    
    }
    
    public Solicitud getFilter() {
        return filter;
    }
    
    public void setFilter(Solicitud filter) {
        this.filter = filter;
    }
    
     public SolicitudTableModel getSolicitudes() {
        return solicitudes;
    }

    public Solicitud getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Solicitud seleccionado) {
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
