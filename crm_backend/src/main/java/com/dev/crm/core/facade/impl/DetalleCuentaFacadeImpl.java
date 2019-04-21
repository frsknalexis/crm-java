package com.dev.crm.core.facade.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.DetalleCuentaFacade;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.service.DetalleCuentaService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Component("detalleCuentaFacade")
public class DetalleCuentaFacadeImpl implements DetalleCuentaFacade {

	@Autowired
	@Qualifier("detalleCuentaService")
	private DetalleCuentaService detalleCuentaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ResponseBaseOperation spInsercionCuentaInternet(DetalleCuentaDTO detalleCuentaDTO) {
		
		try {
			
			DetalleCuenta detalleCuenta = modelMapper.map(detalleCuentaDTO, DetalleCuenta.class);
			if(GenericUtil.isNotNull(detalleCuenta)) {
				detalleCuentaService.spInsercionCuentaInternet(detalleCuenta);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, "SE GENERO LA CUENTA DE INTERNET PARA EL CLIENTE CON EXITO", detalleCuentaDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spInsercionCuentaCable(DetalleCuentaDTO detalleCuentaDTO) {
		
		try {
			
			DetalleCuenta detalleCuenta = modelMapper.map(detalleCuentaDTO, DetalleCuenta.class);
			if(GenericUtil.isNotNull(detalleCuenta)) {
				detalleCuentaService.spInsercionCuentaCable(detalleCuenta);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, "SE GENERO LA CUENTA DE CABLE PARA EL CLIENTE CON EXITO", detalleCuentaDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
