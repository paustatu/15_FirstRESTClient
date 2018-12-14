package atj.ws;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class Main {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		//URI uri = UriBuilder.fromUri("http://localhost:8080/atj").queryParam("idx", "12345").build();
		URI uri = URI.create("http://localhost:8080/FirstREST");
		WebTarget webTarget = client.target(uri);
		webTarget = webTarget.path("hello");

		// wywo³anie ¿¹dania i odebranie odpowiedzi
		String response = webTarget.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();

		String plainAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = webTarget.request().accept(MediaType.TEXT_HTML).get(String.class);
		
		// sprawdzenie w konsoli co siê zadzia³o
		System.out.println(xmlAnswer);
		System.out.println(plainAnswer);
		System.out.println(htmlAnswer);
	}

}
