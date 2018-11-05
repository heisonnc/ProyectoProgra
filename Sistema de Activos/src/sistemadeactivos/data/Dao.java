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
            Bien b = bien(rs);
            Puesto p = puesto(rs);
            Activo ac = new Activo();
            ac.setId(Integer.parseInt(rs.getString("id")));
            ac.setBien(b);
            ac.setPuesto(p);
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
            Categoria c = categoria(rs);
            Solicitud s = solicitud(rs);
            Bien b = new Bien();
            b.setId(Integer.parseInt(rs.getString("id")));
            b.setDescripcion(rs.getString("descripcion"));
            b.setMarca(rs.getString("marca"));
            b.setModelo(rs.getString("modelo"));
            b.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            b.setPrecioUnitario(Double.parseDouble(rs.getString("precio_unitario")));
            b.setCategoria(c);
            b.setSolicitud(s);
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
            Funcionario f = funcionario(rs);
            Dependencia d = new Dependencia();
            d.setDescripcion(rs.getString("descripcion"));
            d.setFuncionario(f);
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
            Dependencia d = dependencia(rs);
            Funcionario f = funcionario(rs);
            Puesto p = new Puesto();
            p.setId(Integer.parseInt(rs.getString("id")));
            p.setDependencia(d);
            p.setFuncionario(f);
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
            Adquisicion a = adquisicion(rs);
            Dependencia d = dependencia(rs);
            Funcionario f = funcionario(rs);
            Estado e = estado(rs);
            Solicitud s = new Solicitud();
            s.setFecha(rs.getDate("fecha"));
            s.setCantidadBienes(Integer.parseInt(rs.getString("cantidad_bienes")));
            s.setMontoTotal(Double.parseDouble(rs.getString("monto_total")));
            s.setRechazo(rs.getString("rechazo"));
            s.setComprobante(rs.getString("comprobante"));
            s.setAdquisicion(a);
            s.setDependencia(d);
            s.setFuncionario(f);
            s.setEstado(e);
            return s;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Usuario usuario(ResultSet rs) {
        try {
            Rol r =rol(rs);
            Funcionario f= funcionario(rs);
            Usuario u = new Usuario();
            u.setId(rs.getString("id"));
            u.setRol(r);
            u.setFuncionario(f);
            u.setClave(rs.getString("clave"));
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }

    //-------------------Usuario----------------------------
    public Usuario usuarioGet(String id) throws Exception {
        String sql = "select u.*,r.*,f.* "
                + "from Usuario u INNER JOIN Rol r On u.rol=r.id "
                + "INNER JOIN Funcionario f On u.funcionario= f.id "
                +"where u.id='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return usuario(rs);
        } else {
            throw new Exception("Usuario no Existe");
        }
    }

    public void UsuarioDelete(Usuario u) throws Exception{
        String sql = "delete from Usuario where id='%s'";
        sql = String.format(sql, u.getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Usuario no existe");
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
    
    public List<Usuario> UsuarioSearch(String nombre){
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            String sql = "select u.*,r.*,f.* "
                + "from Usuario u INNER JOIN Rol r On u.rol=r.id "
                + "INNER JOIN Funcionario f On u.funcionario= f.id "
                +"where f.nombre like '%%%s%%'";
            sql = String.format(sql, nombre);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(usuario(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    //---------------------Funcionario--------------------------------
    public List<Funcionario> FuncionarioSearch(Funcionario filtro) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        try {
            String sql = "select * from "
                    + "Funcionario "
                    + "where nombre like '%%%s%%'";
            sql = String.format(sql, filtro.getNombre());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(funcionario(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
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

    public void FuncionarioAdd(Funcionario f) throws Exception {
        String sql = "insert into Funcionario (nombre) "
                + "values('%s')";
        sql = String.format(sql, f.getNombre());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Funcionario ya existe");
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
    
    public List<Funcionario> searchFuncionarioByDependencia(String descripcion){
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        List<Puesto> tmp = new ArrayList<Puesto>();
        try {
            String sql = "select * from "
                    + "Puesto p"
                    + "INNER JOIN Funcionario f On p.funcionario=f.id "
                    + "INNER JOIN Dependencia d On p.dependencia=d.descripcion"
                    + "INNER JOIN Rol r On p.rol=r.id";
            sql = String.format(sql);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(funcionario(rs));
            }
        } catch (SQLException ex) {
        }
        for(Puesto p : tmp){
            if(p.getDependencia().getDescripcion().equals(descripcion)){
                resultado.add(p.getFuncionario());
            }
        }
        return resultado;
    }
    
    //--------------------Dependencia--------------------------------
    public Dependencia DependenciaGet(String id) throws Exception {
        String sql = "select d.*, f.* from Dependencia d INNER JOIN Funcionario f On d.administrador=f.id  where descripcion = '%s'";
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
            String sql = "select d.*, f.* from "
                    + "Dependencia d INNER JOIN Funcionario f On d.administrador=f.id "
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
    
    //-----------------Rol----------------------------------------
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
    
    //----------------Adquisicion----------------------------
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
    
    //------------------Estado-------------------------------
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
    
    //--------------------Categoria-----------------------------
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
    
    //-------------------Bien------------------------------
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
    
    public Bien getBien(int i) throws Exception{
        String sql = "select b.*.c.*,s.* from Bien b INNER JOIN Categoria c On b.categoria=c.id "+
                "INNER JOIN Solicitud s On b.solicitud=s.comprobante where b.id = '%d'";
        sql = String.format(sql, i);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return bien(rs);
        } else {
            throw new Exception("Bien no Existe");
        }
    }
    
    public List<Bien> getBienes(String solicitud){
        List<Bien> resultado = new ArrayList<Bien>();
        try {
            String sql = "select b.*.c.*,s.* from Bien b INNER JOIN Categoria c On b.categoria=c.id "+
                "INNER JOIN Solicitud s On b.solicitud=s.comprobante where b.id = '%d'";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(bien(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    //------------------Activo-------------------------------
    public List<Activo> ActivosSearchByCodigo(int id){
        List<Activo> resultado = new ArrayList<Activo>();
        try {
            String sql = "select a.*, b.*, p.* from "
                    + "Activo a INNER JOIN Bien b On a.bien=b.id "
                    + "INNER JOIN Puesto p On a.puesto=p.id "
                    + "where a.id like '%%%d%%'";
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
        try {
            String sql = "select a.*, b.*, p.*, c.* from "
                    + "Activo a INNER JOIN Bien b On a.bien=b.id "
                    + "INNER JOIN Puesto p On a.puesto=p.id "
                    + "INNER JOIN Categoria c On b.categoria=c.id "
                    + "where c.descripcion like '%%%s%%'";
            sql = String.format(sql, cat);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(activo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByDescripcion(String des){
        List<Activo> resultado = new ArrayList<Activo>();
        try {
            String sql = "select a.*, b.*, p.* from "
                    + "Activo a INNER JOIN Bien b On a.bien=b.id "
                    + "INNER JOIN Puesto p On a.puesto=p.id "
                    + "where b.descripcion like '%%%s%%'";
            sql = String.format(sql, des);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(activo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByResponsable(String nombre){
        List<Activo> resultado = new ArrayList<Activo>();
        try {
            String sql = "select a.*, b.*, p.*, f.* from "
                    + "Activo a INNER JOIN Bien b On a.bien=b.id "
                    + "INNER JOIN Puesto p On a.puesto=p.id "
                    + "INNER JOIN Funcionario f On p.funcionario=f.id "
                    + "where f.nombre like '%%%s%%'";
            sql = String.format(sql, nombre);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(activo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Activo> ActivosSearchByDependencia(String des){
        List<Activo> resultado = new ArrayList<Activo>();
        try {
            String sql = "select a.*, b.*, p.* from "
                    + "Activo a INNER JOIN Bien b On a.bien=b.id "
                    + "INNER JOIN Puesto p On a.puesto=p.id "
                    + "INNER JOIN Dependencia d On p.dependencia=d.descripcion "
                    + "where d.descripcion like '%%%s%%'";
            sql = String.format(sql, des);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(activo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    //--------------------Solicitud-------------------------------
    
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
    
    public Solicitud SolicitudGet(String combrobante)throws Exception{
        String sql = "select s.*, a.*, d.*, f.* from "
                    + "Solicitud s INNER JOIN Adquisicion a On s.adquisicion=a.id "
                    + "INNER JOIN Estado e On s.estado=e.id "
                    + "INNER JOIN Dependencia d On s.dependencia=d.descripcion "
                    + "INNER JOIN Funcionario f On s.registrador=f.id "
                    + "where s.combrobante='%s'";
        sql = String.format(sql, combrobante);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return solicitud(rs);
        } else {
            throw new Exception("Solicitud no Existe");
        }
    }
    
    public List<Solicitud> SolicitudesGet(String comprobante){
        List<Solicitud> resultado = new ArrayList<Solicitud>();
        try {
            String sql = "select s.*, a.*, d.*, f.* from "
                    + "Solicitud s INNER JOIN Adquisicion a On s.adquisicion=a.id "
                    + "INNER JOIN Estado e On s.estado=e.id "
                    + "INNER JOIN Dependencia d On s.dependencia=d.descripcion "
                    + "INNER JOIN Funcionario f On s.registrador=f.id "
                    + "where s.combrobante like '%%%s%%'";
            sql = String.format(sql, comprobante);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(solicitud(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    
    
    public void close() {
    }
}
