/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Funcionario;

/**
 *
 * @author mauri
 */
public class DependenciaTableModel  extends AbstractTableModel{
    List<Dependencia> rows;
    int[] cols;

    public  DependenciaTableModel(int[] cols, List<Dependencia> rows){
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
        Dependencia dependencia = rows.get(row);
        switch (cols[col]){
            case DESCRIPCION: return dependencia.getDescripcion();
            case FUNCIONARIO: 
                if(dependencia.getFuncionario()!=null){return dependencia.getFuncionario().getNombre();}else{return null;}
            default: return "";
        }
    }

    public Dependencia getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int DESCRIPCION=0;
    public static final int FUNCIONARIO=1;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[DESCRIPCION]= "Descripcion";
        colNames[FUNCIONARIO]= "Administrador";
    }
}
