/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restClient;

import com.constantes.constantes;
import com.entity.apuesta;
import com.entity.apuestaRealizada;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author notebook
 */
@Named
@RequestScoped
public class apuestaRestClient implements Serializable {

    public apuestaRestClient() {

    }

    public apuesta obtenerPorId(String campeonato_pk) {
        WebTarget webTarget = restClient.getWebTarget("apuesta");
        apuesta apu = new apuesta();
        apu = restClient.invokeGet(webTarget, apuesta.class, campeonato_pk);

        return apu;
    }

    public List<apuestaRealizada> buscar(String pencaid, String usuarioid) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(constantes.url + "/apuesta-usuario/");
        Response response = target.queryParam("penca", pencaid).queryParam("usuario", usuarioid).request(MediaType.APPLICATION_JSON).get();
        apuestaRealizada[] listapu = restClient.respond(response, apuestaRealizada[].class);
        client.close();
        return Arrays.asList(listapu);
    }

    public String crearApuesta(apuesta apu) {
        Client client = ClientBuilder.newClient();
        String uriJson = "%7B+++++%22pencaid%22+%3A+%22" + apu.getPencaid()
                + "%22%2C+++++%22usuario%22+%3A+%22" + apu.getUsuario()
                + "%22%2C+++++%22partido%22+%3A+%22" + apu.getPartido()
                + "%22%2C+++++%22res1%22+%3A+" + apu.getRes1()
                + "%2C+++++%22res2%22+%3A++" + apu.getRes2() + "+%7D";
        WebTarget target = client.target("https://sqs.us-west-1.amazonaws.com/675568721055/SQSPenca?Action=SendMessage&MessageBody=" + uriJson);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        client.close();
        return "todook";
    }
}
