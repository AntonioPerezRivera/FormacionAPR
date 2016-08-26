package com.at.library.dto;

import java.io.Serializable;

public class RentPostDTO implements Serializable {

	private static final long serialVersionUID = 7376238822804911669L;
	private Integer idLibro;
	private Integer idUser;
	private Integer idEmployee;
	
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	@Override
	public String toString() {
		return "RentPostDTO [idLibro=" + idLibro + ", idUser=" + idUser + ", idEmployee=" + idEmployee + "]";
	}
	
	
}
