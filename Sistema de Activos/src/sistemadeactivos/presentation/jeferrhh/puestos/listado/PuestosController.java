/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.puestos.listado;

import java.awt.Point;
import java.util.List;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Puesto;
import sistemadeactivos.presentation.jeferrhh.puestos.edicion.*;

/**
 *
 * @author xxxx
 */
public class PuestosController {
    private Model domainModel;
    Session session;
    PuestosView view;
    PuestosModel model;
    
    public PuestosController(PuestosView view, PuestosModel model, Model domainModel, Session session) {

        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar(String text) {
        List<Puesto> rows =  sistemadeactivos.logic.Model.instance().getPuestosByDependencia(text);
        model.setPuestos(rows);
    }
    
       public void show() {
        
        view.setVisible(true);
    }

    public Model getDomainModel() {
        return domainModel;
    }

    public Session getSession() {
        return session;
    }

    public PuestosView getView() {
        return view;
    }

    public PuestosModel getModel() {
        return model;
    }
    
    public void setPuest(int r){
      Application.PERSONAL_CONTROLLER.getModel().setPuesto(model.puestos.getRowAt(r));
      this.hide();
      Application.PERSONAL_CONTROLLER.show();  
        
    }
    
    
       
       
       public void setModo(int md){
           model.setModo(md);
       }

    public void show(Point position) {
        view.setLocation(position);
        this.show();
    }

    public void hide() {
        view.setVisible(false);
    }
}
