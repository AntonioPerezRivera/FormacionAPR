package com.at.library.dto;

import java.io.Serializable;

public class RentPostDTO implements Serializable {

	private static final long serialVersionUID = 7376238822804911669L;
	private Integer book;
	private Integer user;
	private Integer employee;
	
	public Integer getIdLibro() {
		return book;
	}
	public void setIdLibro(Integer idLibro) {
		this.book = idLibro;
	}
	public Integer getIdUser() {
		return user;
	}
	public void setIdUser(Integer idUser) {
		this.user = idUser;
	}
	public Integer getIdEmployee() {
		return employee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.employee = idEmployee;
	}
	@Override
	public String toString() {
		return "RentPostDTO [book=" + book + ", user=" + user + ", employee=" + employee + "]";
	}
	
	
}
