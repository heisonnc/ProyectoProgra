/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.secretaria;

import java.util.Arrays;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Solicitud;
import sistemadeactivos.logic.Usuario;


public class SecretariaController {
    Model domainModel;
    Session session;
    SecretariaView view;
    SecretariaModel model;
    
    public SecretariaController(SecretariaView view, SecretariaModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void editar(int row){       
        Solicitud seleccionada = model.getSolicitudes().getRowAt(row); 
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        int modo;
        if (Arrays.asList(Application.ROL_ADMINISTRADOR, Application.ROL_JEFE_OCCB, Application.ROL_JEFE_RRHH,
                Application.ROL_NOTAUTHORIZED, Application.ROL_REGISTRADOR,
                Application.ROL_SECRETARIA).contains(principal.getRol())){
            
            modo=Application.MODO_EDITAR;
        }
        else{
            modo=Application.MODO_CONSULTAR;            
        }
        Application.INGRESAR_CONTROLLER.reset(modo, seleccionada);
        
    }
    
    public void show(){
        view.setVisible(true);
    }
}
