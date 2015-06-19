/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

/**
 *
 * @author EdHam
 */
public class gipUsuario {
    private int pk_id;
    private boolean mail;
    private boolean voz;

    public gipUsuario() {
        this.voz = true;
        this.pk_id = 1;
        this.mail = true;
    }

    public boolean isMail() {
        return mail;
    }

    public void setMail(boolean mail) {
        this.mail = mail;
    }

    public boolean isVoz() {
        return voz;
    }

    public void setVoz(boolean voz) {
        this.voz = voz;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }
    
    
}
