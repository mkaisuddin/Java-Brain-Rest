package org.kaushik.javabrains.messanger.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		/*Message m1 = new Message(1, "Message11", "author11");
		Message m2 = new Message(2, "Message22", "author22");
		Message m3 = new Message(3, "Message33", "author33");
		Message m4 = new Message(4, "Message44", "author44");
		
		messages.put(1L, m1);
		messages.put(2L, m2);
		messages.put(3L, m3);
		messages.put(4L, m4);*/
		
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	/*private static List<Message> messages = new ArrayList<>();
	
	public static List<Message> getAllMessages(){
		Message m1 = new Message(1, "Message1", "author1");
		Message m2 = new Message(2, "Message2", "author2");
		Message m3 = new Message(3, "Message3", "author3");
		Message m4 = new Message(4, "Message4", "author4");
		
		//List<Message> list = new ArrayList<>();
		messages.add(m1);
		messages.add(m2);
		messages.add(m3);
		messages.add(m4);
		
		return messages;
		
	}*/
	
}