package com.dev.crm.core.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Controller
public class LoginController {

	@GetMapping("/")
	public String indexViewController() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginViewController(Principal principal) {
		
		if(GenericUtil.isNotNull(principal)) {
			return "redirect:/dashboard";
		}
		return Constantes.LOGIN_VIEW;
	}
}
