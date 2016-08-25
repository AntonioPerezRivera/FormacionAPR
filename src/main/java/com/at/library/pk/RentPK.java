package com.at.library.pk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.at.library.model.Book;

@Embeddable
public class RentPK implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1467004248823123060L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@OneToOne
	private Book book;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}