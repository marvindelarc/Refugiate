/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Paulo
 */
public class clsEncargado {
    private int int_IdEncargado;
    private String nombre;
    private String apellido;
    private String email;
    private String Celular;
    private String usuario;
    private String password;
    private int estado; 
    private int admin; 
    private clsSucursal objSucursal;

    public clsEncargado() {
    }

    public int getIdEncargado() {
        return int_IdEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return Celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getEstado() {
        return estado;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setIdEncargado(int int_IdEncargado) {
        this.int_IdEncargado = int_IdEncargado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

    public int getInt_IdEncargado() {
        return int_IdEncargado;
    }

    public void setInt_IdEncargado(int int_IdEncargado) {
        this.int_IdEncargado = int_IdEncargado;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
    
}
