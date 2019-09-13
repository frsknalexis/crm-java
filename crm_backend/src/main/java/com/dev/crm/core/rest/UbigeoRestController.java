package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.UbigeoDTO;
import com.dev.crm.core.dto.UbigeoResultViewModel;
import com.dev.crm.core.facade.UbigeoFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/ubigeo")
public class UbigeoRestController {

	@Autowired
	@Qualifier("ubigeoFacade")
	private UbigeoFacade ubigeoFacade;
	
	@GetMapping("/ubigeos")
	public ResponseEntity<List<UbigeoDTO>> findAll() {
		
		try {
			
			List<UbigeoDTO> ubigeosDTO = ubigeoFacade.findAll();
			if(GenericUtil.isNotEmpty(ubigeosDTO)) {
				return new ResponseEntity<List<UbigeoDTO>>(ubigeosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listaUbigeo")
	public ResponseEntity<List<UbigeoResultViewModel>> listarUbigeo() {
		
		try {
			
			List<UbigeoResultViewModel> listaUbigeo = ubigeoFacade.listarUbigeo();
			if(GenericUtil.isCollectionEmpty(listaUbigeo)) {
				return new ResponseEntity<List<UbigeoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<UbigeoResultViewModel>>(listaUbigeo, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<UbigeoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ubigeos/autocomplete/{termino}")
	public ResponseEntity<List<UbigeoDTO>> cargarUbigeosByNombre(@PathVariable(value="termino") String termino) {
		
		try {
			
			if(!(GenericUtil.isEmpty(termino))) {
				if(termino.matches("^[a-zA-Z]+$")) {
					List<UbigeoDTO> ubigeosDTO = ubigeoFacade.findByNombreUbigeo(termino);
					if(GenericUtil.isNotEmpty(ubigeosDTO)) {
						return new ResponseEntity<List<UbigeoDTO>>(ubigeosDTO, HttpStatus.OK);
					}
					else {
						return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.NO_CONTENT);
					}
				}
				else {
					return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.NO_CONTENT);
				}
			}
			else {
				return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<UbigeoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
