/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restClient;

import com.constantes.constantes;
import com.entity.usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author notebook
 */
public class restClient {
    private static final Logger LOGGER = Logger.getLogger(restClient.class.getName());
    
    private restClient() {
    }
    
    public static WebTarget getWebTarget(String service) {
        Client client = getClient();
        WebTarget target = client.target(constantes.url+"/"+service+"/");
       
        return target;
    }

    private static Client getClient() {
        Client client = ClientBuilder.newClient();
        //client.register( ClientTracingFeature.class );
        return client;
    }
    
    public static <T> T invokeGet(WebTarget webTarget,Class<T> responseType, String primaryKey)  {
        Response response = webTarget.queryParam("pk", primaryKey).request(MediaType.APPLICATION_JSON).get(); 
        
        return respond(response, responseType);   
    }
    
    public static <T> T respond(Response response, Class<T> responseType)  {
        if (responseType == null){
            return null;
        } else if (responseType.isArray()) {
            return (T) response.readEntity(new GenericType<>(responseType));
        } else {
            return response.readEntity(responseType);
        }
    }
}
