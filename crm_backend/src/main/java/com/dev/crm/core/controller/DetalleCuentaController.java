package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/detalleCuenta")
public class DetalleCuentaController {
	
	@GetMapping("/cuentas/view")
	public String cuentasViewController() {
		return Constantes.CUENTAS_VIEW;
	}

	@GetMapping("/generarCuenta/view")
	public String detalleCuentaViewController() {
		return Constantes.DETALLE_CUENTA_VIEW;
	}
	
	@GetMapping("/reprogramacion/view")
	public String reprogramacionViewController() {
		return Constantes.REPROGRAMACION_VIEW;
	}
}
