package com.at.library.dto;

import java.io.Serializable;
import java.util.List;

public class ZonePostDTO implements Serializable {

	private static final long serialVersionUID = 7107100081685015200L;
	private List<Integer> idLibros;
	private String nameRoom;
	private String nameZone;
	
	public String getNameZone() {
		return nameZone;
	}
	public void setNameZone(String nameZone) {
		this.nameZone = nameZone;
	}
	public List<Integer> getIdLibros() {
		return idLibros;
	}
	public void setIdLibros(List<Integer> idLibros) {
		this.idLibros = idLibros;
	}
	public String getNameRoom() {
		return nameRoom;
	}
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	@Override
	public String toString() {
		return "ZonePostDTO [idLibros=" + idLibros + ", nameRoom=" + nameRoom + "]";
	}
}
