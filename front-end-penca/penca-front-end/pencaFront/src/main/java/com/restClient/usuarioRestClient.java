/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restClient;

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
public class usuarioRestClient implements Serializable {

    public usuarioRestClient() {

    }

    public usuario obtenerPorId(String usuario_pk) {
        WebTarget webTarget = restClient.getWebTarget("usuario");
        usuario usu=new usuario();
        usu = restClient.invokeGet(webTarget,usuario.class,usuario_pk);
       
        return usu;
    }
}
