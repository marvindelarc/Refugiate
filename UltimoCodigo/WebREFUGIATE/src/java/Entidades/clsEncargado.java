/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Paulo
 */
public class clsEncargado {
    private int int_IdEncargado;
    private String str_Nombre;
    private String str_Apellido;
    private String str_Usuario;
    private String str_Password;
    private int int_Estado;
    private String str_Email;
    private clsSucursal objSucursal;
    private String str_Celular;

    public clsEncargado() {
    }

    public int getInt_IdEncargado() {
        return int_IdEncargado;
    }

    public void setInt_IdEncargado(int int_IdEncargado) {
        this.int_IdEncargado = int_IdEncargado;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public String getStr_Apellido() {
        return str_Apellido;
    }

    public void setStr_Apellido(String str_Apellido) {
        this.str_Apellido = str_Apellido;
    }

    public String getStr_Usuario() {
        return str_Usuario;
    }

    public void setStr_Usuario(String str_Usuario) {
        this.str_Usuario = str_Usuario;
    }

    public String getStr_Password() {
        return str_Password;
    }

    public void setStr_Password(String str_Password) {
        this.str_Password = str_Password;
    }

    public int getInt_Estado() {
        return int_Estado;
    }

    public void setInt_Estado(int int_Estado) {
        this.int_Estado = int_Estado;
    }

    public String getStr_Email() {
        return str_Email;
    }

    public void setStr_Email(String str_Email) {
        this.str_Email = str_Email;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

    public String getStr_Celular() {
        return str_Celular;
    }

    public void setStr_Celular(String str_Celular) {
        this.str_Celular = str_Celular;
    }
    
    
    
}
