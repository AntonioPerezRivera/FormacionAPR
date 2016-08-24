package com.at.library.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room implements Serializable {

	private static final long serialVersionUID = 7440516369653834720L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String address;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	List<Zone> zones;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public List<Zone> getZones(){
		return zones;
	}
	
	public void setZones(List<Zone> zones){
		this.zones = zones;
	}
	
}
