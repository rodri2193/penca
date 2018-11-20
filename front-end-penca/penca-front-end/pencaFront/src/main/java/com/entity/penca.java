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

public class penca  implements Serializable {
    
    private String penca_pk;
    private String codigo;
    private String campeonato_fk;
    
    public penca(){
        
    }

    public String getPenca_pk() {
        return penca_pk;
    }

    public void setPenca_pk(String penca_pk) {
        this.penca_pk = penca_pk;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCampeonato_fk() {
        return campeonato_fk;
    }

    public void setCampeonato_fk(String campeonato_fk) {
        this.campeonato_fk = campeonato_fk;
    }
        
}
