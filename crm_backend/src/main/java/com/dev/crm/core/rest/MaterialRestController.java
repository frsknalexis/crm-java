package com.dev.crm.core.rest;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;
import com.dev.crm.core.dto.MaterialResultViewModel;
import com.dev.crm.core.facade.MaterialFacade;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.view.pdf.PdfGenerator;

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
	
	@GetMapping(value = "/reciboLiquidacion/{codigoServicioInternet}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generarReciboLiquidacion(@PathVariable(value = "codigoServicioInternet") Integer codigoServicioInternet) {
		
		try {
			
			if(GenericUtil.isNotNull(codigoServicioInternet) && codigoServicioInternet.intValue() > 0) {
				LiquidacionMaterialResultViewModel liquidacion = materialFacade.generarLiquidacionMaterial(codigoServicioInternet);
				
				ByteArrayInputStream bis = PdfGenerator.generarReciboLiquidacion(liquidacion);
				
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Disposition", "inline; filename=ReciboLiquidacion.pdf");
				
				return ResponseEntity.ok()
						.headers(headers)
						.contentType(MediaType.APPLICATION_PDF)
						.body(new InputStreamResource(bis));
			}
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
