package com.example.desalert_back.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.repositories.InfanteRepository;


@Service
public class InfanteService {
	@Autowired
    InfanteRepository infanteRepository;
    public ArrayList<InfanteModel> obtenerInfantes(){
        
        return (ArrayList<InfanteModel>) infanteRepository.findAll();
    }
    public InfanteModel guardarInfantes(InfanteModel infante){

        return infanteRepository.save(infante);
    }
    public Optional<InfanteModel> obtenerPorId(Long id){

        return infanteRepository.findById(id);
    }

}
