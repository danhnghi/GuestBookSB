package com.example.GuestBook.service;

import com.example.GuestBook.model.User;

public interface UserService {
	Iterable<User> findAll();
    
    void save(User contact);

    User findOne(int id);
    
    void delete(int id);
    
    User findByEmail(String email);
}
