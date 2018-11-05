
package sistemadeactivos.presentation.catalogo.listado;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author book
 */
public class CatalogosController {
    Model domainModel;
    Session session;
    CatalogosView view;
    CatalogosModel model;
    
    public CatalogosController(CatalogosView view, CatalogosModel model, Model domainModel, Session session) {
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
