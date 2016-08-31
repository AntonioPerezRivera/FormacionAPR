package com.at.library.dto;

import java.io.Serializable;
import java.util.Date;

import com.at.library.enums.RentStatusEnum;

public class RentDTO implements Serializable {

	private static final long serialVersionUID = 7364756623634860483L;

	private String comments;

	private BookDTO book;
	
	private EmployeeDTO employee;
	
	private UserDTO user;

	private RentStatusEnum status;
	
	private Date initDate;
	
	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BookDTO getBook(){
		return book;
	}
	
	public void setBook(BookDTO book){
		this.book = book;
	}
	
	public EmployeeDTO getEmployee(){
		return employee;
	}
	
	public void setEmployee(EmployeeDTO employee){
		this.employee = employee;
	}
	
	public UserDTO getUser(){
		return user;
	}
	
	public void setUser(UserDTO user){
		this.user = user;
	}

	public RentStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RentStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RentDTO [comments=" + comments + ", book=" + book + ", employee=" + employee
				+ ", user=" + user + ", status=" + status + "]";
	}
}
