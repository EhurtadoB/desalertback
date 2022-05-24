package com.example.desalert_back.dto;

public class UsuarioDTO {
	protected Long id;
	protected String email;
	protected String contrasena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioDTO() {
		super();
	}

}
