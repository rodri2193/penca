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
public class apuestaRealizada implements Serializable {

    String penca;
    String usuario;
    String partido;
    String partidoUsuario;
    Integer resultado2;
    Integer resultado1;
    Integer scoreDiference;

    public void apuestaRealizada() {

    }

    public String getPenca() {
        return penca;
    }

    public void setPenca(String penca) {
        this.penca = penca;
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

    public String getPartidoUsuario() {
        return partidoUsuario;
    }

    public void setPartidoUsuario(String partidoUsuario) {
        this.partidoUsuario = partidoUsuario;
    }

    public Integer getResultado2() {
        return resultado2;
    }

    public void setResultado2(Integer resultado2) {
        this.resultado2 = resultado2;
    }

    public Integer getResultado1() {
        return resultado1;
    }

    public void setResultado1(Integer resultado1) {
        this.resultado1 = resultado1;
    }

    public Integer getScoreDiference() {
        return scoreDiference;
    }

    public void setScoreDiference(Integer scoreDiference) {
        this.scoreDiference = scoreDiference;
    }

}
