package com.example.desalert_back.models;

import java.util.HashSet;
import java.util.Set;

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
	
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<InfanteModel> infantes = new HashSet<>();
	
	
	
	public MedicoModel() {
		super();
	}

	public String getEspecialidad() {
        return especialidad;
    }

    public MedicoModel(String especialidad, Set<InfanteModel> infantes) {
		super();
		this.especialidad = especialidad;
		this.infantes = infantes;
	}

	public Set<InfanteModel> getInfantes() {
		return infantes;
	}

	public void setInfantes(Set<InfanteModel> infantes) {
		this.infantes = infantes;
	}

	public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
  
    /*
	public void agregarInfante(InfanteModel infante){
        if(infantes==null) infantes = new ArrayList<>();
        infantes.add(infante);
        infante.setMedico(this);

    }

	public List<InfanteModel> getInfantes() {
		return infantes;
	}*/

    
}
