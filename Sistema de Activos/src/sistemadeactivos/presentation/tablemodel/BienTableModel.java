/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.tablemodel;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistemadeactivos.logic.Bien;
/**
 *
 * @author mauri
 */
public class BienTableModel extends AbstractTableModel{
    List<Bien> rows;
    int[] cols;

    public  BienTableModel(int[] cols, List<Bien> rows){
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
        Bien bien = rows.get(row);
        switch (cols[col]){
            case DESCRIPCION: return bien.getDescripcion();
            case MARCA: return bien.getMarca();
            case MODELO: return bien.getModelo();
            case PRECIO: return bien.getPrecioUnitario();
            case CANTIDAD: return bien.getCantidad();
            default: return "";
        }
    }

    public Bien getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int DESCRIPCION=0;
    public static final int MARCA=1;
    public static final int MODELO=2;
    public static final int PRECIO=3;
    public static final int CANTIDAD=4;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[DESCRIPCION]= "Descripcion";
        colNames[MARCA]= "Marca";
        colNames[MODELO]= "Modelo";
        colNames[PRECIO]= "Precio";
        colNames[CANTIDAD] = "Cantidad";
    }
}
