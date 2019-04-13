package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@GetMapping("/view")
	public String empleadoViewController() {
		return Constantes.EMPLEADO_VIEW;
	}
}
