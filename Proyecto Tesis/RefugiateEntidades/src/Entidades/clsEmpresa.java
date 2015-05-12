/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
/**
 *
 * @author Paulo
 */
public class clsEmpresa {
    private int idEmpresa;
    private String nombreComercial;
    private String nombre;
    private String slogan;
    private String ruc;    
    private int puntos;
    private Date fechaRegistro;
    private byte[] logo;
    private byte[] banner;
    private int estado;

    public clsEmpresa() {
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getRuc() {
        return ruc;
    }

    public int getEstado() {
        return estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public byte[] getLogo() {
        return logo;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }
}