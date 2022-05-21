package com.example.desalert_back.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Auxiliares")
public class AuxiliarModel extends PersonaModel{
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    private UsuarioModel usuario;

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
}
