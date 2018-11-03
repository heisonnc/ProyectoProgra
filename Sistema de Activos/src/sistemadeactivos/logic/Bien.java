/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.logic;


/**
 *
 * @author mauri
 */
public class Bien {
     private int id;
     private Categoria categoria;
     private Solicitud solicitud;
     private String descripcion;
     private String marca;
     private String modelo;
     private double precioUnitario;
     private int cantidad;

    public Bien() {
        this.descripcion = "";
        this.marca = "";
        this.modelo = "";
        this.precioUnitario = 0.0;
        this.cantidad = 0;
    }
    
    public Bien(Categoria categoria, Solicitud solicitud, String descripcion, String marca, String modelo, double precioUnitario, int cantidad) {
       this.categoria = categoria;
       this.solicitud = solicitud;
       this.descripcion = descripcion;
       this.marca = marca;
       this.modelo = modelo;
       this.precioUnitario = precioUnitario;
       this.cantidad = cantidad;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Solicitud getSolicitud() {
        return this.solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
