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
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Usuario;


public class PersonalsController {
    private PersonalsModel model;
    private PersonalsView view;
    Model domainModel;
    Session session;
    
    
    public PersonalsController(PersonalsView view, PersonalsModel model, Model domainModel, Session session) {
        model.reset();
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

   public void buscar(Funcionario filter) throws Exception{       
         model.setFilter(filter);
        this.refrescarBusqueda();
    }

   public void searchFuncioanrio(int row, Point position){
        model.setSeleccionado(model.getFuncionarios().getRowAt(row));
        Application.PERSONAL_CONTROLLER.show(position);
    }
    
    public void refrescarBusqueda() throws Exception{
        List<Funcionario> rows = domainModel.searchFuncionario(model.getFilter());
        model.setDependencias(rows);
        model.commit();
        if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
    }    

    public void preAgregar(Point at)throws Exception{      
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        if (!Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol().getDescripcion())){
           throw new Exception(Application.ROL_NOTAUTHORIZED);
        }else{
        Application.PERSONAL_CONTROLLER.reset(Application.MODO_AGREGAR, new Funcionario(), new Usuario());
        Application.PERSONAL_CONTROLLER.show(at);
        }
//        if (!Arrays.asList(Application.ROL_JEFE_OCCB).contains(principal.getRol().getDescripcion())){
//           throw new Exception(Application.ROL_NOTAUTHORIZED);
//        }else{
//        Application.PERSONAL_CONTROLLER.reset(Application.MODO_CONSULTAR, new Funcionario());
//        Application.PERSONAL_CONTROLLER.show(at);
//        }
        
        
    }
    
    public void editar(int row, Point at) throws Exception{       
        Funcionario seleccionada = model.getFuncionarios().getRowAt(row); 
        
        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
        
        Usuario u=this.getCurrentUser(seleccionada.getNombre());
        int modo;
        if ( !Arrays.asList(Application.ROL_JEFE_RRHH).contains(principal.getRol().getDescripcion())){
            modo=Application.MODO_EDITAR;
        }
        else{
            modo=Application.MODO_CONSULTAR;            
        }
        Application.PERSONAL_CONTROLLER.reset(modo, seleccionada, u);
        Application.PERSONAL_CONTROLLER.show(at);
    }

    public void borrar(int row){  
        Funcionario seleccionada = model.getFuncionarios().getRowAt(row); 
        try {
            domainModel.deleteFuncionario(seleccionada);
        } catch (Exception ex) { }
        List<Funcionario> rowsMod = domainModel.searchFuncionario(model.getFilter());
        model.setDependencias(rowsMod);
        model.commit();
    }
    
        Usuario getCurrentUser(String userName)throws Exception {
       List<Usuario> resultado = new ArrayList<Usuario>();
       
        resultado= domainModel.getUsuarios(userName);
        
        
        for(Usuario u:resultado){
            if(u.getFuncionario().getNombre().equals(userName)){
                return u;
            }
        }
        
        return null;
    }

    public void reset(){
        model.reset();
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
    
}
