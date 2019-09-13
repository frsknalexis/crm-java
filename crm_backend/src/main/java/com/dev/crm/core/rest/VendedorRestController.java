package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.VendedoresResultViewModel;
import com.dev.crm.core.facade.VendedorFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/vendedor")
public class VendedorRestController {

	@Autowired
	@Qualifier("vendedorFacade")
	private VendedorFacade vendedorFacade;
	
	@GetMapping("/vendedores")
	public ResponseEntity<List<VendedoresResultViewModel>> listarVendedores() {
		
		try {
			
			List<VendedoresResultViewModel> vendedores = vendedorFacade.listarVendedores();
			if(GenericUtil.isCollectionEmpty(vendedores)) {
				return new ResponseEntity<List<VendedoresResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<VendedoresResultViewModel>>(vendedores, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<VendedoresResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
}
