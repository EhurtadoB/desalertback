package com.example.desalert_back.services;

import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public ArrayList<UsuarioModel> obtenerUsuarios(){
    	//findAll() obtiene todos los usuarios, existen otras funciones
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel guardarUsuarios(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
    public Optional<UsuarioModel> obtenerPorId(Long id){
    	return usuarioRepository.findById(id);
    }
    public ArrayList<UsuarioModel> obtenerPorCargo(String cargo){
    	return usuarioRepository.findByCargo(cargo);
    }
    public boolean eliminarUsuario(Long id) {
    	try {
    		usuarioRepository.deleteById(id);
    		return true;
    	}catch(Exception err) {
    		return false;
    	}
    	
    }
    

}
