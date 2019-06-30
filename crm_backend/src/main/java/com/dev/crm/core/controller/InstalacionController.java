package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/instalacion")
public class InstalacionController {

	@GetMapping("/cortes/view")
	String cortesViewController() {
		return Constantes.CORTE_VIEW;
	}
	
	@GetMapping("/instalaciones/view")
	String instalacionesViewController() {
		return Constantes.INSTALACIONES_VIEW;
	}
	
	@GetMapping("/informeInstalaciones/view")
	String informeInstalacionesViewController() {
		return Constantes.INFORME_INSTALACION_VIEW;
	}
}
