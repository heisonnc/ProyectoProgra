/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemadeactivos.logic.Activo;
import sistemadeactivos.logic.Adquisicion;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Categoria;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Estado;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Puesto;
import sistemadeactivos.logic.Rol;
import sistemadeactivos.logic.Solicitud;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author mauri
 */
public class Dao {

    RelDataBase db;

    public Dao() {
        db = new RelDataBase();
    }

    private Activo activo(ResultSet rs) {
        try {
            Activo ac = new Activo();
            ac.setId(Integer.parseInt(rs.getString("id")));
            ac.setBien(bien(rs));
            ac.setPuesto(puesto(rs));
            return ac;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Adquisicion adquisicion(ResultSet rs) {
        try {
            Adquisicion ad = new Adquisicion();
            ad.setId(Integer.parseInt(rs.getString("id")));
            ad.setDescripcion(rs.getString("descripcion"));
            return ad;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Bien bien(ResultSet rs) {
        try {
            Bien b = new Bien();
            b.setId(Integer.parseInt(rs.getString("id")));
            b.setDescripcion(rs.getString("descripcion"));
            b.setMarca(rs.getString("marca"));
            b.setModelo(rs.getString("modelo"));
            b.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            b.setPrecioUnitario(Double.parseDouble(rs.getString("precio_unitario")));
            b.setCategoria(categoria(rs));
            b.setSolicitud(solicitud(rs));
            return b;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Categoria categoria(ResultSet rs){
        try {
            Categoria c = new Categoria();
            c.setId(Integer.parseInt(rs.getString("id")));
            c.setDescripcion(rs.getString("descripcion"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Dependencia dependencia(ResultSet rs){
        try {
            Dependencia d = new Dependencia();
            d.setId(Integer.parseInt(rs.getString("id")));
            d.setDescripcion(rs.getString("descripcion"));
            d.setFuncionario(funcionario(rs));
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }
            
    private Estado estado(ResultSet rs){
        try {
            Estado e = new Estado();
            e.setId(Integer.parseInt(rs.getString("id")));
            e.setDescripcion(rs.getString("descripcion"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Funcionario funcionario(ResultSet rs){
        try {
            Funcionario f = new Funcionario();
            f.setId(Integer.parseInt(rs.getString("id")));
            f.setNombre(rs.getString("nombre"));
            return f;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Puesto puesto(ResultSet rs){
        try {
            Puesto p = new Puesto();
            p.setId(Integer.parseInt(rs.getString("id")));
            p.setDependencia(dependencia(rs));
            p.setFuncionario(funcionario(rs));
            p.setRol(rol(rs));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Rol rol(ResultSet rs){
        try {
            Rol r = new Rol();
            r.setId(Integer.parseInt(rs.getString("id")));
            r.setDescripcion(rs.getString("descripcion"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Solicitud solicitud(ResultSet rs){
        try {
            Solicitud s = new Solicitud();
            s.setId(Integer.parseInt(rs.getString("id")));
            s.setFecha(rs.getDate("fecha"));
            s.setCantidadBienes(Integer.parseInt(rs.getString("cantidad_bienes")));
            s.setMontoTotal(Double.parseDouble(rs.getString("monto_total")));
            s.setRechazo(rs.getString("rechazo"));
            s.setComprobante(rs.getString("comprobante"));
            s.setAdquisicion(adquisicion(rs));
            s.setDependencia(dependencia(rs));
            s.setFuncionario(funcionario(rs));
            s.setEstado(estado(rs));
            return s;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Usuario usuario(ResultSet rs){
        try {
            Usuario u = new Usuario();
            u.setId(rs.getString("id"));
            u.setFuncionario(funcionario(rs));
            u.setRol(rol(rs));
            u.setClave(rs.getString("clave"));
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Usuario usuarioGet(String id) throws Exception{
        String sql="select * from Usuario where id='%s'";
        sql = String.format(sql,id);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return usuario(rs);
        }
        else{
            throw new Exception ("Usuario no Existe");
        }
    }
    
    public Dependencia DependenciaGet(String id) throws Exception{
        String sql = "select * from Dependencia where descripcion = '%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if(rs.next()){
            return dependencia(rs);
        }else{
            throw new Exception ("Dependencia no Existe");
        }
    }
    
    public List<Dependencia> DependenciaSearch(Dependencia filtro){
        List<Dependencia> resultado = new ArrayList<Dependencia>();
        try {
            String sql="select * from "+
                    "Dependencia "+
                    "where descripcion like '%%%s%%'";
            sql=String.format(sql,filtro.getDescripcion());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(dependencia(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
    
      public List<Funcionario> FuncionarioSearch(Funcionario filtro){
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        try {
            String sql="select * from "+
                    "Funcionario "+
                    "where descripcion like '%%%s%%'";
            sql=String.format(sql,filtro.getNombre());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(funcionario(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
    
    public void DependenciaDelete(Dependencia d) throws Exception{
        String sql="delete from Dependencia where descripcion='%s'";
        sql = String.format(sql,d.getDescripcion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Dependencia no existe");
        }
    }
    
    public void DependenciaAdd(Dependencia p) throws Exception{
        String sql="insert into Dependencia (id, administrador, descripcion) "+
                "values('%i','%i','%s')";
        sql=String.format(sql,p.getId(),p.getFuncionario().getId(), p.getDescripcion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Dependencia ya existe");
        }
    }

    public void DependenciaUpdate(Dependencia p) throws Exception{
        String sql="update dependencia set descripcion='%s', administrador='%i'" +
                "where id='%s'";
        sql=String.format(sql,p.getDescripcion(), p.getDescripcion(), p.getFuncionario().getId());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Dependencia no existe");
        }
    }
    
     public void FuncionarioAdd(Funcionario f) throws Exception{
        String sql="insert into Funcionario (nombre) "+
                "values('%i')";
        sql=String.format(sql,f.getId(),f.getNombre());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Funcionario ya existe");
        }
    }
     
      public void FuncionarioUpdate(Funcionario f) throws Exception{
        String sql="insert into Funcionario (nombre) "+
                "values('%i')";
        sql=String.format(sql,f.getNombre());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Funcioanrio ya existe");
        }  
    }
      public void FuncionarioDelete(Funcionario d) throws Exception{
        String sql="delete from Funcionario where nombre='%s'";
        sql = String.format(sql,d.getNombre());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Funcionario no existe");
        }
    }
    
   public  void close(){
    }
}
