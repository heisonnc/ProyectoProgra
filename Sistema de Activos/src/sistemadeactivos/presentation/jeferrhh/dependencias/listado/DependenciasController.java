/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.listado;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author mauri
 */
public class DependenciasController {
    Model domainModel;
    Session session;
    DependenciasView view;
    DependenciasModel model;
    
    public DependenciasController(DependenciasView view, DependenciasModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(Dependencia filter) throws Exception{       
         model.setFilter(filter);
        this.refrescarBusqueda();
    }
    
    public void refrescarBusqueda() throws Exception{
        List<Dependencia> rows = domainModel.searchDependencias(model.getFilter());
        model.setDependencias(rows);
        model.commit();
        if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
    }    

    public void preAgregar(Point at)throws Exception{      
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol())){
           throw new Exception(Application.ROL_NOTAUTHORIZED);
        }
        Application.DEPENDENCIA_CONTROLLER.reset(Application.MODO_AGREGAR, new Dependencia());
        Application.DEPENDENCIA_CONTROLLER.show(at);
    }
    
    public void editar(int row, Point at){       
        Dependencia seleccionada = model.getDependencias().getRowAt(row); 
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        int modo;
        if ( Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol())){
            modo=Application.MODO_EDITAR;
        }
        else{
            modo=Application.MODO_CONSULTAR;            
        }
        Application.DEPENDENCIA_CONTROLLER.reset(modo, seleccionada);
        Application.DEPENDENCIA_CONTROLLER.show(at);
    }

    public void borrar(int row){  
        Dependencia seleccionada = model.getDependencias().getRowAt(row); 
        try {
            domainModel.deleteDependencia(seleccionada);
        } catch (Exception ex) { }
        List<Dependencia> rowsMod = domainModel.searchDependencias(model.getFilter());
        model.setDependencias(rowsMod);
        model.commit();
    }

    public void reset(){
        model.reset();
    }
    
    public void show(){
        view.setVisible(true);
    }

    public void show(Point position){
        view.setLocation(position);
        this.show();
    }   
    
    public void hide(){
        view.setVisible(false);
    }    
}
