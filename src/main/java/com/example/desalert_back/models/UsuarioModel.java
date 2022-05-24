package com.example.desalert_back.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String email;
	protected String contrasena;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", unique = true, nullable = true)
	protected PersonaModel persona;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name= "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name= "rol_id", referencedColumnName = "id"))
	protected Set<RolesModel> roles = new HashSet<>();
	
	public UsuarioModel() {
		super();
	}

	public UsuarioModel(Long id, String email, String contrasena, PersonaModel persona) {
		super();
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
		this.persona = persona;
	}

	public Set<RolesModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesModel> roles) {
		this.roles = roles;
	}

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

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

}
