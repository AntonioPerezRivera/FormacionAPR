package com.at.library.dto;

public class ApiErrorDTO {

	Integer codigo;
	String mensaje;
	
	public ApiErrorDTO(){
		super();
	}
	
	public ApiErrorDTO(Integer codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
