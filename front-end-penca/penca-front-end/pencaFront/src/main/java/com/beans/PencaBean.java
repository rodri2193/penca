/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.apuesta;
import com.entity.apuestaRealizada;
import com.entity.campeonato;
import com.entity.partido;
import com.restClient.apuestaRestClient;
import com.restClient.campeonatoRestClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.omnifaces.cdi.Param;

/**
 *
 * @author notebook
 */
@Named
@ViewScoped
public class PencaBean implements Serializable {

    @Inject
    @Param(name = "pk")
    private String pk;

    @Inject
    @Param(name = "pencapk")
    private String pencapk;

    @Inject
    private campeonatoRestClient restClient;

    @Inject
    private apuestaRestClient apuestaRestClient;

    @Inject
    private UsuarioBean sessionBean;

    private campeonato campeonatoEnEdicion;
    private apuesta apuestaEnEdicion;
    private partido partidoEnEdicion;
    private String usuariopk;
    private List<apuestaRealizada> apuestasRealizadas = new ArrayList();

    /**
     * Creates a new instance of UsuarioBean
     */
    public PencaBean() {
    }

    @PostConstruct
    public void init() {
        buscar();
    }
    
  

    public void buscar() {
        usuariopk = sessionBean.getUsuarioPk();
        campeonatoEnEdicion = restClient.obtenerPorId(pk);
        apuestasRealizadas = apuestaRestClient.buscar(pencapk, usuariopk);
    }

    public void generarApuesta(partido Partido) {
        
        partidoEnEdicion = Partido;
        apuestaEnEdicion = new apuesta();
        apuestaEnEdicion.setUsuario(usuariopk);
        apuestaEnEdicion.setPencaid(pencapk);
        apuestaEnEdicion.setPartido(Partido.getPartido_pk());

    }

    public void guardarApuesta() {
        //  apuestaRestClient.crearApuesta(apuestaEnEdicion);   //METODO PARA LLAMAR A SQS
        sessionBean.getApuestasEnSesion().add(apuestaEnEdicion);
        Logger.getLogger(PencaBean.class.getName()).log(Level.SEVERE, "Sesion bean en guardar: " + sessionBean.getApuestasEnSesion().size());

        PrimeFaces.current().executeScript("PF('itemDialog').hide()");
    }

    public String verResultadoPartido(String pkPartido) {
        
        for (apuestaRealizada apuR : apuestasRealizadas) {
            if (apuR.getPartido().equals(pkPartido)) {
                return apuR.getResultado1() + "-" + apuR.getResultado2();
            }
        }
        Logger.getLogger(PencaBean.class.getName()).log(Level.SEVERE, "Sesion bean: " + sessionBean.getApuestasEnSesion().size());
        if (sessionBean.getApuestasEnSesion() != null) {
            for (apuesta apuR : sessionBean.getApuestasEnSesion()) {
                Logger.getLogger(PencaBean.class.getName()).log(Level.SEVERE, "Res 1: " + apuR.getRes1());
                if (apuR.getPartido().equals(pkPartido) && apuR.getPencaid().equals(pencapk)) {
                    return apuR.getRes1().toString() + "-" + apuR.getRes2().toString();
                }
            }
        }

        return "";
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public campeonato getCampeonatoEnEdicion() {
        return campeonatoEnEdicion;
    }

    public void setCampeonatoEnEdicion(campeonato campeonatoEnEdicion) {
        this.campeonatoEnEdicion = campeonatoEnEdicion;
    }

    public apuesta getApuestaEnEdicion() {
        return apuestaEnEdicion;
    }

    public void setApuestaEnEdicion(apuesta apuestaEnEdicion) {
        this.apuestaEnEdicion = apuestaEnEdicion;
    }

    public String getPencapk() {
        return pencapk;
    }

    public void setPencapk(String pencapk) {
        this.pencapk = pencapk;
    }

    public String getUsuariopk() {
        return usuariopk;
    }

    public void setUsuariopk(String usuariopk) {
        this.usuariopk = usuariopk;
    }

    public partido getPartidoEnEdicion() {
        return partidoEnEdicion;
    }

    public void setPartidoEnEdicion(partido partidoEnEdicion) {
        this.partidoEnEdicion = partidoEnEdicion;
    }

    public List<apuestaRealizada> getApuestasRealizadas() {
        return apuestasRealizadas;
    }

    public void setApuestasRealizadas(List<apuestaRealizada> apuestasRealizadas) {
        this.apuestasRealizadas = apuestasRealizadas;
    }

}
