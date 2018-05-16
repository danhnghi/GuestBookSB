package com.example.GuestBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GuestBook.model.User;
import com.example.GuestBook.reponsitory.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
	
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User contact) {
		userRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
