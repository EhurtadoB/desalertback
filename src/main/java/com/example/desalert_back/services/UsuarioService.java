package com.example.desalert_back.services;

import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel guardarUsuarios(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

}
