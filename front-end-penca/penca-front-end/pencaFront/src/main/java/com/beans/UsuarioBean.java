/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.apuesta;
import com.entity.apuestaRealizada;
import com.entity.penca;
import com.entity.posicion;
import com.entity.usuario;
import com.restClient.rankingRestClient;
import com.restClient.usuarioRestClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private List<apuesta> ApuestasEnSesion = new ArrayList();

    /**
     * Creates a new instance of UsuarioBean
     */
    @PostConstruct
    public void init() {
       inicializarApuesta();
    }
    
    public void inicializarApuesta(){
        apuesta apuesta1= new apuesta();
        apuesta1.setPartido("400");
        apuesta1.setPencaid("150003");
        apuesta1.setRes1(0);
        apuesta1.setRes2(0);
        apuesta1.setUsuario("Rodrigo");
        ApuestasEnSesion.add(apuesta1);
       
        apuesta apuesta2= new apuesta();
        apuesta2.setPartido("400");
        apuesta2.setPencaid("150002");
        apuesta2.setRes1(1);
        apuesta2.setRes2(0);
        apuesta2.setUsuario("Rodrigo");
         ApuestasEnSesion.add(apuesta2);
        
        apuesta apuesta3= new apuesta();
        apuesta3.setPartido("400");
        apuesta3.setPencaid("150001");
        apuesta3.setRes1(1);
        apuesta3.setRes2(0);
        apuesta3.setUsuario("Rodrigo");
         ApuestasEnSesion.add(apuesta3);
         
         apuesta apuesta0= new apuesta();
        apuesta1.setPartido("400");
        apuesta1.setPencaid("0");
        apuesta1.setRes1(0);
        apuesta1.setRes2(0);
        apuesta1.setUsuario("Rodrigo");
        ApuestasEnSesion.add(apuesta1);
    }
    
    
    
    
    public UsuarioBean() {
    }

    public String buscar() {
        usuarioEnEdicion = restClient.obtenerPorId(usuarioPk);
        return "page1";
        //return "/fragmentos/listadoPenca";
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
