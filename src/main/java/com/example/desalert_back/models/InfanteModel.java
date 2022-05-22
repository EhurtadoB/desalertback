package com.example.desalert_back.models;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Infantes")
@PrimaryKeyJoinColumn(name="Id_persona")
public class InfanteModel extends PersonaModel{
	
	private String urlImg;

    @OneToMany(mappedBy = "infante", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<ImcModel> Imcs;
    
    @OneToMany(mappedBy = "infante", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<HistoriaClinicaModel> historias;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "Id_Medico")
    private MedicoModel medico;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "Id_acudiente")
    private AcudienteModel acudiente;
    


	public void agregarIMC(ImcModel imcModel){
        if(Imcs==null) Imcs = new ArrayList<>();
        Imcs.add(imcModel);
        imcModel.setInfante(this);
    }
    
    
    public void agregarHistorias(HistoriaClinicaModel historiaClinica) {
    	if(historias==null) historias=new ArrayList<>();
    	historias.add(historiaClinica);
    	historiaClinica.setInfante(this);
    }

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}


	public List<ImcModel> getImcs() {
		return Imcs;
	}


	public void setImcs(List<ImcModel> imcs) {
		Imcs = imcs;
	}


	public List<HistoriaClinicaModel> getHistorias() {
		return historias;
	}



	public MedicoModel getMedico() {
		return medico;
	}


	public void setMedico(MedicoModel medico) {
		this.medico = medico;
	}


	public AcudienteModel getAcudiente() {
		return acudiente;
	}


	public void setAcudiente(AcudienteModel acudiente) {
		this.acudiente = acudiente;
	} 


}
