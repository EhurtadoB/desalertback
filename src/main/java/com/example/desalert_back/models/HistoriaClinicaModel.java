package com.example.desalert_back.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Historias_clinicas")
public class HistoriaClinicaModel {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private int id;
    private Float altura;
    private Float peso;
    private int edad;

    //padecimiento actual
    private String padecimientos;
    private String diagnosticoPrevio;
    private String estudioPrevio;
    private String terapeutaPrevia;

    //aqui el acudiente
    private String nombreAcudiente;
    private String ocupacionAcudiente;
    private int edadAcudiente;
    private String gestaAcudiente;
    private String abortos;
    private String cesarias;
    private String tranfusiones;
    private String estadoSaludAcudiente;

//antecedentes personales no patologicos prenatales
    private int embarazo_num;
    private String emNormal;
    private String emCausa;
    private int gestacion; //semanas
    private Float ponderalKg;
    private String partoEutocico;
    private String eutoCausa;
    private String anestesia;
    private String anesteciaCual;
    private String Ruptura;
    private String hora;
    private Float pesoNam;
    private Float talla;
    private Float PC;
    private Boolean apneaNeonatal;
    private Boolean ictericia;
    private Boolean hemorragia;
    private String convulsiones;
    private String otros;
    private String InformacionAd;


// antecedentes ginecopstètricos
    private String menarca;
    private String fum;
    private String ciclo;
    private String ritmo;
    private Boolean dismenorrea;
    private int gestaciones;
    private int partos;
    private int aborto;
    private int cesareas;
    private String metodoControl;


    //alimentación
    private Boolean pecho_materno;
    private Long duracion; //meses
    private Long ablactacion; //meses
    private Long destete; //meses
    //alimentacion real
    private Boolean carne;
    private Boolean leche;
    private Boolean frutas;
    private Boolean cereales;
    private Boolean legumbres;

    //inmunizaciones
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


    //desarrollo psicomotor
    private String datosAnormales;
    private String alteracionesLenguaje;

    //Higiene y habiotacion
    private String eliminacionExcretas;
    private String aguaIntradomiciliaria;
    private String covivenciaAnimales;
    private int numeroCuartos;
    private int personasDuermen;
    private String tipoPiso;
    private String ExposicionToxicas;

    //patologicos
    private Boolean infecciones;
    private Boolean alergicos;
    private Boolean traumatismoicos;
    private Boolean transfuciones;
    private Boolean quirurgicos;
    private Boolean hospitalizacion;




    //exploracion fisica
    private Float perimetroCefalico;
    private Float perimetroEmbarazo;
    private Float perimetroPierna;
    private Float segmentoSuperior;
    private Float segmentoInterior;
    private Float tensionArterial;
    private Float frecuenciaCardiaca;
    private Float frecuenciaRespiratoria;
    private Float temperatura;


    //anormalidades
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

    private String firma;

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public String getNombreAcudiente() {
		return nombreAcudiente;
	}

	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}

	public String getOcupacionAcudiente() {
		return ocupacionAcudiente;
	}

	public void setOcupacionAcudiente(String ocupacionAcudiente) {
		this.ocupacionAcudiente = ocupacionAcudiente;
	}

	public int getEdadAcudiente() {
		return edadAcudiente;
	}

	public void setEdadAcudiente(int edadAcudiente) {
		this.edadAcudiente = edadAcudiente;
	}

	public String getGestaAcudiente() {
		return gestaAcudiente;
	}

	public void setGestaAcudiente(String gestaAcudiente) {
		this.gestaAcudiente = gestaAcudiente;
	}

	public String getAbortos() {
		return abortos;
	}

	public void setAbortos(String abortos) {
		this.abortos = abortos;
	}

	public String getCesarias() {
		return cesarias;
	}

	public void setCesarias(String cesarias) {
		this.cesarias = cesarias;
	}

	public String getTranfusiones() {
		return tranfusiones;
	}

	public void setTranfusiones(String tranfusiones) {
		this.tranfusiones = tranfusiones;
	}

	public String getEstadoSaludAcudiente() {
		return estadoSaludAcudiente;
	}

	public void setEstadoSaludAcudiente(String estadoSaludAcudiente) {
		this.estadoSaludAcudiente = estadoSaludAcudiente;
	}

	public int getEmbarazo_num() {
		return embarazo_num;
	}

	public void setEmbarazo_num(int embarazo_num) {
		this.embarazo_num = embarazo_num;
	}

	public String getEmNormal() {
		return emNormal;
	}

	public void setEmNormal(String emNormal) {
		this.emNormal = emNormal;
	}

	public String getEmCausa() {
		return emCausa;
	}

	public void setEmCausa(String emCausa) {
		this.emCausa = emCausa;
	}

	public int getGestacion() {
		return gestacion;
	}

	public void setGestacion(int gestacion) {
		this.gestacion = gestacion;
	}

	public Float getPonderalKg() {
		return ponderalKg;
	}

	public void setPonderalKg(Float ponderalKg) {
		this.ponderalKg = ponderalKg;
	}

	public String getPartoEutocico() {
		return partoEutocico;
	}

	public void setPartoEutocico(String partoEutocico) {
		this.partoEutocico = partoEutocico;
	}

	public String getEutoCausa() {
		return eutoCausa;
	}

	public void setEutoCausa(String eutoCausa) {
		this.eutoCausa = eutoCausa;
	}

	public String getAnestesia() {
		return anestesia;
	}

	public void setAnestesia(String anestesia) {
		this.anestesia = anestesia;
	}

	public String getAnesteciaCual() {
		return anesteciaCual;
	}

	public void setAnesteciaCual(String anesteciaCual) {
		this.anesteciaCual = anesteciaCual;
	}

	public String getRuptura() {
		return Ruptura;
	}

	public void setRuptura(String ruptura) {
		Ruptura = ruptura;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Float getPesoNam() {
		return pesoNam;
	}

	public void setPesoNam(Float pesoNam) {
		this.pesoNam = pesoNam;
	}

	public Float getTalla() {
		return talla;
	}

	public void setTalla(Float talla) {
		this.talla = talla;
	}

	public Float getPC() {
		return PC;
	}

	public void setPC(Float pC) {
		PC = pC;
	}

	public Boolean getApneaNeonatal() {
		return apneaNeonatal;
	}

	public void setApneaNeonatal(Boolean apneaNeonatal) {
		this.apneaNeonatal = apneaNeonatal;
	}

	public Boolean getIctericia() {
		return ictericia;
	}

	public void setIctericia(Boolean ictericia) {
		this.ictericia = ictericia;
	}

	public Boolean getHemorragia() {
		return hemorragia;
	}

	public void setHemorragia(Boolean hemorragia) {
		this.hemorragia = hemorragia;
	}

	public String getConvulsiones() {
		return convulsiones;
	}

	public void setConvulsiones(String convulsiones) {
		this.convulsiones = convulsiones;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getInformacionAd() {
		return InformacionAd;
	}

	public void setInformacionAd(String informacionAd) {
		InformacionAd = informacionAd;
	}

	public String getMenarca() {
		return menarca;
	}

	public void setMenarca(String menarca) {
		this.menarca = menarca;
	}

	public String getFum() {
		return fum;
	}

	public void setFum(String fum) {
		this.fum = fum;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getRitmo() {
		return ritmo;
	}

	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}

	public Boolean getDismenorrea() {
		return dismenorrea;
	}

	public void setDismenorrea(Boolean dismenorrea) {
		this.dismenorrea = dismenorrea;
	}

	public int getGestaciones() {
		return gestaciones;
	}

	public void setGestaciones(int gestaciones) {
		this.gestaciones = gestaciones;
	}

	public int getPartos() {
		return partos;
	}

	public void setPartos(int partos) {
		this.partos = partos;
	}

	public int getAborto() {
		return aborto;
	}

	public void setAborto(int aborto) {
		this.aborto = aborto;
	}

	public int getCesareas() {
		return cesareas;
	}

	public void setCesareas(int cesareas) {
		this.cesareas = cesareas;
	}

	public String getMetodoControl() {
		return metodoControl;
	}

	public void setMetodoControl(String metodoControl) {
		this.metodoControl = metodoControl;
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

	public String getEliminacionExcretas() {
		return eliminacionExcretas;
	}

	public void setEliminacionExcretas(String eliminacionExcretas) {
		this.eliminacionExcretas = eliminacionExcretas;
	}

	public String getAguaIntradomiciliaria() {
		return aguaIntradomiciliaria;
	}

	public void setAguaIntradomiciliaria(String aguaIntradomiciliaria) {
		this.aguaIntradomiciliaria = aguaIntradomiciliaria;
	}

	public String getCovivenciaAnimales() {
		return covivenciaAnimales;
	}

	public void setCovivenciaAnimales(String covivenciaAnimales) {
		this.covivenciaAnimales = covivenciaAnimales;
	}

	public int getNumeroCuartos() {
		return numeroCuartos;
	}

	public void setNumeroCuartos(int numeroCuartos) {
		this.numeroCuartos = numeroCuartos;
	}

	public int getPersonasDuermen() {
		return personasDuermen;
	}

	public void setPersonasDuermen(int personasDuermen) {
		this.personasDuermen = personasDuermen;
	}

	public String getTipoPiso() {
		return tipoPiso;
	}

	public void setTipoPiso(String tipoPiso) {
		this.tipoPiso = tipoPiso;
	}

	public String getExposicionToxicas() {
		return ExposicionToxicas;
	}

	public void setExposicionToxicas(String exposicionToxicas) {
		ExposicionToxicas = exposicionToxicas;
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

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}
    
    

}
