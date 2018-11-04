/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.application;

import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author mauri
 */
public class ApplicationController {
    Model domainModel;
    Session session;    
    ApplicationView view;
    ApplicationModel model;
    
    public ApplicationController(ApplicationView view, ApplicationModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void dependenciasShow(){
        Application.DEPENDENCIAS_CONTROLLER.show();
    }
    public void funcionarioShow(){
        Application.PERSONALS_CONTROLLER.show();
    }
    public void ingresarSolicitudesShow(){
        Application.INGRESAR_CONTROLLER.show();
    }
    
    
     public void enter(){
        this.reset();
        this.show();
    }
     
     public void reset(){
        model.reset((Usuario) session.getAttribute(Application.USER_ATTRIBUTE));
    }
    
    public void show(){
        view.setVisible(true);
    }
    
    public void hide(){
        Application.DEPENDENCIAS_CONTROLLER.hide();      
        view.setVisible(false);
    }  
    
     public void exit(){
        this.hide();
        Application.LOGIN_CONTROLLER.logout();
    }
}
