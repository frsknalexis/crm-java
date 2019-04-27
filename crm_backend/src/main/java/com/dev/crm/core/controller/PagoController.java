package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/pago")
public class PagoController {

	@GetMapping("/pagos")
	public String pagosViewController() {
		return Constantes.PAGOS_VIEW;
	}
}
