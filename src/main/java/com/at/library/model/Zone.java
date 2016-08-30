package com.at.library.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Zone implements Serializable {

	private static final long serialVersionUID = -2464825640102494019L;

	@Id
	private String name;

	@OneToMany(fetch=FetchType.LAZY)
	private List<Book> books;
	
	@OneToOne
	private Room room;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public List<Book> getBooks(){
		return books;
	}
	
	public void setBooks(List<Book> books){
		this.books = books;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
