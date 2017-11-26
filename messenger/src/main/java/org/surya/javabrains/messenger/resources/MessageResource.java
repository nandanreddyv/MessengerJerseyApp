package org.surya.javabrains.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.surya.javabrains.messenger.model.Message;
import org.surya.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService= new MessageService();
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size) {
		
		if(year>0)
		{
			return messageService.getAllMessagesForYear(year);
		}
		
		if(start>=0&&size>0)
		{
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
		
	}
	
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") Long messageID)
	{
		
		return messageService.getMessage(messageID);
		
		
	}
	
	
	
//	@POST
//	public Message postMessages(Message message)
//	{
//		
//
//		
//		return messageService.addMessage(message);
//		
//	}
	
	@POST
	public Response postMessages(Message message, @Context UriInfo uriInfo)
	{
		
		
		Message Newmessage= messageService.addMessage(message);
		String newID= String.valueOf(Newmessage.getId());
		URI uriInfo1=uriInfo.getAbsolutePathBuilder().path(newID).build();
		return Response.created(uriInfo1).entity(Newmessage).build();

		
		
		
	}
	
	
	@PUT
	@Path("/{messageID}")
	public Message putMessages(Message message)
	{
		return messageService.updateMessage(message);
		
	}
	
	
	@DELETE
	@Path("/{messageID}")
	public Message deleteMessages(@PathParam("messageID") Long messageID)
	{
		return messageService.removeMessage(messageID);
		
	}
}
