package com.at.library.dto;

import java.io.Serializable;

import com.at.library.enums.UserEnum;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3827455324138571715L;

	private String dni;

	private String name;

	private String surname1;
	
	private String surname2;
	
	private String address;

	private UserEnum userStatus;

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
	
	public UserEnum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserEnum userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "UserDTO [dni=" + dni + ", name=" + name + ", surname1=" + surname1 + ", surname2="
				+ surname2 + ", address=" + address + ", userStatus=" + userStatus + "]";
	}
	
}