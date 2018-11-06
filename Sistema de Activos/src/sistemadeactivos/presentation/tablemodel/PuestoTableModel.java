/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Puesto;

/**
 *
 * @author xxxx
 */
public class PuestoTableModel extends AbstractTableModel{
    List<Puesto> rows;
    int[] cols;

    public  PuestoTableModel(int[] cols, List<Puesto> rows){
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
        Puesto puesto = rows.get(row);
        switch (cols[col]){
            case ID: return puesto.getId();
            case DEPENDENCIA: return puesto.getDependencia().getDescripcion();
            case FUNCIONARIO: return puesto.getFuncionario().getNombre();
            case ROL: return puesto.getRol().getDescripcion();
            default: return "";
        }
    } 

    public Puesto getRowAt(int row) {
        return rows.get(row);
    }

    public static final int ID=0;
    public static final int DEPENDENCIA=1;
    public static final int FUNCIONARIO=2;
    public static final int ROL=3;
    
    String[] colNames = new String[4];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[DEPENDENCIA]= "Dependencia";
        colNames[FUNCIONARIO]= "Funcionario";
        colNames[ROL]= "Rol";
    }
}
