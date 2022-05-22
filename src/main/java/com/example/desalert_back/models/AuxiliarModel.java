package com.example.desalert_back.models;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Auxiliares")
@PrimaryKeyJoinColumn(name="Id_persona")
public class AuxiliarModel extends PersonaModel{


	
}
