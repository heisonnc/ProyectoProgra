/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;

/**
 *
 * @author xxxx
 */
public class PersonalController {
    private PersonalModel model;
    private PersonalView view;
    Model domainModel;
    Session session;

    public PersonalController(PersonalModel model, PersonalView view, Model domainModel, Session session) {
        this.model = model;
        this.view = view;
        this.domainModel = domainModel;
        this.session = session;
        view.setModel(model);
        view.setController(this);
    }
    
    
}
