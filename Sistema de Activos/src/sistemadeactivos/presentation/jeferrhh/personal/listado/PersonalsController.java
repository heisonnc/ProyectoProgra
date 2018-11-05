/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.listado;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistemadeactivos.Application;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Activo;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Usuario;

public class PersonalsController {

    private PersonalsModel model;
    private PersonalsView view;
    Model domainModel;
    Session session;
    
    private String dep;

    public PersonalsController(PersonalsView view, PersonalsModel model, Model domainModel, Session session) {
        model.reset();
        this.domainModel = domainModel;
        this.session = session;

        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void getDep(int rows){
        
    }
    public String getDep() {
        return dep;
    }
    
    
    public void setModo(int mod){
        model.modo=mod;
    }
    
    

    public void buscar(Funcionario filter) throws Exception {
        model.setFilter(filter);
        this.refrescarBusqueda();
    }

    public void searchFuncionario(int row, Point position) {
        model.setSeleccionado(model.getFuncionarios().getRowAt(row));
        Application.PERSONAL_CONTROLLER.show(position);
    }

    public void refrescarBusqueda() throws Exception {
        
        if(model.modo==Application.MODO_AGREGAR_DEP){
        
         List<Funcionario> rows = domainModel.searchFuncionarioByDependencia(this.getDep());
        model.setFuncionarios(rows);
        model.commit();
        if (rows.isEmpty()) {
            throw new Exception("Ningún dato coincide");
        }
        }else{
       List<Funcionario> rows = domainModel.searchFuncionario(model.getFilter());
        model.setFuncionarios(rows);
        model.commit();
        if (rows.isEmpty()) {
            throw new Exception("Ningún dato coincide");
        }  
        }
        
    }

    public void preAgregar(Point at) throws Exception {
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        if (Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol().getDescripcion())) {
            Application.PERSONAL_CONTROLLER.reset(Application.MODO_AGREGAR, new Funcionario(), new Usuario());
            Application.PERSONAL_CONTROLLER.show(at);
        }else{
                throw new Exception(Application.ROL_NOTAUTHORIZED); 
                }
//        if (!Arrays.asList(Application.ROL_JEFE_OCCB).contains(principal.getRol().getDescripcion())){
//           throw new Exception(Application.ROL_NOTAUTHORIZED);
//        }else{
//        Application.PERSONAL_CONTROLLER.reset(Application.MODO_CONSULTAR, new Funcionario());
//        Application.PERSONAL_CONTROLLER.show(at);
//        }

    }

    public void editar(int row, Point at) throws Exception {
        Funcionario seleccionada = model.getFuncionarios().getRowAt(row);

        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);

        Usuario u = this.getCurrentUser(seleccionada.getNombre());
        int modo=5;
        if (Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol().getDescripcion())) {
            modo = Application.MODO_EDITAR;
            Application.PERSONAL_CONTROLLER.reset(modo, seleccionada, u);
            Application.PERSONAL_CONTROLLER.show(at);
        } else if(Arrays.asList(Application.ROL_JEFE_RRHH_DEPENDENCIA).contains(principal.getRol().getDescripcion())) {
            Usuario uu= new Usuario();
            u.setFuncionario(null);
           Application.PERSONAL_CONTROLLER.reset(Application.MODO_AGREGAR_DEP, new Funcionario(), uu);
           Application.PERSONAL_CONTROLLER.show(at);
            
        }else {
            modo = Application.MODO_CONSULTAR;
            Application.PERSONAL_CONTROLLER.reset(modo, seleccionada, u);
            Application.PERSONAL_CONTROLLER.show(at);
        }
        
    }

    public void borrar(int row) throws Exception {

        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        if (!Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol().getDescripcion())) {
            throw new Exception(Application.ROL_NOTAUTHORIZED);
        } else {
            Funcionario seleccionada = model.getFuncionarios().getRowAt(row);
            Usuario user = getCurrentUser(seleccionada.getNombre());

            domainModel.deleteUsuario(user);
            domainModel.deleteFuncionario(seleccionada);

            List<Funcionario> rowsMod = domainModel.searchFuncionario(model.getFilter());
            model.setFuncionarios(rowsMod);
            model.commit();
        }
    }

   public Usuario getCurrentUser(String userName) throws Exception {
        List<Usuario> resultado = new ArrayList<Usuario>();

        resultado = domainModel.getUsuarios(userName);

        for (Usuario u : resultado) {
            if (u.getFuncionario().getNombre().equals(userName)) {
                return u;
            }
        }

        return null;
    }
    
   public void buscaAdm(int row){
       if(model.modo==Application.MODO_AGREGAR_DEP){
        model.seleccionado=this.model.funcionarios.getRowAt(row);
        Application.DEPENDENCIA_CONTROLLER.getModel().setFun(model.seleccionado);  
       }
       
   }

    public void reset() {
        model.reset();
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

}
