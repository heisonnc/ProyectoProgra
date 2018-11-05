/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.catalogo.edicion;

import java.awt.Point;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Activo;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Puesto;

/**
 *
 * @author book
 */
public class CatalogoEdicionController {
    Model domainModel;
    Session session;    
    CatalogoEdicionView view;
    CatalogoEdicionModel model;
    
    Puesto puesto;
    
    
    
    public CatalogoEdicionController(CatalogoEdicionView view, CatalogoEdicionModel model, Model domainModel, Session session) {
        model.reset();
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(Activo activo) throws Exception{  
        switch(model.getModo()){
            case Application.MODO_AGREGAR:
                domainModel.addActivo(activo);
                Application.DEPENDENCIAS_CONTROLLER.refrescarBusqueda();                   
                model.setCurrent(new Activo());
                model.commit();   
                break;
            case Application.MODO_EDITAR:
                domainModel.updateActivo(activo);
                Application.DEPENDENCIAS_CONTROLLER.refrescarBusqueda();               
                break;
        }   
    } 

    
   
    
    public void reset(){
        model.reset();
    }
    
    public void reset(int modo, Activo current){
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
