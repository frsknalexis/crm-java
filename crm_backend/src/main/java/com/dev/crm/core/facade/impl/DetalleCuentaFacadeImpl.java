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
import com.dev.crm.core.util.StringUtil;

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
	public ResponseBaseOperation spContadorPendientesCable() {
		
		try {
			
			Integer result = detalleCuentaService.spContadorPendientesCable();
			return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "CONTADOR PENDIENTES CABLE" , result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spContadorPendientesInternet() {
		
		try {
			
			Integer result = detalleCuentaService.spContadorPendientesInternet();
			return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "CONTADOR PENDIENTES INTERNET", result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spReprogramarInstalacionCable() {
		
		try {
			
			String result = detalleCuentaService.spReprogramarInstalacionCable();
			if(StringUtil.eq(result, Constantes.HECHO)) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "REPROGRAMACION DE INSTALACION DE CABLE DEL DIA CON EXITO", result);
			}
			else if(StringUtil.eq(result, Constantes.UPS)) {
				return new ResponseBaseOperation(Constantes.ERROR_STATUS, "HAY INSTALACIONES DE CABLE PENDIENTES", result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spReprogramarInstalacionInternet() {
		
		try {
			
			String result = detalleCuentaService.spReprogramarInstalacionInternet();
			if(StringUtil.eq(result, Constantes.HECHO)) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "REPROGRAMACION DE INSTALACION DE INTERNET DEL DIA CON EXITO", result);
			}
			else if(StringUtil.eq(result, Constantes.UPS)) {
				return new ResponseBaseOperation(Constantes.ERROR_STATUS, "HAY INSTALACIONES DE INTERNET PENDIENTES", result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spRevalidandoFechaCable() {
		
		try {
			
			String result = detalleCuentaService.spRevalidandoFechaCable();
			if(StringUtil.eq(result, Constantes.HECHO)) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "SE REPROGRAMARON LAS INSTALACIONES DE CABLE PENDIENTES CON EXITO", result);
			}
			else if(StringUtil.eq(result, Constantes.UPS)) {
				return new ResponseBaseOperation(Constantes.ERROR_STATUS, "NO HAY INSTALACIONES DE CABLE PENDIENTES", result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spRevalidandoFechaInternet() {
		
		try {
			
			String result = detalleCuentaService.spRevalidandoFechaInternet();
			if(StringUtil.eq(result, Constantes.HECHO)) {
				
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, "SE REPROGRAMARON LAS INSTALACIONES DE INTERNET PENDIENTES CON EXITO", result);
			}
			else if(StringUtil.eq(result, Constantes.UPS)) {
				return new ResponseBaseOperation(Constantes.ERROR_STATUS, "NO HAY INSTALACIONES DE INTERNET PENDIENTES", result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
