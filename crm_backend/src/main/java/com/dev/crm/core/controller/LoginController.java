package com.dev.crm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.crm.core.util.Constantes;

@Controller
public class LoginController {

	@GetMapping("/")
	public String loginViewController() {
		return Constantes.LOGIN_VIEW;
	}
}
