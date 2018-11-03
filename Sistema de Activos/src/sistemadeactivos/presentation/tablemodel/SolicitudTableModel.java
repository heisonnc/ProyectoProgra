/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Solicitud;

/**
 *
 * @author mauri
 */
public class SolicitudTableModel extends AbstractTableModel{
    List<Solicitud> rows;
    int[] cols;

    public  SolicitudTableModel(int[] cols, List<Solicitud> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }    
    }    
    
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Solicitud solicitud = rows.get(row);
        switch (cols[col]){
            case DATE: return solicitud.getFecha();
            case FUNCIONARIO: return solicitud.getFuncionario().getNombre();
            case COMBROBANTE: return solicitud.getComprobante();
            case CANTIDAD_BIENES: return solicitud.getCantidadBienes();
            case MONTO_TOTAL: return solicitud.getMontoTotal();
            case DEPENDENCIA: return solicitud.getDependencia().getDescripcion();
            case ADQUISICION: return solicitud.getAdquisicion().getDescripcion();
            case ESTADO: return solicitud.getEstado().getDescripcion();
            case RECHAZO: return solicitud.getRechazo();
            default: return "";
        }
    } 

    public Solicitud getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int DATE=0;
    public static final int FUNCIONARIO=1;
    public static final int COMBROBANTE=2;
    public static final int CANTIDAD_BIENES=3;
    public static final int MONTO_TOTAL=4;
    public static final int DEPENDENCIA=5;
    public static final int ADQUISICION=6;
    public static final int ESTADO=7;
    public static final int RECHAZO=8; 
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[DATE]= "Fecha";
        colNames[FUNCIONARIO]= "Registrador";
        colNames[COMBROBANTE]= "Combrante";
        colNames[CANTIDAD_BIENES]= "Cantidad";
        colNames[MONTO_TOTAL]= "Monto";
        colNames[DEPENDENCIA]= "Dependencia";
        colNames[ADQUISICION]= "Tipo Adquisicion";
        colNames[ESTADO]= "Estado";
        colNames[RECHAZO]= "Rechazo";
    }
}
