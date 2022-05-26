package com.example.desalert_back.models;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PersonaModel {
	@Id
	@Column(unique = true, nullable = false)
	protected Long id;
	protected String nombre;

	protected String direccion;

	protected Date fechaNacimiento;

	protected String sexo;
	protected Long telefono;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	protected UsuarioModel usuario;

	public PersonaModel() {
		super();
	}

	public PersonaModel(Long id, String nombre, String direccion, Date fechaNacimiento, String sexo, Long telefono,
			UsuarioModel usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.telefono = telefono;
		this.usuario = usuario;
	}
	
	

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	 * public UsuarioModel getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(UsuarioModel usuario) { this.usuario = usuario; }
	 * 
	 */
}
