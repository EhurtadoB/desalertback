package com.example.desalert_back.services;

import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;
    public ArrayList<MedicoModel> obtenerMedicos(){
        //findAll() obtiene todos los usuarios, existen otras funciones
        return (ArrayList<MedicoModel>) medicoRepository.findAll();
    }
    public MedicoModel guardarMedicos(MedicoModel medico){

        return medicoRepository.save(medico);
    }
    public Optional<MedicoModel> obtenerPorId(Long id){

        return medicoRepository.findById(id);
    }

}
