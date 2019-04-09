package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.SexoDTO;
import com.dev.crm.core.facade.SexoFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/sexo")
public class SexoRestController {

	@Autowired
	@Qualifier("sexoFacade")
	private SexoFacade sexoFacade;
	
	@GetMapping("/sexos")
	public ResponseEntity<List<SexoDTO>> findAll() {
		
		try {
			
			List<SexoDTO> ubigeosDTO = sexoFacade.findAll();
			if(GenericUtil.isNotEmpty(ubigeosDTO)) {
				return new ResponseEntity<List<SexoDTO>>(ubigeosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<SexoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<SexoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
