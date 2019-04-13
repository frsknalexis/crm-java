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

import com.dev.crm.core.dto.CargoDTO;
import com.dev.crm.core.facade.CargoFacade;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@RestController
@RequestMapping("/api/v1/cargo")
public class CargoRestController {

	@Autowired
	@Qualifier("cargoFacade")
	private CargoFacade cargoFacade;
	
	@GetMapping("/cargos")
	public ResponseEntity<List<CargoDTO>> findAll() {
		
		try {
			
			List<CargoDTO> cargosDTO = cargoFacade.findAll();
			if(GenericUtil.isNotEmpty(cargosDTO)) {
				return new ResponseEntity<List<CargoDTO>>(cargosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<CargoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CargoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cargos/autocomplete/{termino}")
	public ResponseEntity<List<CargoDTO>> cargarCargosByDescripcion(@PathVariable(value="termino") String termino) {
		
		try {
			
			if(GenericUtil.isNotEmpty(termino)) {
				if(StringUtil.validateTextWithPattern(termino, "^[a-zA-Z]+$")) {
					List<CargoDTO> cargosDTO = cargoFacade.findByDescripcionCargo(termino);
					if(GenericUtil.isNotEmpty(cargosDTO)) {
						return new ResponseEntity<List<CargoDTO>>(cargosDTO, HttpStatus.OK);
					}
					else {
						return new ResponseEntity<List<CargoDTO>>(HttpStatus.NO_CONTENT);
					}
				}
				else {
					return new ResponseEntity<List<CargoDTO>>(HttpStatus.NO_CONTENT);
				}
			}
			else {
				return new ResponseEntity<List<CargoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CargoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
