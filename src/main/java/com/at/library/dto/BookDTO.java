package com.at.library.dto;

import java.io.Serializable;

import com.at.library.enums.StatusEnum;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1583585532736761521L;

	// Va a buscar por titulo y por isbn
	
	private Integer id;

	private String isbn;

	private String title;

	private String author;
	
	private StatusEnum status;
	
	private Integer year;
	
	private String image;
	
	private String description;
	
	
	public BookDTO(){
		super();
	}
	
	public BookDTO(Integer id, String isbn, String title, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", title=" + title + ", author=" + author +"]";
	}
	
}
