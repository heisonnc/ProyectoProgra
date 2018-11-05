/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.administrador.ingresar;

import java.awt.Point;
import java.util.List;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Solicitud;

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
    
    public void agregarBien(Bien b){
        model.agregarBien(b);
        model.setBienes(model.rows);
        model.commit();
    }
    
    

    public void reset(int modo, Solicitud sol){
        model.reset(modo, sol);
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
