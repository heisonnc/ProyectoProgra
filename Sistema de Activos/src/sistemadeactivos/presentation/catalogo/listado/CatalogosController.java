
package sistemadeactivos.presentation.catalogo.listado;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import sistemadeactivos.Session;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author book
 */
public class CatalogosController {
    Model domainModel;
    Session session;
    CatalogosView view;
    CatalogosModel model;
    
    public CatalogosController(CatalogosView view, CatalogosModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
//        view.setController(this);
//        view.setModel(model);
    }
    
//    public void buscar(Bien filter) throws Exception{       
//         model.setFilter(filter);
//        this.refrescarBusqueda();
//    }
//    
//    public void refrescarBusqueda() throws Exception{
//        List<Bien> rows = domainModel.getBienes(model.getFilter());
//        model.setPersonas(rows);
//        model.commit();
//        if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
//    }    
//
//    public void preAgregar(Point at)throws Exception{      
//        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
//        if ( !Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol())){
//           throw new Exception(Application.ROL_NOTAUTHORIZED);
//        }
//        Application.PERSONA_CONTROLLER.reset(Application.MODO_AGREGAR, new Persona());
//        Application.PERSONA_CONTROLLER.show(at);
//    }
//    
//    public void editar(int row, Point at){       
//        Persona seleccionada = model.getPersonas().getRowAt(row); 
//        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
//        int modo;
//        if ( Arrays.asList(Application.ROL_MANAGER, Application.ROL_SUPERVISOR).contains(principal.getRol())){
//            modo=Application.MODO_EDITAR;
//        }
//        else{
//            modo=Application.MODO_CONSULTAR;            
//        }
//        Application.PERSONA_CONTROLLER.reset(modo, seleccionada);
//        Application.PERSONA_CONTROLLER.show(at);
//    }
//
//    public void borrar(int row){  
//        Persona seleccionada = model.getPersonas().getRowAt(row); 
//        try {
//            domainModel.deletePersona(seleccionada);
//        } catch (Exception ex) { }
//        List<Persona> rowsMod = domainModel.searchPersonas(model.getFilter());
//        model.setPersonas(rowsMod);
//        model.commit();
//    }
//
//    public void searchEstado(int row, Point position){
//        model.setSeleccionado(model.getPersonas().getRowAt(row));
//        Application.ESTADOS_SEARCH_CONTROLLER.show(position);
//    }
//    
//    public void changeEstado(EstadoCivil nuevoEstado){
//        if (model.getSeleccionado()!=null){
//            model.getSeleccionado().setEstadoCivil(nuevoEstado);
//            try {
//                domainModel.updatePersona(model.getSeleccionado());
//                this.refrescarBusqueda();                
//            } catch (Exception ex) { }
//        }
//    }

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
