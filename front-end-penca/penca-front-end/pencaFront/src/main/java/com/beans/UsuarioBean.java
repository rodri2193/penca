/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.apuesta;
import com.entity.apuestaRealizada;
import com.entity.usuario;
import com.restClient.usuarioRestClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author notebook
 */

@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    
    @Inject
    private usuarioRestClient restClient;
    
    private String usuarioPk;
    private usuario usuarioEnEdicion;
    private List<apuesta> ApuestasEnSesion=new ArrayList();
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public String buscar(){
        usuarioEnEdicion=restClient.obtenerPorId(usuarioPk);
        return "/fragmentos/listadoPenca";
    }

    public String getUsuarioPk() {
        return usuarioPk;
    }

    public void setUsuarioPk(String usuarioPk) {
        this.usuarioPk = usuarioPk;
    }

    public usuario getUsuarioEnEdicion() {
        return usuarioEnEdicion;
    }

    public void setUsuarioEnEdicion(usuario usuarioEnEdicion) {
        this.usuarioEnEdicion = usuarioEnEdicion;
    }

    public List<apuesta> getApuestasEnSesion() {
        return ApuestasEnSesion;
    }

    public void setApuestasEnSesion(List<apuesta> ApuestasEnSesion) {
        this.ApuestasEnSesion = ApuestasEnSesion;
    }

   

   
    
    
    
}
