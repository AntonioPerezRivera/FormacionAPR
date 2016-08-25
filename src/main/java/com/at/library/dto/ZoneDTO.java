package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

import com.at.library.model.Room;

public class ZoneDTO implements Serializable {

	private static final long serialVersionUID = -2318152166576404732L;

	private String name;

	private List<BookDTO> books;
	
	private Room room;
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<BookDTO> getBooks(){
		return books;
	}
	
	public void setBooks(List<BookDTO> books){
		this.books = books;
	}

	@Override
	public String toString() {
		return "ZoneDTO [name=" + name + ", books=" + books + "]";
	}

}