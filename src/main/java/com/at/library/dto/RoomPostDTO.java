package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class RoomPostDTO implements Serializable {

	private static final long serialVersionUID = 7875688704695128845L;
	private List<String> nameZonas;
	private String nameRoom;
	
	public List<String> getNameZonas() {
		return nameZonas;
	}
	public void setNameZonas(List<String> nameZonas) {
		this.nameZonas = nameZonas;
	}
	public String getNameRoom() {
		return nameRoom;
	}
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	@Override
	public String toString() {
		return "RoomPostDTO [nameZonas=" + nameZonas + ", nameRoom=" + nameRoom + "]";
	}
}
