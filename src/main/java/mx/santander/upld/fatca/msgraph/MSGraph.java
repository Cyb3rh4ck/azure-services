package mx.santander.upld.fatca.msgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import mx.santander.upld.fatca.exceptions.UnauthorizedException;
import mx.santander.upld.fatca.model.UserGraph;

/**
 * @author x661902
 * Clase que valida el token recibido haciendo una peticón a MSGrph
 * enviando el token en el property Authorization
 * 
 * @param String accessToken - token recido en el payload
 * @retun UserGraph user - datos correspondiente al usuario logueado.
 */


@Component
public class MSGraph {
	
	private static final Logger LOG = LoggerFactory.getLogger(MSGraph.class);
	
	public UserGraph getUserDataFromGraph(String accessToken) throws IOException, Unauthorized{
		
		UserGraph user = new UserGraph();
		
        URL url = new URL("https://graph.microsoft.com/v1.0/me");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept","application/json");

        int httpResponseCode = conn.getResponseCode();
        if(httpResponseCode == HTTPResponse.SC_OK) {

            StringBuilder response;
            try(BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))){

                String inputLine;
                response = new StringBuilder();
                while (( inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper. readValue(response.toString(), UserGraph. class);
            LOG.info(user.getDisplayName());
            return user;
        } else {
            throw new UnauthorizedException(accessToken);
        }
		
	}

}
