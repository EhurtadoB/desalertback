package com.example.desalert_back.models;



import java.util.ArrayList;
import java.util.List;

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
    
    /*@OneToMany(mappedBy = "acudiente", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<InfanteModel> infantes;
*/
	public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
/*    public void agregarInfante(InfanteModel infante){
        if(infantes==null) infantes = new ArrayList<>();
        infantes.add(infante);
        infante.setAcudiente(this);

    }

	public List<InfanteModel> getInfantes() {
		return infantes;
	}
 
  */  
}
