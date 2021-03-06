/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Puesto;
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

    public PersonalController(PersonalView view, PersonalModel model, Model domainModel, Session session) {

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

    public void reset() {
        model.reset();
    }

    public void reset(int modo, Funcionario current, Usuario userr) {
        model.reset(modo, current, userr);
    }

    public void show() {
        
        view.setVisible(true);
    }

    public void show(Point position) {
        view.setLocation(position);
        this.show();
    }

    public void hide() {
        view.setVisible(false);
    }

    public void guardar(Funcionario funcionario) throws Exception {

        switch (model.getModo()) {
            case Application.MODO_AGREGAR:  // si esta agregando una persona desde cero 
                domainModel.addFuncionario(funcionario);
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                model.commit();
                break;
            case Application.MODO_EDITAR: // si esta actualizando los datos de una persona en espesifica
                domainModel.updateFuncionario(funcionario);  // Manda a la base de datos la actualizacion de la persona
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                break;
        }
    }

    public void guardarUsuario(Usuario user) throws Exception {
        Funcionario fun = new Funcionario();

        switch (model.getModo()) {
            case Application.MODO_AGREGAR:

                domainModel.addFuncionario(user.getFuncionario());
                fun = domainModel.getFuncionario(user.getFuncionario().getNombre());
                model.setCurrent(fun);
                // si esta agregando una persona desde cero
                user.setFuncionario(fun);
                domainModel.addUsuario(user);
                model.setCurrent(fun);
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                model.commit();
                break;

            case Application.MODO_EDITAR: // si esta actualizando los datos de una persona en espesifica
                domainModel.upadateUsuario(user);  // Manda a la base de datos la actualizacion de la persona
                Application.PERSONALS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Funcionario());
                model.commit();
                break;
                
          
        }

    }
    
    public void updatePuesto(Puesto p){
        
    }

    public void updateUsuario(Usuario user) throws Exception {
        Funcionario fun = new Funcionario();

        switch (model.getModo()) {
            case Application.MODO_EDITAR: {

                domainModel.addFuncionario(user.getFuncionario());
                fun = domainModel.getFuncionario(user.getFuncionario().getNombre());
                model.setCurrent(fun);
                // si esta agregando una persona desde cero
                user.setFuncionario(fun);
                domainModel.upadateUsuario(user);
                model.setCurrent(new Funcionario());
            }
            Application.PERSONALS_CONTROLLER.refrescarBusqueda();
            model.setCurrent(new Funcionario());
            model.commit();
            break;

        }

    }

    public Rol getRol(String rol) throws Exception {
        Rol r = new Rol();
        if (rol == "Administrador Dependencia") {
            r = domainModel.getRol(Application.ROL_ADMINISTRADOR);
        }
        if (rol == "Secretaria") {
            r = domainModel.getRol(Application.ROL_SECRETARIA);
        }
        if (rol == "Jefe OCCBB") {
            r = domainModel.getRol(Application.ROL_JEFE_OCCB);
        }
        if (rol == "Jefe RRHH") {
            r = domainModel.getRol(Application.ROL_JEFE_RRHH);
        }
        return r;
    }

    public int getRolPos(String rol) throws Exception {

        if (rol == Application.ROL_ADMINISTRADOR) {
            return 0;
        }
        if (rol == Application.ROL_SECRETARIA) {
            return 1;
        }
        if (rol == Application.ROL_JEFE_OCCB) {
            return 2;
        }
        if (rol == Application.ROL_JEFE_RRHH) {
            return 3;
        }
        return 0;
    }

    Usuario getCurrentUser(String userName) throws Exception {
        List<Usuario> resultado = new ArrayList<Usuario>();

        resultado = domainModel.getUsuarios(userName);

        for (Usuario u : resultado) {
            if (u.getFuncionario().getNombre() == userName) {
                return u;
            }
        }

        return null;
    }
    
    
    public void addDependencia(){
        
        Application.DEPENDENCIAS_CONTROLLER.setModo(Application.MODO_AGREGAR_DEP);
        Application.DEPENDENCIAS_CONTROLLER.show();
   
    }
    public void addPuesto(){
        
        Application.PUESTOS_CONTROLLER.setModo(Application.MODO_AGREGAR_DEP);
        if(model.getDependencia()!= null){
            Application.PUESTOS_CONTROLLER.getModel().p=model.getDependencia();
        }
        
        Application.PUESTOS_CONTROLLER.show();
   
    }
    
}
