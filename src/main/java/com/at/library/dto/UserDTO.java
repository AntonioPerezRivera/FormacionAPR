package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

import com.at.library.enums.StatusEnum;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3827455324138571715L;

	private Integer id;

	private String dni;

	private String name;

	private String surname1;
	
	private String surname2;
	
	private String address;

	private StatusEnum userStatus;

	List<RentDTO> rents;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String Dni) {
		this.dni = Dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public StatusEnum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(StatusEnum userStatus) {
		this.userStatus = userStatus;
	}

	public List<RentDTO> getRents(){
		return rents;
	}
	
	public void setRents(List<RentDTO> rents){
		this.rents = rents;
	}
	
}