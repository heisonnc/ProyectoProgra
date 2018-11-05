/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.listado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistemadeactivos.Application;

import sistemadeactivos.logic.Funcionario;

import sistemadeactivos.presentation.tablemodel.FuncionarioTableModel;

/**
 *
 * @author xxxx
 */
public class PersonalsModel extends java.util.Observable{
    
    
  Funcionario filter;
  Funcionario seleccionado;
  FuncionarioTableModel funcionarios;
    int modo;    

    public PersonalsModel() {
        this.reset();
    }
    
   

    public void reset(){ 
        filter = new Funcionario();
        List<Funcionario> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setDependencias(rows);
        this.commit();  
    }
    
    public void setDependencias(List<Funcionario> funcionarios){
        int[] cols={FuncionarioTableModel.ID,FuncionarioTableModel.NOMBRE};
        this.funcionarios =new FuncionarioTableModel(cols,funcionarios);    
    }
    
    public Funcionario getFilter() {
        return filter;
    }
    
    public void setFilter(Funcionario filter) {
        this.filter = filter;
    }
    
     public FuncionarioTableModel getFuncionarios() {
        return funcionarios;
    }

    public Funcionario getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Funcionario seleccionado) {
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
