package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.crm.core.util.Constantes;

@Controller
@RequestMapping("/administracion")
public class AdministracionController {

	@GetMapping("/pagos")
	public String administracionPagosViewController() {
		return Constantes.ADMINISTRACION_PAGOS_VIEW;
	}
	
	@GetMapping("/reportes")
	public String administracionReportesViewController() {
		return Constantes.ADMINISTRACION_REPORTES_VIEW;
	}
	
	@GetMapping("/reportesVentas")
	public String administracionReportesVentasViewController() {
		return Constantes.ADMINISTRACION_REPORTES_VENTAS_VIEW;
	}
}
