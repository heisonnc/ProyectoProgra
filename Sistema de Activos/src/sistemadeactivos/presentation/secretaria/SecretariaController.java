/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.secretaria;

import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;


public class SecretariaController {
    Model domainModel;
    Session session;
    SecretariaView view;
    SecretariaModel model;
    
    public SecretariaController(SecretariaView view, SecretariaModel model/*, Model domainModel, Session session*/) {
        /*this.domainModel= domainModel;
        this.session=session;*/
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
