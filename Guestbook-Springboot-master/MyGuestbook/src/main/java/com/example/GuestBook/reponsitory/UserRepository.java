/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.GuestBook.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.GuestBook.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByIdContaining(int q);
	User findByEmail(String email);
	User findByuserName(String username);
}