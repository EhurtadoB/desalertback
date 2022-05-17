package com.example.desalert_back.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Acudientes")
public class AcudienteModel extends PersonaModel{
    private String parentesco;

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
