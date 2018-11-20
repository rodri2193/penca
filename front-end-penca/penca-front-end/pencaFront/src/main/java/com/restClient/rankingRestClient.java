/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restClient;

import com.constantes.constantes;
import static com.constantes.constantes.ranking;
import com.entity.apuestaRealizada;

import com.entity.posicion;
import com.entity.ranking;
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
public class rankingRestClient implements Serializable {
    
    public rankingRestClient(){
        
    }
    
    public posicion buscarPosicionUsuario(String pencaid, String usuarioid){
         Client client = ClientBuilder.newClient();
        WebTarget target = client.target(constantes.ranking+"/prod/posusuario/");
        Response response = target.queryParam("penca", pencaid).queryParam("usuario",usuarioid).request(MediaType.APPLICATION_JSON).get(); 
        posicion pos=restClient.respond(response, posicion.class);
        client.close();
        return  pos;
    }
    
    public List<ranking> buscarListaRanking(String pencaid,Integer posdesde,Integer poshasta){
         Client client = ClientBuilder.newClient();
        WebTarget target = client.target(constantes.ranking+"/prod/ranking/");
        Response response = target.queryParam("pencaid", pencaid).queryParam("posdesde",posdesde.toString()).queryParam("poshasta",poshasta.toString()).request(MediaType.APPLICATION_JSON).get(); 
        ranking[] listapu=restClient.respond(response, ranking[].class);
        client.close();
        return  Arrays.asList(listapu);
    }
}
