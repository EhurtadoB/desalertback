package com.example.desalert_back.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Infantes")
public class InfanteModel extends PersonaModel{
	
	private String urlImg;

    @OneToMany(mappedBy = "infante", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<ImcModel> Imcs;
    
    @OneToMany(mappedBy = "infante", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<HistoriaClinicaModel> historias;

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
    


}
