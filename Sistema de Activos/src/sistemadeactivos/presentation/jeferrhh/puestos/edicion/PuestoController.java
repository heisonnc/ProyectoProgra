/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.puestos.edicion;

import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;

/**
 *
 * @author xxxx
 */
public class PuestoController {
    private Model domainModel;
    Session session;
    PuestoView view;
    PuestoModel model;
    
    public PuestoController(PuestoView view, PuestoModel model, Model domainModel, Session session) {

        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
}
