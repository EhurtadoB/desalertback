package com.example.desalert_back.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Infantes")
public class InfanteModel extends PersonaModel{

    @OneToMany(mappedBy = "infante", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<ImcModel> Imcs;

    public void agregarIMC(ImcModel imcModel){
        if(Imcs==null) Imcs = new ArrayList<>();
        Imcs.add(imcModel);
        imcModel.setInfante(this);

    }


}
