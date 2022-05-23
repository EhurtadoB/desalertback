package com.example.desalert_back.models;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Acudientes")
@PrimaryKeyJoinColumn(name="Id_persona")
public class AcudienteModel extends PersonaModel{
    private String parentesco;
    
    @OneToMany(mappedBy = "acudiente", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private Set<InfanteModel> infantes= new HashSet<>();

	public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

	public AcudienteModel() {
		super();
	}

	public Set<InfanteModel> getInfantes() {
		return infantes;
	}

	public void setInfantes(Set<InfanteModel> infantes) {
		this.infantes = infantes;
	}
	
	
    
    


 
    
}
