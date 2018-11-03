/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Funcionario;

/**
 *
 * @author mauri
 */
public class FuncionarioTableModel extends AbstractTableModel{
    List<Funcionario> rows;
    int[] cols;

    public  FuncionarioTableModel(int[] cols, List<Funcionario> rows){
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
        Funcionario funcionario = rows.get(row);
        switch (cols[col]){
            case ID: return funcionario.getId();
            case NOMBRE: return funcionario.getNombre();
            default: return "";
        }
    }

    public Funcionario getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int ID=0;
    public static final int NOMBRE=1; 
    
    String[] colNames = new String[2];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
    }
}
