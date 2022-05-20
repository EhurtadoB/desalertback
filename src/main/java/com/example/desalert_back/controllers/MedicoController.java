package com.example.desalert_back.controllers;

import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;
    @GetMapping()
    public ArrayList<MedicoModel> obtenerMedicos(){
        return medicoService.obtenerMedicos();
    }

    @PostMapping()
    public MedicoModel guardarMedico(@RequestBody MedicoModel medico) {
        return this.medicoService.guardarMedicos(medico);
    }

    @GetMapping(path = "/{id}")
    public Optional<MedicoModel> obtenermedicoPorId(@PathVariable("id") Long id){
        return this.medicoService.obtenerPorId(id);
    }
}
