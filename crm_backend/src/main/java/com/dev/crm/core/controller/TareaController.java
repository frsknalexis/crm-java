package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/tarea")
public class TareaController {
	
	@GetMapping("/tarea/view")
	public String atencionViewController() {
		
		return Constantes.TAREA_VIEW;
	}
	
}
