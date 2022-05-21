package com.example.desalert_back.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Acudientes")
public class AcudienteModel extends PersonaModel{
    private String parentesco;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    private UsuarioModel usuario;

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
    
    
}
