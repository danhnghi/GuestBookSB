package com.example.GuestBook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "user", nullable = false)
	private String username;
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "userreceive", nullable = false)
	private String userreceive;
	
	public Message() {
		super();
	}
	
	public Message(String username, String mes, String userreceive) {
		super();
		this.username = username;
		this.mes = mes;
		this.userreceive = userreceive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getUserreceive() {
		return userreceive;
	}

	public void setUserreceive(String userreceive) {
		this.userreceive = userreceive;
	}
}
