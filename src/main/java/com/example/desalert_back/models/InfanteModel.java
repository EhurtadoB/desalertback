package com.example.desalert_back.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Infantes")
@PrimaryKeyJoinColumn(name = "Id_persona")
public class InfanteModel extends PersonaModel {

	@Column(name = "images", nullable = true)
	private String urlImg;
	/*
	 * @OneToMany(mappedBy = "infante", cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH }) private List<ImcModel> Imcs;
	 */
	@OneToMany(mappedBy = "infante", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<HistoriaClinicaModel> historias = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico", nullable = false)
	private MedicoModel medico;;
	/*
	 * @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
	 * CascadeType.DETACH })
	 * 
	 * @JoinColumn(name = "Id_acudiente") private AcudienteModel acudiente;
	 */

	public Set<HistoriaClinicaModel> getHistorias() {
		return historias;
	}

	public InfanteModel(String urlImg, Set<HistoriaClinicaModel> historias, MedicoModel medico) {
		super();
		this.urlImg = urlImg;
		this.historias = historias;
		this.medico = medico;
	}

	public MedicoModel getMedico() {
		return medico;
	}

	public void setMedico(MedicoModel medico) {
		this.medico = medico;
	}

	public void setHistorias(Set<HistoriaClinicaModel> historias) {
		this.historias = historias;
	}

	public InfanteModel(String urlImg) {
		super();
		this.urlImg = urlImg;
	}

	public InfanteModel(String urlImg, Set<HistoriaClinicaModel> historias) {
		super();
		this.urlImg = urlImg;
		this.historias = historias;
	}

	public InfanteModel() {
		super();
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	/*
	 * public List<ImcModel> getImcs() { return Imcs; }
	 * 
	 * public void setImcs(List<ImcModel> imcs) { Imcs = imcs; }
	 * 
	 * public MedicoModel getMedico() { return medico; }
	 * 
	 * public void setMedico(MedicoModel medico) { this.medico = medico; }
	 * 
	 * public AcudienteModel getAcudiente() { return acudiente; }
	 * 
	 * public void setAcudiente(AcudienteModel acudiente) { this.acudiente =
	 * acudiente; }
	 */
}
