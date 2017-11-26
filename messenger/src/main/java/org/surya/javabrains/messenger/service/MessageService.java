package org.surya.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.surya.javabrains.messenger.database.DatabaseClass;
import org.surya.javabrains.messenger.model.Message;

public class MessageService {
	
	
	public MessageService() {
		messages.put(1l, new Message("Surya","Hello World!!!",1));
		messages.put(2l, new Message("Nandan","Hello Nandan",2));
	}
	
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	
	}
	
	public List<Message> getAllMessagesForYear(int year)
	{
		
		List<Message> messagesForYear= new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message: messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
			 messagesForYear.add(message);
			}
		}
		return messagesForYear;
	
	}

	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		
		ArrayList<Message> list=new ArrayList<>(messages.values());
		if(start+size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	
	}
	
public Message getMessage(Long id)
{
	return messages.get(id);	
}



public Message addMessage(Message message)
{
	message.setId(messages.size()+1);
	messages.put(message.getId(), message);
	return messages.get(message.getId());
	
}

public Message updateMessage(Message message)
{
	
	if(message.getId()<=0)
	{
		return null;
	}
	else
	{
		messages.put(message.getId(), message);
	}
		
	return message;
	
}


public Message removeMessage(Long id)
{
	return messages.remove(id);

}





}
