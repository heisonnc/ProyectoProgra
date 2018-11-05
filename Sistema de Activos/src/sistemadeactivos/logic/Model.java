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

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    private Model() {
        dao = new Dao();
    }

    //----------------------Usuario-----------------------------------
    public Usuario getUsuario(String id, String clave) throws Exception {
        Usuario u = dao.usuarioGet(id);
        if (u.getClave().equals(clave)) {
            return u;
        } else {
            throw new Exception("Clave incorrecta");
        }
    }

    public void addUsuario(Usuario user) throws Exception {
        dao.UsuarioAdd(user);
    }

    public void upadateUsuario(Usuario user) throws Exception {
        dao.UsuarioUpdate(user);
    }
    
    public void deleteUsuario(Usuario u) throws Exception{
        dao.UsuarioDelete(u);
    }
    
    public List<Usuario> getUsuarios(String nombre){
        return dao.UsuarioSearch(nombre);
    }
    
    //---------------------Funcionario--------------------------------
    public void addFuncionario(Funcionario funcionario) throws Exception {
        dao.FuncionarioAdd(funcionario);
    }

    public void updateFuncionario(Funcionario funcionario) throws Exception {
        dao.FuncionarioUpdate(funcionario);
    }

    public void deleteFuncionario(Funcionario f) throws Exception {
        dao.FuncionarioDelete(f);
    }

    public List<Funcionario> searchFuncionario(Funcionario filtro) {
        return dao.FuncionarioSearch(filtro);
    }
    
    public Funcionario getFuncionario(String nombre) throws Exception{
        return dao.FuncionarioGet(nombre);
    }
    
    public List<Funcionario> searchFuncionarioByDependencia(String d){
        return dao.searchFuncionarioByDependencia(d);
    }
    
    //---------------------Rol-----------------------------------------
    public Rol getRol(String rol) throws Exception {
        return dao.rolGet(rol);
    }
    
    public List<Rol> getRoles(){
        return dao.rolesGet();
    }
    
    //-------------------Estado----------------------------------------
    public Estado getEstado(String estado) throws Exception{
        return dao.estadoGet(estado);
    }
    
    public List<Estado> getEstados(){
        return dao.estadosGet();
    }
    
    //------------------Adquiscion------------------------------------
    public Adquisicion getAdquisicion(String descripcion) throws Exception{
        return dao.adquisicionGet(descripcion);
    }
    
    public List<Adquisicion> getAdquisciciones(){
        return dao.adquisicionesGet();
    }
    
    //---------------Dependencia----------------------------------
    public List<Dependencia> searchDependencias(Dependencia filtro) {
        return dao.DependenciaSearch(filtro);
    }

    public void addDependencia(Dependencia persona) throws Exception {
        dao.DependenciaAdd(persona);
    }

    public void updateDependencia(Dependencia persona) throws Exception {
        dao.DependenciaUpdate(persona);
    }

    public void deleteDependencia(Dependencia p) throws Exception {
        dao.DependenciaDelete(p);
    }
    
    public Dependencia getDependencia(String descripcion) throws Exception{
        return dao.DependenciaGet(descripcion);
    }
    
    //--------------------Categoria--------------------------------
    public Categoria getCategoria(String descripcion) throws Exception{
        return dao.categoriaGet(descripcion);
    }
    
    public List<Categoria> getCategorias(){
        return dao.categoriasGet();
    }
    
    //---------------------Bien--------------------------------
    public void addBien(Bien b) throws Exception{
        dao.BienAdd(b);
    }
    
    public void updateBien(Bien b) throws Exception{
        dao.BienUpdate(b);
    }
    
    public Bien getBien(int i) throws Exception{
        return dao.getBien(i);
    }
    
    public List<Bien> getBienes(String comprobante){
        return dao.getBienes(comprobante);
    }
    
    //-------------------Solicitud------------------------------
    public void addSolicitud(Solicitud s) throws Exception{
        dao.SolicitudAdd(s);
    }
    
    public void updateSolicitud(Solicitud s) throws Exception{
        dao.SolicitudUpdate(s);
    }
    
    public Solicitud getSolicitud(String comprobante) throws Exception{
        return dao.SolicitudGet(comprobante);
    }
    
    public List<Solicitud> getSolicitudes(String comprabante){
        return dao.SolicitudesGet(comprabante);
    }
    
    //--------------------Activo---------------------------
    public List<Activo> searchActivosByCodigo(int i){
        return dao.ActivosSearchByCodigo(i);
    }
    
    public List<Activo> searchActivosByCategoria(String cat){
        return dao.ActivosSearchByCategoria(cat);
    }
    
    public List<Activo> searchActivosByDescripcion(String des){
        return dao.ActivosSearchByDescripcion(des);
    }
    
    public List<Activo> searchActivosByDependencia(String d){
        return dao.ActivosSearchByDependencia(d);
    }
    
    public List<Activo> searchActivosByResponsable(String nombre){
        return dao.ActivosSearchByResponsable(nombre);
    }

    public void close() {
        dao.close();
    }
}
