package com.example.desalert_back.models;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class UsuarioModel {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String cargo;
    
    @OneToOne(mappedBy="usuario")
    private AcudienteModel acudiente;
    
    @OneToOne(mappedBy="usuario")
    private MedicoModel medico;
    
    @OneToOne(mappedBy="usuario")
    private AuxiliarModel auxiliar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

	public PersonaModel getAcudiente() {
		return acudiente;
	}

	public void setAcudiente(AcudienteModel acudiente) {
		this.acudiente = acudiente;
	}

	public MedicoModel getMedico() {
		return medico;
	}

	public void setMedico(MedicoModel medico) {
		this.medico = medico;
	}

	public AuxiliarModel getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(AuxiliarModel auxiliar) {
		this.auxiliar = auxiliar;
	}
    
    
}
