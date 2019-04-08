package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@GetMapping("/view")
	public String personaViewController() {
		
		return Constantes.PERSONA_VIEW;				
	}
}
