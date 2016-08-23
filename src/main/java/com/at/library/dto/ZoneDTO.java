package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class ZoneDTO implements Serializable {

	private static final long serialVersionUID = -2318152166576404732L;

	private Integer id;

	private String name;

	List<BookDTO> books;
	
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
	
	public List<BookDTO> getBooks(){
		return books;
	}
	
	public void setBooks(List<BookDTO> books){
		this.books = books;
	}

}