package com.example.GuestBook.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.GuestBook.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{
	List<Message> findByIdContaining(int id);
	List<Message> findByUsernameAndUserreceive(String user, String userreceive);
}
