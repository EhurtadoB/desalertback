package com.example.desalert_back.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
public class MedicoModel extends  PersonaModel{
    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
