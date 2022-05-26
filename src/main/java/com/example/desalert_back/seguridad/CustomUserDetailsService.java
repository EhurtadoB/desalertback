package com.example.desalert_back.seguridad;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.RolesModel;
import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		UsuarioModel usuario = usuarioRepositorio.findByEmail(usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("Uusario no encontrado con ese email : "+ usernameOrEmail));
		return new User(usuario.getEmail(), usuario.getContrasena(), mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<RolesModel> roles){
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

}