package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class RoomDTO implements Serializable {
	
	private static final long serialVersionUID = -8678839705725183562L;

	private String name;

	private String address;
	
	List<ZoneDTO> zones;

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

	@Override
	public String toString() {
		return "RoomDTO [name=" + name + ", address=" + address + ", zones=" + zones + "]";
	}

}
