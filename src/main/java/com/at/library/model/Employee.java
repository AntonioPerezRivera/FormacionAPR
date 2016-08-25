package com.at.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = -12273121504878080L;

	@Id
	@GeneratedValue
	private Integer id;

	private String dni;

	private String name;

	private String surname1;
	
	private String surname2;
	
	private String address;

	@Temporal(TemporalType.DATE)
	private Date startWorking;
	
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.MERGE},fetch=FetchType.LAZY)
	private List<Rent> managedRents;
	
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
	
	public Date getStartWorking(){
		return startWorking;
	}
	
	public void setStartWorking(Date startWorking){
		this.startWorking = startWorking;
	}
	
	public List<Rent> getManagedRents(){
		return managedRents;
	}
	
	public void setManagedRents(List<Rent> managedRents){
		this.managedRents = managedRents;
	}
	
	public String toString(){
		String output = this.getDni() + " " + this.getName() + " "
					    + this.getSurname1() +" " + this.getSurname2() + " "
					    + this.getAddress() + " " + this.getStartWorking() + " ";
		
		return output;
	}
	
}
