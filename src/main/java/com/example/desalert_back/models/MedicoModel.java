package com.example.desalert_back.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
public class MedicoModel extends  PersonaModel{
	@Column(name="especialidad")
    private String especialidad;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    private UsuarioModel usuario;
	
	@OneToMany(mappedBy = "medico", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	private List<InfanteModel> infantes;
	

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
    
    
}
