/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.administrador.ingresar;

import java.awt.Point;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;

/**
 *
 * @author mauri
 */
public class IngresarController {
    Model domainModel;
    Session session;
    IngresarView view;
    IngresarModel model;
    
    
    public IngresarController(IngresarView view, IngresarModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
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
