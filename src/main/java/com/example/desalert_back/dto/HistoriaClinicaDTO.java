package com.example.desalert_back.dto;

import java.util.Date;

public class HistoriaClinicaDTO {
	private long id;
	private Float altura;
	private Float peso;
	private String padecimientos;
	private String diagnosticoPrevio;
	private InfanteDTO infanteDTO;
	private MedicoDTO medicoDTO;
	private float imc;
	private String estudioPrevio;
	private String terapeutaPrevia;
	private Boolean pecho_materno;
	private Long duracion;
	private Long ablactacion;
	private Long destete;
	private Boolean carne;
	private Boolean leche;
	private Boolean frutas;
	private Boolean cereales;
	private Boolean legumbres;
	private Boolean poliomelitis;
	private Boolean rotavirus;
	private Boolean dpto;
	private Boolean influenza;
	private Boolean sarampion;
	private Boolean epatitisB;
	private Boolean rubeola;
	private Boolean neumococo;
	private Boolean parotiditis;
	private Boolean bcg;
	private Boolean varicela;
	private Boolean tixoide;
	private Boolean hepatitis;
	private Boolean a1;
	private Boolean papiloma;
	private String sueros;
	private String datosAnormales;
	private String alteracionesLenguaje;
	private Boolean infecciones;
	private Boolean alergicos;
	private Boolean traumatismoicos;
	private Boolean transfuciones;
	private Boolean quirurgicos;
	private Boolean hospitalizacion;
	private Float perimetroCefalico;
	private Float perimetroEmbarazo;
	private Float perimetroPierna;
	private Float segmentoSuperior;
	private Float segmentoInterior;
	private Float tensionArterial;
	private Float frecuenciaCardiaca;
	private Float frecuenciaRespiratoria;
	private Float temperatura;
	private Boolean piel;
	private Boolean cabeza;
	private Boolean ojos;
	private Boolean oidos;
	private Boolean nariz;
	private Boolean boca;
	private Boolean cuello;
	private Boolean torax;
	private Boolean areacardiaca;
	private Boolean pulmonar;
	private Date fechaCreacion;

	
	
	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public MedicoDTO getMedicoDTO() {
		return medicoDTO;
	}

	public void setMedicoDTO(MedicoDTO medicoDTO) {
		this.medicoDTO = medicoDTO;
	}

	public HistoriaClinicaDTO() {
		super();
	}

	public InfanteDTO getInfanteDTO() {
		return infanteDTO;
	}

	public void setInfanteDTO(InfanteDTO infanteDTO) {
		this.infanteDTO = infanteDTO;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getPadecimientos() {
		return padecimientos;
	}

	public void setPadecimientos(String padecimientos) {
		this.padecimientos = padecimientos;
	}

	public String getDiagnosticoPrevio() {
		return diagnosticoPrevio;
	}

	public void setDiagnosticoPrevio(String diagnosticoPrevio) {
		this.diagnosticoPrevio = diagnosticoPrevio;
	}

	public String getEstudioPrevio() {
		return estudioPrevio;
	}
	public void setEstudioPrevio(String estudioPrevio) {
		this.estudioPrevio = estudioPrevio;
	}
	public String getTerapeutaPrevia() {
		return terapeutaPrevia;
	}
	public void setTerapeutaPrevia(String terapeutaPrevia) {
		this.terapeutaPrevia = terapeutaPrevia;
	}
	public Boolean getPecho_materno() {
		return pecho_materno;
	}
	public void setPecho_materno(Boolean pecho_materno) {
		this.pecho_materno = pecho_materno;
	}
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
	public Long getAblactacion() {
		return ablactacion;
	}
	public void setAblactacion(Long ablactacion) {
		this.ablactacion = ablactacion;
	}
	public Long getDestete() {
		return destete;
	}
	public void setDestete(Long destete) {
		this.destete = destete;
	}
	public Boolean getCarne() {
		return carne;
	}
	public void setCarne(Boolean carne) {
		this.carne = carne;
	}
	public Boolean getLeche() {
		return leche;
	}
	public void setLeche(Boolean leche) {
		this.leche = leche;
	}
	public Boolean getFrutas() {
		return frutas;
	}
	public void setFrutas(Boolean frutas) {
		this.frutas = frutas;
	}
	public Boolean getCereales() {
		return cereales;
	}
	public void setCereales(Boolean cereales) {
		this.cereales = cereales;
	}
	public Boolean getLegumbres() {
		return legumbres;
	}
	public void setLegumbres(Boolean legumbres) {
		this.legumbres = legumbres;
	}
	public Boolean getPoliomelitis() {
		return poliomelitis;
	}
	public void setPoliomelitis(Boolean poliomelitis) {
		this.poliomelitis = poliomelitis;
	}
	public Boolean getRotavirus() {
		return rotavirus;
	}
	public void setRotavirus(Boolean rotavirus) {
		this.rotavirus = rotavirus;
	}
	public Boolean getDpto() {
		return dpto;
	}
	public void setDpto(Boolean dpto) {
		this.dpto = dpto;
	}
	public Boolean getInfluenza() {
		return influenza;
	}
	public void setInfluenza(Boolean influenza) {
		this.influenza = influenza;
	}
	public Boolean getSarampion() {
		return sarampion;
	}
	public void setSarampion(Boolean sarampion) {
		this.sarampion = sarampion;
	}
	public Boolean getEpatitisB() {
		return epatitisB;
	}
	public void setEpatitisB(Boolean epatitisB) {
		this.epatitisB = epatitisB;
	}
	public Boolean getRubeola() {
		return rubeola;
	}
	public void setRubeola(Boolean rubeola) {
		this.rubeola = rubeola;
	}
	public Boolean getNeumococo() {
		return neumococo;
	}
	public void setNeumococo(Boolean neumococo) {
		this.neumococo = neumococo;
	}
	public Boolean getParotiditis() {
		return parotiditis;
	}
	public void setParotiditis(Boolean parotiditis) {
		this.parotiditis = parotiditis;
	}
	public Boolean getBcg() {
		return bcg;
	}
	public void setBcg(Boolean bcg) {
		this.bcg = bcg;
	}
	public Boolean getVaricela() {
		return varicela;
	}
	public void setVaricela(Boolean varicela) {
		this.varicela = varicela;
	}
	public Boolean getTixoide() {
		return tixoide;
	}
	public void setTixoide(Boolean tixoide) {
		this.tixoide = tixoide;
	}
	public Boolean getHepatitis() {
		return hepatitis;
	}
	public void setHepatitis(Boolean hepatitis) {
		this.hepatitis = hepatitis;
	}
	public Boolean getA1() {
		return a1;
	}
	public void setA1(Boolean a1) {
		this.a1 = a1;
	}
	public Boolean getPapiloma() {
		return papiloma;
	}
	public void setPapiloma(Boolean papiloma) {
		this.papiloma = papiloma;
	}
	public String getSueros() {
		return sueros;
	}
	public void setSueros(String sueros) {
		this.sueros = sueros;
	}
	public String getDatosAnormales() {
		return datosAnormales;
	}
	public void setDatosAnormales(String datosAnormales) {
		this.datosAnormales = datosAnormales;
	}
	public String getAlteracionesLenguaje() {
		return alteracionesLenguaje;
	}
	public void setAlteracionesLenguaje(String alteracionesLenguaje) {
		this.alteracionesLenguaje = alteracionesLenguaje;
	}
	public Boolean getInfecciones() {
		return infecciones;
	}
	public void setInfecciones(Boolean infecciones) {
		this.infecciones = infecciones;
	}
	public Boolean getAlergicos() {
		return alergicos;
	}
	public void setAlergicos(Boolean alergicos) {
		this.alergicos = alergicos;
	}
	public Boolean getTraumatismoicos() {
		return traumatismoicos;
	}
	public void setTraumatismoicos(Boolean traumatismoicos) {
		this.traumatismoicos = traumatismoicos;
	}
	public Boolean getTransfuciones() {
		return transfuciones;
	}
	public void setTransfuciones(Boolean transfuciones) {
		this.transfuciones = transfuciones;
	}
	public Boolean getQuirurgicos() {
		return quirurgicos;
	}
	public void setQuirurgicos(Boolean quirurgicos) {
		this.quirurgicos = quirurgicos;
	}
	public Boolean getHospitalizacion() {
		return hospitalizacion;
	}
	public void setHospitalizacion(Boolean hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}
	public Float getPerimetroCefalico() {
		return perimetroCefalico;
	}
	public void setPerimetroCefalico(Float perimetroCefalico) {
		this.perimetroCefalico = perimetroCefalico;
	}
	public Float getPerimetroEmbarazo() {
		return perimetroEmbarazo;
	}
	public void setPerimetroEmbarazo(Float perimetroEmbarazo) {
		this.perimetroEmbarazo = perimetroEmbarazo;
	}
	public Float getPerimetroPierna() {
		return perimetroPierna;
	}
	public void setPerimetroPierna(Float perimetroPierna) {
		this.perimetroPierna = perimetroPierna;
	}
	public Float getSegmentoSuperior() {
		return segmentoSuperior;
	}
	public void setSegmentoSuperior(Float segmentoSuperior) {
		this.segmentoSuperior = segmentoSuperior;
	}
	public Float getSegmentoInterior() {
		return segmentoInterior;
	}
	public void setSegmentoInterior(Float segmentoInterior) {
		this.segmentoInterior = segmentoInterior;
	}
	public Float getTensionArterial() {
		return tensionArterial;
	}
	public void setTensionArterial(Float tensionArterial) {
		this.tensionArterial = tensionArterial;
	}
	public Float getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}
	public void setFrecuenciaCardiaca(Float frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	public Float getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}
	public void setFrecuenciaRespiratoria(Float frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}
	public Float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}
	public Boolean getPiel() {
		return piel;
	}
	public void setPiel(Boolean piel) {
		this.piel = piel;
	}
	public Boolean getCabeza() {
		return cabeza;
	}
	public void setCabeza(Boolean cabeza) {
		this.cabeza = cabeza;
	}
	public Boolean getOjos() {
		return ojos;
	}
	public void setOjos(Boolean ojos) {
		this.ojos = ojos;
	}
	public Boolean getOidos() {
		return oidos;
	}
	public void setOidos(Boolean oidos) {
		this.oidos = oidos;
	}
	public Boolean getNariz() {
		return nariz;
	}
	public void setNariz(Boolean nariz) {
		this.nariz = nariz;
	}
	public Boolean getBoca() {
		return boca;
	}
	public void setBoca(Boolean boca) {
		this.boca = boca;
	}
	public Boolean getCuello() {
		return cuello;
	}
	public void setCuello(Boolean cuello) {
		this.cuello = cuello;
	}
	public Boolean getTorax() {
		return torax;
	}
	public void setTorax(Boolean torax) {
		this.torax = torax;
	}
	public Boolean getAreacardiaca() {
		return areacardiaca;
	}
	public void setAreacardiaca(Boolean areacardiaca) {
		this.areacardiaca = areacardiaca;
	}
	public Boolean getPulmonar() {
		return pulmonar;
	}
	public void setPulmonar(Boolean pulmonar) {
		this.pulmonar = pulmonar;
	}
	
}