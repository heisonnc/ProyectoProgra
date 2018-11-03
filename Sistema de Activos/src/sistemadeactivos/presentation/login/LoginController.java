/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.login;

import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author mauri
 */
public class LoginController {
    Model domainModel;
    Session session; 
    LoginModel model;
    LoginView view;

    public LoginController(LoginView view, LoginModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void login(Usuario typed) throws Exception{
            model.setCurrent(typed);
        Usuario real = domainModel.getUsuario(typed.getId(),typed.getClave());
        session.setAttibute(Application.USER_ATTRIBUTE, real);
        view.setVisible(false);
        Application.APPLICATION_CONTROLLER.enter();
    }   

    public void logout(){
        session.removeAttribute(Application.USER_ATTRIBUTE);
        model.setCurrent(new Usuario());
        view.setVisible(true);
    }
    
   
    
    public void exit(){
        System.exit(0);
    }
}
