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
import javax.persistence.Transient;

import com.at.library.enums.RentPunishEnum;
import com.at.library.enums.RentStatusEnum;
import com.at.library.pk.RentPK;

@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = -4158742374158942716L;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@EmbeddedId
	private RentPK rentPK = new RentPK();

	@Enumerated(EnumType.STRING)
	private RentStatusEnum status;
	
	@Enumerated(EnumType.STRING)
	private RentPunishEnum statusPunish; 
	
	// Almacena la fecha en la que el usuario lo devuelve
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;

	public RentPK getPk() {
		return rentPK;
	}

	public void setPk(RentPK rentPK) {
		this.rentPK = rentPK;
	}

	public RentPunishEnum getStatusPunish() {
		return statusPunish;
	}

	public void setStatusPunish(RentPunishEnum statusPunish) {
		this.statusPunish = statusPunish;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Transient
	public Book getBook(){
		return rentPK.getBook();
	}
	
	@Transient
	public void setBook(Book book){
		rentPK.setBook(book);
	}
	
	@Transient
	public Date getInitDate(){
		return rentPK.getInitDate();
	}
	
	@Transient
	public void setInitDate(Date initDate){
		rentPK.setInitDate(initDate);
	}

	public RentStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RentStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Rent [rentPK=" + rentPK + ", user=" + user + ", employee=" + employee + ", endDate=" + endDate + ", returnDate="
				+ returnDate + "]";
	}
}