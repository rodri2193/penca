/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencafront;

import com.entity.penca;
import com.entity.usuario;
import com.restClient.restClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Satya Choudhury
 */
@ManagedBean
@RequestScoped
public class GreetingsBean {

    private String userName = "holas";

    /**
     * Creates a new instance of GreetingsBean
     */
    public GreetingsBean() {
        System.out.println("Created GreetingsBean instance...");
    }

    public String getUserName() {
        try {
            System.out.println("hola");
            HttpClient client = HttpClientBuilder.create().build();
            HttpUriRequest httpUriRequest = new HttpGet("https://ccdu5kaaeg.execute-api.us-east-1.amazonaws.com/default/apuesta-partido?penca=1&partido=partido1");

            HttpResponse response;

            response = client.execute(httpUriRequest);
            String responseJSON = EntityUtils.toString(response.getEntity());
            return responseJSON;
        } catch (IOException ex) {
            Logger.getLogger(GreetingsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Error";
    }

    public String getUsuario() {
        /* Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("https://ccdu5kaaeg.execute-api.us-east-1.amazonaws.com/default/usuario");
        

        usuario usu = webTarget.queryParam("usuario", "1")
                .request()
                .get(usuario.class);
        client.close();
        return usu.getCodigo();*/
        WebTarget webTarget = restClient.getWebTarget("usuario");

        usuario usu = new usuario();
        usu = restClient.invokeGet(webTarget, usuario.class, "3");
        String coso = "pum";
        for (penca p : usu.getPencas()) {
            coso = p.getCodigo();
        }

        return coso;
    }

    public void setUserName(String userName) {
        this.userName = userName.trim();
    }

    public String greetUser() {
        return "greeting";
    }
}
