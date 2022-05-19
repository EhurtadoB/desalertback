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

}
