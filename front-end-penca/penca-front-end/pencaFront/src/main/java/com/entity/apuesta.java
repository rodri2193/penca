/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;

/**
 *
 * @author notebook
 */
public class apuesta implements Serializable {
    
    String pencaid;
    String usuario;
    String partido;
    Integer res1;
    Integer res2;
    
    public void apuesta(){
        
    }

    public String getPencaid() {
        return pencaid;
    }

    public void setPencaid(String pencaid) {
        this.pencaid = pencaid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Integer getRes1() {
        return res1;
    }

    public void setRes1(Integer res1) {
        this.res1 = res1;
    }

    public Integer getRes2() {
        return res2;
    }

    public void setRes2(Integer res2) {
        this.res2 = res2;
    }

    @Override
    public String toString() {
        return "{" + "\"pencaid\":\"" + pencaid + "\", \"usuario\":\"" + usuario + "\",\"partido\":\"" + partido + "\",\"res1\":" + res1 + ",\"res2\":" + res2 + '}';
    }
    
}
