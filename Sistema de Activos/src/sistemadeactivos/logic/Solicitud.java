/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.logic;

import java.util.Date;

/**
 *
 * @author mauri
 */
public class Solicitud {
     private Adquisicion adquisicion;
     private Dependencia dependencia;
     private Estado estado;
     private Funcionario funcionario;
     private Date fecha;
     private int cantidadBienes;
     private double montoTotal;
     private String rechazo;
     private String comprobante;

    public Solicitud() {
        this.fecha = new Date();
        this.cantidadBienes = 0;
        this.montoTotal = 0.0;
        this.comprobante = "";
        this.rechazo = "";
    }
    
    public Solicitud(Adquisicion adquisicion, Dependencia dependencia, Estado estado, Funcionario funcionario, Date fecha, int cantidadBienes, double montoTotal, String comprobante) {
       this.adquisicion = adquisicion;
       this.dependencia = dependencia;
       this.estado = estado;
       this.funcionario = funcionario;
       this.fecha = fecha;
       this.cantidadBienes = cantidadBienes;
       this.montoTotal = montoTotal;
       this.rechazo = "";
       this.comprobante = comprobante;
    }
    public Adquisicion getAdquisicion() {
        return this.adquisicion;
    }
    
    public void setAdquisicion(Adquisicion adquisicion) {
        this.adquisicion = adquisicion;
    }
    public Dependencia getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidadBienes() {
        return this.cantidadBienes;
    }
    
    public void setCantidadBienes(int cantidadBienes) {
        this.cantidadBienes = cantidadBienes;
    }
    public double getMontoTotal() {
        return this.montoTotal;
    }
    
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    public String getRechazo() {
        return this.rechazo;
    }
    
    public void setRechazo(String rechazo) {
        this.rechazo = rechazo;
    }
    public String getComprobante() {
        return this.comprobante;
    }
    
    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }
}
