package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.MaterialResultViewModel;
import com.dev.crm.core.facade.MaterialFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/material")
public class MaterialRestController {

	@Autowired
	@Qualifier("materialFacade")
	private MaterialFacade materialFacade;
	
	@GetMapping("/materiales")
	public ResponseEntity<List<MaterialResultViewModel>> listarMateriales() {
		
		try {
			
			List<MaterialResultViewModel> materiales = materialFacade.listarMateriales();
			if(GenericUtil.isCollectionEmpty(materiales)) {
				return new ResponseEntity<List<MaterialResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<MaterialResultViewModel>>(materiales, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<MaterialResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
}
