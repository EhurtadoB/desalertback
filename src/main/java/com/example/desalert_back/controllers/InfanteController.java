package com.example.desalert_back.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.services.InfanteService;


@RestController
@RequestMapping("/infante")
public class InfanteController {
	@Autowired
    InfanteService infanteService;
    @GetMapping()
    public ArrayList<InfanteModel> obtenerInfantes(){
        return infanteService.obtenerInfantes();
    }

    @PostMapping()
    public InfanteModel guardarinfante(@RequestBody InfanteModel infante) {
        return this.infanteService.guardarInfantes(infante);
    }

    @GetMapping(path = "/{id}")
    public Optional<InfanteModel> obtenerinfantePorId(@PathVariable("id") Long id){
        return this.infanteService.obtenerPorId(id);
    }

}
