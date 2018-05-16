package com.example.GuestBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GuestBook.model.Message;
import com.example.GuestBook.reponsitory.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
    private MessageRepository messageRepository;
	
	@Override
	public Iterable<Message> findByUsernameAndUserreceive(String username, String userreceive) {
		return messageRepository.findByUsernameAndUserreceive(username, userreceive);
	}
	
	@Override
	public void save(Message mess) {
		messageRepository.save(mess);
	}

	@Override
	public void delete(int id) {
		messageRepository.deleteById(id);
	}

	@Override
	public Message findOne(int id) {
		return messageRepository.findById(id).get();
	}

}
