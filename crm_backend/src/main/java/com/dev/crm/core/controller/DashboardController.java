package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.crm.core.util.Constantes;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String dashboardViewController() {
		
		return Constantes.DASHBOARD_VIEW;
	}
	@GetMapping("/dashboard2")
	public String dashboardView2Controller() {
		
		return Constantes.DASHBOARD_VIEW2;
	}
}
