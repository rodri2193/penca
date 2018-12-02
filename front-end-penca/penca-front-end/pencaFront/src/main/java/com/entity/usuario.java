/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author notebook
 */
public class usuario implements Serializable {

    private String usuario_pk;
    private String codigo;
    private List<penca> pencas;

    public usuario() {
        pencas = new ArrayList();
    }

    public String getUsuario_pk() {
        return usuario_pk;
    }

    public void setUsuario_pk(String usuario_pk) {
        this.usuario_pk = usuario_pk;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<penca> getPencas() {
        return pencas;
    }

    public void setPencas(List<penca> pencas) {
        this.pencas = pencas;
    }

}
