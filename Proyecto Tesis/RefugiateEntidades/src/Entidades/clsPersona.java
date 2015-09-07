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
public class clsPersona {
    private int IdPersona;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String DNI;    
    private Date fecnac;
    private String usuario;
    private String password;
    private int informacion;
    private int puntualidad;
    private int honrrades;
    private int educacion;
    private int calificacion;
    private boolean sexo;
    private Date fecha;
    private Date update;

    public clsPersona() {
    }

    public clsPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDNI() {
        return DNI;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getInformacion() {
        return informacion;
    }

    public int getPuntualidad() {
        return puntualidad;
    }

    public int getHonrrades() {
        return honrrades;
    }

    public int getEducacion() {
        return educacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInformacion(int informacion) {
        this.informacion = informacion;
    }

    public void setPuntualidad(int puntualidad) {
        this.puntualidad = puntualidad;
    }

    public void setHonrrades(int honrrades) {
        this.honrrades = honrrades;
    }

    public void setEducacion(int educacion) {
        this.educacion = educacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
