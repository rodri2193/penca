/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author notebook
 */

public class campeonato  implements Serializable {
    
    private String campeonato_pk;
    private String codigo;
    private List<partido> partidos;
    
    public campeonato(){
        partidos=new ArrayList();
    }

    public String getCampeonato_pk() {
        return campeonato_pk;
    }

    public void setCampeonato_pk(String campeonato_pk) {
        this.campeonato_pk = campeonato_pk;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<partido> partidos) {
        this.partidos = partidos;
    }
        
}
