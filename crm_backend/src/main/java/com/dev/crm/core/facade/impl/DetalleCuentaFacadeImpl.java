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
				String result = detalleCuentaService.spInsercionCuentaInternet(detalleCuenta);
				if(result.equals(Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.CREATED_STATUS, result, detalleCuentaDTO);
				}
				else if(result.equals(Constantes.ESTADO)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, detalleCuentaDTO);
				}
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
				String result = detalleCuentaService.spInsercionCuentaCable(detalleCuenta);
				if(result.equals(Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.CREATED_STATUS, result, detalleCuentaDTO);
				}
				else if(result.equals(Constantes.ESTADO)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, detalleCuentaDTO);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spReprogramarInstalacionCable() {
		
		try {
			
			detalleCuentaService.spReprogramarInstalacionCable();
			return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "REPROGRAMACION DE INSTALACION DE CABLE CON EXITO", null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spReprogramarInstalacionInternet() {
		
		try {
			
			detalleCuentaService.spReprogramarInstalacionInternet();
			return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "REPROGRAMACION DE INSTALACION DE INTERNET CON EXITO", null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
