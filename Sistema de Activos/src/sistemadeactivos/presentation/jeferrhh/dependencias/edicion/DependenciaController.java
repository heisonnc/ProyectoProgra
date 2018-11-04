/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.edicion;

import java.awt.Point;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Model;

/**
 *
 * @author mauri
 */
public class DependenciaController {
    Model domainModel;
    Session session;    
    DependenciaView view;
    DependenciaModel model;
    
    public DependenciaController(DependenciaView view, DependenciaModel model, Model domainModel, Session session) {
        model.reset();
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(Dependencia dependencia) throws Exception{  
        switch(model.getModo()){
            case Application.MODO_AGREGAR:
                domainModel.addDependencia(dependencia);
                Application.DEPENDENCIAS_CONTROLLER.refrescarBusqueda();                   
                model.setCurrent(new Dependencia());
                model.commit();   
                break;
            case Application.MODO_EDITAR:
                domainModel.updateDependencia(dependencia);
                Application.DEPENDENCIAS_CONTROLLER.refrescarBusqueda();               
                break;
        }   
    } 

    public void reset(){
        model.reset();
    }
    
    public void reset(int modo, Dependencia current){
        model.reset(modo, current);
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
