package com.example.desalert_back.models;

import java.util.ArrayList;
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
	
	/*@OneToMany(mappedBy = "medico", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	private List<InfanteModel> infantes;*/
	

	public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
	/*public void agregarInfante(InfanteModel infante){
        if(infantes==null) infantes = new ArrayList<>();
        infantes.add(infante);
        infante.setMedico(this);

    }

	public List<InfanteModel> getInfantes() {
		return infantes;
	}*/

    
}
