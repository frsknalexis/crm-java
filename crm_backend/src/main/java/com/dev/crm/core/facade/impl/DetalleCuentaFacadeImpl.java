package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.ObservacionResultViewModel;
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
	public ResponseBaseOperation spInsercionCuentaInternet(DetalleCuentaRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaService.spInsercionCuentaInternet(request);
				if(result.equals(Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.CREATED_STATUS, result, request);
				}
				else if(result.equals(Constantes.ESTADO)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.LLENO)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
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
	public ResponseBaseOperation spEnvioDatosInternetServicio(DatosInternetServicioRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaService.spEnvioDatosInternetServicio(request);
				if(StringUtil.eq(result, Constantes.BUENO)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public ResponseBaseOperation spEnvioDatosMaterial(DatosMaterialesRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaService.spEnvioDatosMaterial(request);
				if(StringUtil.eq(result, Constantes.BUENO)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
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

	@Override
	public List<CuentasPorInstalarResultViewModel> listarCuentaPorInstalar() {
		
		List<CuentasPorInstalarResultViewModel> cuentasPorInstalar = new ArrayList<CuentasPorInstalarResultViewModel>();
		
		try {
			
			cuentasPorInstalar = detalleCuentaService.listarCuentaPorInstalar();
			if(GenericUtil.isCollectionEmpty(cuentasPorInstalar)) {
				return null;
			}
			else {
				return cuentasPorInstalar;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spUpdateDetalleCuenta(Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				detalleCuentaService.spUpdateDetalleCuenta(codigoDetalleCuenta);
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_DISABLED, codigoDetalleCuenta);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta) {
		
		ObservacionResultViewModel observacion;
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				observacion = detalleCuentaService.spRecuperarObservacion(codigoDetalleCuenta);
				if(GenericUtil.isNotNull(observacion)) {
					return observacion;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
