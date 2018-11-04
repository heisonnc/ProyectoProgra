/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Rol;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author book
 */
public class PersonalController {
    private Model domainModel;
    Session session;   
    PersonalView view;
    PersonalModel model;

    public PersonalController(PersonalView view, PersonalModel model,Model domainModel, Session session) {
       
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
//        this.model.reset();
    }

    public void setDomainModel(Model domainModel) {
        this.domainModel = domainModel;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setView(PersonalView view) {
        this.view = view;
    }

    public void setModel(PersonalModel model) {
        this.model = model;
    }

    public Model getDomainModel() {
        return domainModel;
    }

    public Session getSession() {
        return session;
    }

    public PersonalView getView() {
        return view;
    }

    public PersonalModel getModel() {
        return model;
    }
    
    public void reset(){
        model.reset();
    }
    
    public void reset(int modo, Funcionario current){
        model.reset(modo, current);
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
    
    public void guardar(Funcionario funcionario) throws Exception{
      
        
          switch(model.getModo()){
            case Application.MODO_AGREGAR:  // si esta agregando una persona desde cero 
                domainModel.addFuncionario(funcionario);
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                model.commit();   
                break;
            case Application.MODO_EDITAR: // si esta actualizando los datos de una persona en espesifica
                domainModel.addFuncionario(funcionario);  // Manda a la base de datos la actualizacion de la persona
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                break;
        }    
    }
    
    public void guardarUsuario( Usuario user) throws Exception{
        Funcionario fun=new Funcionario();
        
            switch(model.getModo()){
            case Application.MODO_AGREGAR:  {
                
               domainModel.addFuncionario(user.getFuncionario());
               fun=domainModel.getFuncionario(user.getFuncionario().getNombre());
               model.setCurrent(fun);
                    // si esta agregando una persona desde cero
                    user.setFuncionario(fun);
               domainModel.addUsuario(user);
                
            }
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                model.commit();   
                break;
            case Application.MODO_EDITAR: // si esta actualizando los datos de una persona en espesifica
                domainModel.upadateUsuario(user);  // Manda a la base de datos la actualizacion de la persona
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                break;
        } 
        
    }
    
    public Rol getRol(String rol) throws Exception{
        Rol r= new Rol();
        if(rol=="Administrador Dependencia" ){
            r= domainModel.getRol(Application.ROL_ADMINISTRADOR);
        }
        if(rol=="Secretaria" ){
           r= domainModel.getRol(Application.ROL_SECRETARIA);
        }
        if(rol=="Jefe OCCBB" ){
            r= domainModel.getRol(Application.ROL_JEFE_OCCB);
        }
        if(rol=="Jefe RRHH" ){
            r= domainModel.getRol(Application.ROL_JEFE_RRHH);
        }
        return r;
    }
}
