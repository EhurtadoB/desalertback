package com.example.desalert_back.models;

import javax.persistence.*;

@Entity
@Table(name="IMC")
public class ImcModel {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column(name="ID")
    private int id;
    private Float imc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_infante")
    private InfanteModel infante;
    
    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

	public InfanteModel getInfante() {
		return infante;
	}

	public void setInfante(InfanteModel infante) {
		this.infante = infante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
