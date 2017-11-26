package org.surya.javabrains.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.surya.javabrains.messenger.model.Message;

public class RestApiClient {
	
	
	public static void main(String[] args) {
		Client client=ClientBuilder.newClient();
		 WebTarget target = client.target("http://localhost:8080/messenger/webapi/messages/1");
				Builder builder = target.request();
				Response response = builder.get();
				System.out.println(response.getHeaders());
		Message message=response.readEntity(Message.class);
		System.out.println(message.getMessage());
	}

}