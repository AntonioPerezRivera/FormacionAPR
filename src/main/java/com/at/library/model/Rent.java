package com.at.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.at.library.enums.RentStatusEnum;
import com.at.library.pk.RentPK;

@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = -3355087313344614141L;

	private String comments;

	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@Enumerated(EnumType.STRING)
	private RentStatusEnum status;

	@EmbeddedId
	private RentPK rentPK;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Employee getEmployee(){
		return employee;
	}
	
	public void setEmployee(Employee employee){
		this.employee = employee;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}

	public RentStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RentStatusEnum status) {
		this.status = status;
	}

	public Book getBook() {
		return rentPK.getBook();
	}

	public void setBook(Book book) {
		rentPK.setBook(book);
	}
	
	public Date getStartDate() {
		return rentPK.getStartDate();
	}

	public void setStartDate(Date startDate) {
		rentPK.setStartDate(startDate);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
