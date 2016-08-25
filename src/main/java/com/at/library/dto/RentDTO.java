package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

import com.at.library.enums.RentStatusEnum;

public class RentDTO implements Serializable {

	private static final long serialVersionUID = 7364756623634860483L;

	private String comments;

	private List<BookDTO> books;
	
	private EmployeeDTO employee;
	
	private UserDTO user;

	private RentStatusEnum status;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<BookDTO> getBooks(){
		return books;
	}
	
	public void setBooks(List<BookDTO> books){
		this.books = books;
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
		return "RentDTO [comments=" + comments + ", books=" + books + ", employee=" + employee
				+ ", user=" + user + ", status=" + status + "]";
	}

}
