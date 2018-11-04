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

    private Categoria categoria(ResultSet rs) {
        try {
            Categoria c = new Categoria();
            c.setId(Integer.parseInt(rs.getString("id")));
            c.setDescripcion(rs.getString("descripcion"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Dependencia dependencia(ResultSet rs) {
        try {
            Dependencia d = new Dependencia();
            d.setDescripcion(rs.getString("descripcion"));
            d.setFuncionario(funcionario(rs));
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Estado estado(ResultSet rs) {
        try {
            Estado e = new Estado();
            e.setId(Integer.parseInt(rs.getString("id")));
            e.setDescripcion(rs.getString("descripcion"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Funcionario funcionario(ResultSet rs) {
        try {
            Funcionario f = new Funcionario();
            f.setId(Integer.parseInt(rs.getString("id")));
            f.setNombre(rs.getString("nombre"));
            return f;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Puesto puesto(ResultSet rs) {
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

    private Rol rol(ResultSet rs) {
        try {
            Rol r = new Rol();
            r.setId(Integer.parseInt(rs.getString("id")));
            r.setDescripcion(rs.getString("descripcion"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Solicitud solicitud(ResultSet rs) {
        try {
            Solicitud s = new Solicitud();
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

    private Usuario usuario(ResultSet rs) {
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

    public Usuario usuarioGet(String id) throws Exception {
        String sql = "select * from Usuario where id='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return usuario(rs);
        } else {
            throw new Exception("Usuario no Existe");
        }
    }

    public Dependencia DependenciaGet(String id) throws Exception {
        String sql = "select * from Dependencia where descripcion = '%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return dependencia(rs);
        } else {
            throw new Exception("Dependencia no Existe");
        }
    }

    public List<Dependencia> DependenciaSearch(Dependencia filtro) {
        List<Dependencia> resultado = new ArrayList<Dependencia>();
        try {
            String sql = "select * from "
                    + "Dependencia "
                    + "where descripcion like '%%%s%%'";
            sql = String.format(sql, filtro.getDescripcion());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(dependencia(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public List<Funcionario> FuncionarioSearch(Funcionario filtro) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        try {
            String sql = "select * from "
                    + "Funcionario "
                    + "where descripcion like '%%%s%%'";
            sql = String.format(sql, filtro.getNombre());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(funcionario(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public void DependenciaDelete(Dependencia d) throws Exception {
        String sql = "delete from Dependencia where descripcion='%s'";
        sql = String.format(sql, d.getDescripcion());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Dependencia no existe");
        }
    }

    public void DependenciaAdd(Dependencia p) throws Exception {
        String sql = "insert into Dependencia (administrador, descripcion) "
                + "values('%d','%s')";
        sql = String.format(sql, p.getFuncionario().getId(), p.getDescripcion());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Dependencia ya existe");
        }
    }

    public void DependenciaUpdate(Dependencia p) throws Exception {
        String sql = "update Dependencia set descripcion='%s', administrador='%d'"
                + "where id='%s'";
        sql = String.format(sql, p.getDescripcion(), p.getFuncionario().getId());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Dependencia no existe");
        }
    }

    public void FuncionarioAdd(Funcionario f) throws Exception {
        String sql = "insert into Funcionario (nombre) "
                + "values('%s')";
        sql = String.format(sql, f.getNombre());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Funcionario ya existe");
        }
    }

    public void FuncionarioUpdate(Funcionario f) throws Exception {
        String sql = "update Dependencia set nombre='%s'"
                + "where id='%d'";
        sql = String.format(sql, f.getNombre(), f.getId());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Dependencia no existe");
        }
    }

    public void FuncionarioDelete(Funcionario d) throws Exception {
        String sql = "delete from Funcionario where nombre='%s'";
        sql = String.format(sql, d.getNombre());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Funcionario no existe");
        }
    }

    public Rol rolGet(String descripcion) throws Exception {
        String sql = "select * from Rol where descripcion='%s'";
        sql = String.format(sql, descripcion);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return rol(rs);
        } else {
            throw new Exception("Rol no Existe");
        }
    }
    
    public Funcionario FuncionarioGet(String nombre) throws Exception{
        String sql = "select * from Funcionario where nombre='%s'";
        sql = String.format(sql, nombre);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return funcionario(rs);
        } else {
            throw new Exception("Funcionario no Existe");
        }
    }

    public List<Rol> rolesGet() {
        List<Rol> resultado = new ArrayList<Rol>();
        try {
            String sql = "select * from Rol ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(rol(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public Adquisicion adquisicionGet(String descripcion) throws Exception {
        String sql = "select * from Adquisicion where descripcion='%s'";
        sql = String.format(sql, descripcion);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return adquisicion(rs);
        } else {
            throw new Exception("Adquisicion no Existe");
        }
    }

    public List<Adquisicion> adquisicionesGet() {
        List<Adquisicion> resultado = new ArrayList<Adquisicion>();
        try {
            String sql = "select * from Rol ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(adquisicion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Estado estadoGet(String descripcion) throws Exception {
        String sql = "select * from Estado where descripcion='%s'";
        sql = String.format(sql, descripcion);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return estado(rs);
        } else {
            throw new Exception("Estado no Existe");
        }
    }

    public List<Estado> estadosGet() {
        List<Estado> resultado = new ArrayList<Estado>();
        try {
            String sql = "select * from Estado ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(estado(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Categoria categoriaGet(String descripcion) throws Exception {
        String sql = "select * from Categoria where descripcion='%s'";
        sql = String.format(sql, descripcion);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return categoria(rs);
        } else {
            throw new Exception("Categoria no Existe");
        }
    }

    public List<Categoria> categoriasGet() {
        List<Categoria> resultado = new ArrayList<Categoria>();
        try {
            String sql = "select * from Categoria ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(categoria(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public void BienAdd(Bien b) throws Exception{
        String sql = "insert into Bien (descripcion, marca, modelo, precio_unitario, cantidad, solicitud, categoria) "
                + "values('%s', '%s', '%s', '%f', '%s', '%d')";
        sql = String.format(sql, b.getDescripcion(), b.getMarca(), b.getModelo(), b.getPrecioUnitario(), b.getCantidad(), b.getSolicitud().getComprobante(), b.getCategoria().getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Bien ya existe");
        }
    }
    
    public void BienUpdate(Bien b) throws Exception{
        String sql = "update Bien set descripcion='%s', marca='%s', modelo='%s', precio_unitario='%f', cantidad='%d', solicitud='%s', categoria='%d'"
                + "where id='%s'";
        sql = String.format(sql, b.getDescripcion(), b.getMarca(), b.getModelo(), b.getPrecioUnitario(), b.getCantidad(), b.getSolicitud().getComprobante(), b.getCategoria().getId());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Bien no existe");
        }
    }
    
    public List<Activo> ActivosSearchByCodigo(int id){
        List<Activo> resultado = new ArrayList<Activo>();
        try {
            String sql = "select * from "
                    + "Activo "
                    + "where id like '%d'";
            sql = String.format(sql, id);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(activo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByCategoria(String cat){
        List<Activo> resultado = new ArrayList<Activo>();
        try{
            String sql = "select * from Activo ";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                Activo tmp = activo(rs);
                if(tmp.getBien().getCategoria().getDescripcion().equals(cat)){
                    resultado.add(tmp);
                }
            }
        }catch(SQLException ex){
            
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByDescripcion(String des){
        List<Activo> resultado = new ArrayList<Activo>();
        try{
            String sql = "select * from Activo ";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                Activo tmp = activo(rs);
                if(tmp.getBien().getDescripcion().equals(des)){
                    resultado.add(tmp);
                }
            }
        }catch(SQLException ex){
            
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByResponsable(String nombre){
        List<Activo> resultado = new ArrayList<Activo>();
        try{
            String sql = "select * from Activo ";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                Activo tmp = activo(rs);
                if(tmp.getPuesto().getFuncionario().getNombre().equals(nombre)){
                    resultado.add(tmp);
                }
            }
        }catch(SQLException ex){
            
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByDependencia(String des){
        List<Activo> resultado = new ArrayList<Activo>();
        try{
            String sql = "select * from Activo ";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                Activo tmp = activo(rs);
                if(tmp.getPuesto().getDependencia().getDescripcion().equals(des)){
                    resultado.add(tmp);
                }
            }
        }catch(SQLException ex){
            
        }
        return resultado;
    }
    
    public void SolicitudAdd(Solicitud s) throws Exception{
        String sql = "insert into Solicitud (comprobante, fecha, cantidad_bienes, monto_total, rechazo, adquisicion, dependencia, registrador, estado) "
                + "values('%s','%s','%d', '%f', '%s','%d','%s','%d','%d')";
        sql = String.format(sql,s.getComprobante(), s.getFecha().toString(), s.getCantidadBienes(), s.getMontoTotal(), s.getRechazo(), s.getAdquisicion().getId(), s.getDependencia().getDescripcion(), s.getFuncionario().getId(), s.getEstado().getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Solicitud ya existe");
        }
    }
    
    public void SolicitudUpdate(Solicitud s) throws Exception{
        String sql = "update Solicitud set fecha='%s', cantidad_bienes='%d', monto_total='%s, rechazo='%s', adquisicion='%d', dependencia='%s', registrador='%d', estado='%d'"
                + "where combrobante='%s'";
        sql = String.format(sql, s.getFecha().toString(), s.getCantidadBienes(), s.getMontoTotal(), s.getRechazo(), s.getAdquisicion().getId(), s.getDependencia().getDescripcion(), s.getFuncionario().getId(), s.getEstado().getId(), s.getComprobante());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Solicitud no existe");
        }
    }
    
    public void UsuarioAdd(Usuario u) throws Exception{
        String sql = "insert into Usuario (id, funcionario, rol, clave) "
                + "values('%s', '%d', '%d','%s')";
        sql = String.format(sql, u.getId(), u.getFuncionario().getId(), u.getRol().getId(), u.getClave());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Usuario ya existe");
        }
    }
    
    public void UsuarioUpdate(Usuario u) throws Exception{
        String sql = "update Usuario set funcionario='%d', rol='%d', clave='%s'"
                + "where id='%s'";
        sql = String.format(sql, u.getFuncionario().getId(), u.getRol().getId(), u.getClave(), u.getId());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Dependencia no existe");
        }
    }
    
    public Solicitud SolicitudGet(String combrobante)throws Exception{
        String sql = "select * from Solicitud where comprobante='%s'";
        sql = String.format(sql, combrobante);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return solicitud(rs);
        } else {
            throw new Exception("Solicitud no Existe");
        }
    }
    
    
    
    public void close() {
    }
}
