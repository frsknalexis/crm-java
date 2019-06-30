package com.dev.crm.core.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.OnuFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/onu")
public class OnuRestController {

	@Autowired
	@Qualifier("onuFacade")
	private OnuFacade onuFacade;
	
	@PostMapping("/envioDatosOnu")
	public ResponseEntity<ResponseBaseOperation> envioDatosOnu(@Valid @RequestBody DatosOnuInstalacionRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				ResponseBaseOperation response = onuFacade.envioDatosOnu(request);
				return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
