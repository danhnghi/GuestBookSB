package com.example.GuestBook.service;

import com.example.GuestBook.model.Message;

public interface MessageService {
	
	Iterable<Message> findByUsernameAndUserreceive(String username, String userreceive);
	
	void save(Message mess);
	
	void delete(int id);
	
	Message findOne(int id);
}
