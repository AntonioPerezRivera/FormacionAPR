package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1583585532736761521L;

	private String isbn;

	private String title;

	private String author;
	
	private List<RentDTO> rents;

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

	public List<RentDTO> getRents(){
		return rents;
	}
	
	public void setRents(List<RentDTO> rents){
		this.rents = rents;
	}

	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", title=" + title + ", author=" + author + ", rents=" + rents
				+ "]";
	}
	
}
