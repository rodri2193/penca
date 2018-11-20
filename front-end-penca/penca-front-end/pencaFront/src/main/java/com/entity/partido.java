
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author notebook
 */

public class partido  implements Serializable {
    
    private String partido_pk;
    private String cuadro1;
    private String cuadro2;
    private String fecha;
    
    public partido(){
        
    }

    public String getPartido_pk() {
        return partido_pk;
    }

    public void setPartido_pk(String partido_pk) {
        this.partido_pk = partido_pk;
    }

    public String getCuadro1() {
        return cuadro1;
    }

    public void setCuadro1(String cuadro1) {
        this.cuadro1 = cuadro1;
    }

    public String getCuadro2() {
        return cuadro2;
    }

    public void setCuadro2(String cuadro2) {
        this.cuadro2 = cuadro2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "partido{" + "partido_pk=" + partido_pk + ", cuadro1=" + cuadro1 + ", cuadro2=" + cuadro2 + ", fecha=" + fecha + '}';
    }

   
 
}

