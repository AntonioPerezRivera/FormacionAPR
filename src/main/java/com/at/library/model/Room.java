package com.at.library.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Room implements Serializable {

	private static final long serialVersionUID = 7440516369653834720L;
	
	@Id
	private String name;

	private String address;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="room_name")
	private List<Zone> zones;
	
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
