package com.dev.crm.core.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.crm.core.model.entity.ModuloUsuario;
import com.dev.crm.core.model.entity.Usuario;
import com.dev.crm.core.repository.jpa.ModuloUsuarioJpaRepository;
import com.dev.crm.core.repository.jpa.UsuarioJpaRepository;
import com.dev.crm.core.util.GenericUtil;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioJpaRepository")
	private UsuarioJpaRepository usuarioJpaRepository;
	
	@Autowired
	@Qualifier("moduloUsuarioJpaRepository")
	private ModuloUsuarioJpaRepository moduloUsuarioJpaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioJpaRepository.findByNombreUsuario(username);
		
		if(GenericUtil.isNull(usuario)) {
			throw new UsernameNotFoundException("Usuario: " + username + " was not found in the DB");
		}
		
		if(GenericUtil.isNotNull(usuario)) {
			
			List<ModuloUsuario> modulosUsuario = moduloUsuarioJpaRepository.findByDocumentoUsuario(usuario.getDocumentoUsuario());
			
			List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
			
			if(!GenericUtil.isEmpty(modulosUsuario)) {
				
				for(ModuloUsuario moduloUsuario : modulosUsuario) {
					GrantedAuthority authority = new SimpleGrantedAuthority(Integer.toString(moduloUsuario.getNumeroModulo()));
					grantedList.add(authority);
				}
			}
			
			UserDetails userDetails = new User(usuario.getNombreUsuario(), usuario.getEncryptedPassword(), grantedList);
			return userDetails;
		}
		return null;
	}
}
