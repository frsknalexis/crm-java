package com.dev.crm.core.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.EmpleadoDTO;
import com.dev.crm.core.dto.EmpleadoEXTINTResultViewModel;
import com.dev.crm.core.dto.EmpleadoResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.EmpleadoFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoRestController {

	@Autowired
	@Qualifier("empleadoFacade")
	private EmpleadoFacade empleadoFacade;
	
	@GetMapping("/empleados")
	public ResponseEntity<List<EmpleadoDTO>> findAll() {
		
		try {
			
			List<EmpleadoDTO> empleadosDTO = empleadoFacade.findAll();
			if(GenericUtil.isNotEmpty(empleadosDTO)) {
				return new ResponseEntity<List<EmpleadoDTO>>(empleadosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleados/activeList")
	public ResponseEntity<List<EmpleadoDTO>> getActiveList() {
		
		try {
			
			List<EmpleadoDTO> empleadosDTO = empleadoFacade.getActiveListEmpleados();
			if(GenericUtil.isNotEmpty(empleadosDTO)) {
				return new ResponseEntity<List<EmpleadoDTO>>(empleadosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleados/listarEmpleadosIntExt")
	public ResponseEntity<List<EmpleadoResultViewModel>> spListarEmpleadosIntExt() {
		
		try {
			
			List<EmpleadoResultViewModel> empleadosResultView = empleadoFacade.spListarEmpleadosIntExt();
			if(GenericUtil.isNotEmpty(empleadosResultView)) {
				return new ResponseEntity<List<EmpleadoResultViewModel>>(empleadosResultView, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EmpleadoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EmpleadoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleados/listarPersonaEmpleado")
	public ResponseEntity<List<EmpleadoDTO>> spListarPersonaEmpleado() {
		
		try {
			
			String creadoPor = "lularosaint";
			List<EmpleadoDTO> empleadosDTO = empleadoFacade.spListarPersonaEmpleado(creadoPor);
			if(GenericUtil.isNotEmpty(empleadosDTO)) {
				return new ResponseEntity<List<EmpleadoDTO>>(empleadosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleado/{documentoPersonaEmpleado}")
	public ResponseEntity<EmpleadoDTO> getByDocumentoPersonaEmpleado(@PathVariable(value="documentoPersonaEmpleado") String documentoPersonaEmpleado) {
		
		EmpleadoDTO empleadoDTO = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaEmpleado)) {
				empleadoDTO = empleadoFacade.getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
				if(GenericUtil.isObjectEmpty(empleadoDTO)) {
					return new ResponseEntity<EmpleadoDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<EmpleadoDTO>(empleadoDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<EmpleadoDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseBaseOperation> saveEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
		
		try {
			
			ResponseBaseOperation response = empleadoFacade.spInsercionEmpleado(empleadoDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBaseOperation> updateEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
		
		try {
			
			ResponseBaseOperation response = empleadoFacade.spActualizarEmpleado(empleadoDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleado/disabled/{documentoPersonaEmpleado}")
	public ResponseEntity<ResponseBaseOperation> disabledEmpleado(@PathVariable(value="documentoPersonaEmpleado") String documentoPersonaEmpleado) {
		
		try {
			
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				ResponseBaseOperation response = empleadoFacade.disabledEmpleado(documentoPersonaEmpleado);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/empleado/enabled/{documentoPersonaEmpleado}")
	public ResponseEntity<ResponseBaseOperation> enabledEmpleado(@PathVariable(value="documentoPersonaEmpleado") String documentoPersonaEmpleado) {
		
		try {
			
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				ResponseBaseOperation response = empleadoFacade.enabledEmpleado(documentoPersonaEmpleado);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/totalRegistros")
	public ResponseEntity<ResponseBaseOperation> totalRegistrosEmpleado() {
		
		try {
			
			ResponseBaseOperation response = empleadoFacade.totalRegistrosEmpleado();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/empleados/listarEmpleadoINtExt")
	public ResponseEntity<List<EmpleadoEXTINTResultViewModel>> spListarDatosGenrales() {
		
		try {
			
			List<EmpleadoEXTINTResultViewModel> empleadosDTO = empleadoFacade.spListarDatosGenrales();
			if(GenericUtil.isNotEmpty(empleadosDTO)) {
				return new ResponseEntity<List<EmpleadoEXTINTResultViewModel>>(empleadosDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EmpleadoEXTINTResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EmpleadoEXTINTResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/plantaempleado/{documentoPersona}")
	public ResponseEntity<ResponseBaseOperation> spEstadoPlanta(@PathVariable("documentoPersona") String documentoPersona) {
		
		try
		{
			ResponseBaseOperation response = empleadoFacade.spEstadoPlanta(documentoPersona);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
