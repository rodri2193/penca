/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.penca;
import com.entity.posicion;
import com.entity.ranking;
import com.restClient.apuestaRestClient;
import com.restClient.rankingRestClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Param;

/**
 *
 * @author notebook
 */
@Named
@ViewScoped
public class RankingBean implements Serializable {

    @Inject
    @Param(name = "pencapk")
    private String pencapk;

    @Inject
    private rankingRestClient rankingRestClient;

    @Inject
    private UsuarioBean sessionBean;

    private String usuariopk;
    private posicion Posicion;
    private List<ranking> listRanking = new ArrayList();
    private Integer paginador = 0;

    public RankingBean() {
    }

    @PostConstruct
    public void init() {
        
          Posicion=rankingRestClient.buscarPosicionUsuario(pencapk, "\""+sessionBean.getUsuarioPk()+"\"");
          listRanking = rankingRestClient.buscarListaRanking(pencapk, paginador, paginador + 10);
    }

    public void paginadorMas() {
        if (!(listRanking.size() < 10)) {
            paginador = paginador + 10;
            listRanking = rankingRestClient.buscarListaRanking(pencapk, paginador, paginador + 10);
        }
    }

    public void paginadorMenos() {
        if (paginador != 0) {
            paginador = paginador - 10;
            listRanking = rankingRestClient.buscarListaRanking(pencapk, paginador, paginador + 10);
        }
    }
    
    public String obtenerPosicion(penca Penca){
        Logger.getLogger(PencaBean.class.getName()).log(Level.SEVERE, "Pencau: " +Penca.getPenca_pk() );
        posicion pos= rankingRestClient.buscarPosicionUsuario(Penca.getPenca_pk(), "\""+"Rodrigo"+"\"");
        if(pos!=null){
            return pos.getPosicion();
        }
        
        return null;
    }

    public String getPencapk() {
        return pencapk;
    }

    public void setPencapk(String pencapk) {
        this.pencapk = pencapk;
    }

    public posicion getPosicion() {
        return Posicion;
    }

    public void setPosicion(posicion Posicion) {
        this.Posicion = Posicion;
    }

    public List<ranking> getListRanking() {
        return listRanking;
    }

    public void setListRanking(List<ranking> listRanking) {
        this.listRanking = listRanking;
    }

    public String getUsuariopk() {
        return usuariopk;
    }

    public void setUsuariopk(String usuariopk) {
        this.usuariopk = usuariopk;
    }

    public Integer getPaginador() {
        return paginador;
    }

    public void setPaginador(Integer paginador) {
        this.paginador = paginador;
    }

}
