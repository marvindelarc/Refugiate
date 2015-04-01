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
public class clsWebAdmin {
    private int IdWebAdmin;
    private String Usuario;
    private String Password;
    private String Email;
    private String Nombre;
    private String Apellido;
    private int Nivel;
    private int Estado;

    public clsWebAdmin() {
    }

    public int getIdWebAdmin() {
        return IdWebAdmin;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getNivel() {
        return Nivel;
    }

    public int getEstado() {
        return Estado;
    }

    public void setIdWebAdmin(int IdWebAdmin) {
        this.IdWebAdmin = IdWebAdmin;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }    
}
