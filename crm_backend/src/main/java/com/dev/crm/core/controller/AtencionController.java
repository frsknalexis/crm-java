package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/atencion")
public class AtencionController {
	
	@GetMapping("/atencion/view")
	public String atencionViewController() {
		
		return Constantes.ATENCION_VIEW;
	}
	
	@GetMapping("/herramientas/view")
	public String herramientasViewController() {
		
		return Constantes.HERRAMIENTAS_VIEW;
	}
	
	@GetMapping("/reclamo/view")
	public String reclamoViewController() {
		
		return Constantes.RECLAMO_VIEW;
	}
	
}
