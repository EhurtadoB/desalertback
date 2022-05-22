package com.example.desalert_back.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
@PrimaryKeyJoinColumn(name="Id_persona")
public class MedicoModel extends  PersonaModel{
	@Column(name="especialidad")
    private String especialidad;
	
	@OneToMany(mappedBy = "medico", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	private List<InfanteModel> infantes;
	

	public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
}
