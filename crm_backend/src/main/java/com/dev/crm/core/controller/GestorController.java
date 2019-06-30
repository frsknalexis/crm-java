package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/gestor")
public class GestorController {

	@GetMapping("/clienteGestores/view")
	String clienteGestoresViewController() {
		return Constantes.CLIENTE_GESTORES_VIEW;
	}
}
