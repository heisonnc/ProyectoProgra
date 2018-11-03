/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Activo;

/**
 *
 * @author mauri
 */
public class ActivoTableModel extends AbstractTableModel{
    List<Activo> rows;
    int[] cols;

    public  ActivoTableModel(int[] cols, List<Activo> rows){
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
        Activo activo = rows.get(row);
        switch (cols[col]){
            case ID: return activo.getId();
            case DESCRIPCION: return activo.getBien().getCategoria().getDescripcion();
            case DEPENDENCIA: return activo.getPuesto().getDependencia().getDescripcion();
            case RESPONSABLE: return activo.getPuesto().getFuncionario().getNombre();
            default: return "";
        }
    }

    public Activo getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int ID=0;
    public static final int DESCRIPCION=1;
    public static final int DEPENDENCIA=2;
    public static final int RESPONSABLE=3;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[DESCRIPCION]= "Descripcion";
        colNames[DEPENDENCIA]= "Dependencia";
        colNames[RESPONSABLE]= "Responsable";
    }
}
