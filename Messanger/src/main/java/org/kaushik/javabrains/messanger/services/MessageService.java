package org.kaushik.javabrains.messanger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.kaushik.javabrains.messanger.database.DatabaseClass;
import org.kaushik.javabrains.messanger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public List<Message> getAllMessages(){
		//return DatabaseClass.getAllMessages();
		return new ArrayList<Message> (messages.values());
	}
	
	//Pagination and Filtering : filter by year
	public List<Message> getAllMessagesForYear(int year ){
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	//Pagination and Filtering : start is starting number and Size is the page size 
	//i.e. start = 10 and size = 20
	public List<Message> getAllMessagesPaginated(int start, int size ){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() == 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
}
