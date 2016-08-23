package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class RoomDTO implements Serializable {
	
	private static final long serialVersionUID = -8678839705725183562L;

	private Integer id;

	private String name;

	private String address;
	
	List<ZoneDTO> zones;
	
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
	
	public List<ZoneDTO> getZones(){
		return zones;
	}
	
	public void setZones(List<ZoneDTO> zones){
		this.zones = zones;
	}

}
