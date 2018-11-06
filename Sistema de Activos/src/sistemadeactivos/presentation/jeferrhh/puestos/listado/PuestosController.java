/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.puestos.listado;

import java.util.List;
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
}
