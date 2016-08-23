package com.at.library.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Zone implements Serializable {

	private static final long serialVersionUID = -2464825640102494019L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@ManyToOne(fetch=FetchType.LAZY)
	Room room;
	
	@OneToMany(fetch=FetchType.LAZY)
	List<Book> books;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Room getRoom(){
		return room;
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public void setBooks(List<Book> books){
		this.books = books;
	}
	
}
