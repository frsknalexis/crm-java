package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@GetMapping("/view")
	public String usuarioViewController() {
		
		return Constantes.USUARIO_VIEW;
	}
	
	@GetMapping("/profileUser")
	public String profileUserViewController() {
		return Constantes.PROFILE_USER_VIEW;
	}
}
