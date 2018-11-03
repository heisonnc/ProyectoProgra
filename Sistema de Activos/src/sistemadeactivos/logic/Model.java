/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.logic;

import java.util.List;
import sistemadeactivos.data.Dao;

/**
 *
 * @author mauri
 */
public class Model {
    private Dao dao;
     
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }
    private Model(){
        dao = new Dao();
    }
    
    public  Usuario getUsuario(String id, String clave) throws Exception{
        Usuario u= dao.usuarioGet(id);
        if (u.getClave().equals(clave)){
            return u;
        }
        else{
            throw new Exception ("Clave incorrecta");
        }
    }
    
    public List<Dependencia> searchDependencias(Dependencia filtro){
        return dao.DependenciaSearch(filtro);
    }
    
    public void deleteDependencia(Dependencia p) throws Exception{
        dao.DependenciaDelete(p);
    }
    
    public void addDependencia(Dependencia persona) throws Exception{
        dao.DependenciaAdd(persona);
    }

    public void updateDependencia(Dependencia persona) throws Exception{
        dao.DependenciaUpdate(persona);
    }
    
    public void close(){
        dao.close();
    }
}
