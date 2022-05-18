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
    private String nombreAcudiente
    private String ocupacionAcudiente;
    private int edadAcudiente;
    private String gestaAcudiente;
    private String abortos;
    private String cesarias;
    private String tranfusiones;
    private String estadoSaludAcudiente;

//antecedentes personales no patologicos
    private int embarazo_num;
    private String emNormal;
    private String emCausa;
    private int gestacion; //semanas
    private Float ponderalKg;
    private String partoEutocico;
    private String eutoCausa;
    private String anestesia;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;
    private String antecedentes;





}
