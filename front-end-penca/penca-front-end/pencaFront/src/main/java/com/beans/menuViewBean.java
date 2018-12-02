/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author notebook
 */
@Named(value = "menuViewBean")
@SessionScoped
public class menuViewBean implements Serializable {

    /**
     * Creates a new instance of menuViewBean
     */
    public menuViewBean() {
    }

    public String processPage1() {
        return "page";
    }

    public String processPage2() {
        return "page";
    }

}
