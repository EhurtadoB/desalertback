package com.example.desalert_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.dto.LoginDTO;
import com.example.desalert_back.seguridad.JWTAuthResonseDTO;
import com.example.desalert_back.seguridad.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/iniciarSesion")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);	
		
		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);
		
		
		return ResponseEntity.ok(new JWTAuthResonseDTO(token));
		//return new ResponseEntity<>("Ha iniciado sesion con exito  !", HttpStatus.OK);
	}
}