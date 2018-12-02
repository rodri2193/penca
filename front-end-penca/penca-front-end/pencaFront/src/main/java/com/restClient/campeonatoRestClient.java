/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restClient;

import com.entity.campeonato;
import com.entity.usuario;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author notebook
 */
@Named
@RequestScoped
public class campeonatoRestClient implements Serializable {

    public campeonatoRestClient() {

    }

    public campeonato obtenerPorId(String campeonato_pk) {
        WebTarget webTarget = restClient.getWebTarget("campeonato");
        campeonato camp = new campeonato();
        camp = restClient.invokeGet(webTarget, campeonato.class, campeonato_pk);

        return camp;
    }
}
