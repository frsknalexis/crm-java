package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.CuentaPorEstadoRequest;
import com.dev.crm.core.dto.CuentaPorEstadoResultViewModel;
import com.dev.crm.core.dto.CuentaPorVendedorRequest;
import com.dev.crm.core.dto.CuentaPorVendedorResultViewModel;
import com.dev.crm.core.dto.CuentaRequest;
import com.dev.crm.core.dto.CuentasInstaladasRequest;
import com.dev.crm.core.dto.CuentasInstaladasResultViewModel;
import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.dto.CuentasRangoRequest;
import com.dev.crm.core.dto.CuentasRangoResultViewModel;
import com.dev.crm.core.dto.CuentasResultViewModel;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.dto.DetalleCuentaCableRequest;
import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.DetalleCuentaDuoRequest;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.EstadoCuentasResultViewModel;
import com.dev.crm.core.dto.EstadosCuentaResultViewModel;
import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.VentasPorDiaResultViewModel;
import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;
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
	public ResponseBaseOperation insercionCuentaCable(DetalleCuentaCableRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaService.insercionCuentaCable(request);
				if(StringUtil.eq(result, Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.CREATED_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ESTADO)) {
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
	public ResponseBaseOperation insercionCuentaDuo(DetalleCuentaDuoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaService.insercionCuentaDuo(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.HECHO, request);
					}
					else if(StringUtil.eq(result, Constantes.ESTADO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.ESTADO, request);
					}
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
	public List<EstadoCuentasResultViewModel> listarEstadoCuentas() {
		
		List<EstadoCuentasResultViewModel> estadoCuentas = new ArrayList<EstadoCuentasResultViewModel>();
		
		try {
			
			estadoCuentas = detalleCuentaService.listarEstadoCuentas();
			if(GenericUtil.isCollectionEmpty(estadoCuentas)) {
				return null;
			}
			else {
				return estadoCuentas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<EstadosCuentaResultViewModel> listarEstadosCuentas() {
	
		List<EstadosCuentaResultViewModel> estadosCuentas = new ArrayList<EstadosCuentaResultViewModel>();
		
		try {
			
			estadosCuentas = detalleCuentaService.listarEstadosCuentas();
			if(GenericUtil.isCollectionEmpty(estadosCuentas) && estadosCuentas.isEmpty()) {
				return null;
			}
			else {
				return estadosCuentas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<VentasPorDiaResultViewModel> cantidadVentasPorDia() {
		
		List<VentasPorDiaResultViewModel> ventasPorDia = new ArrayList<VentasPorDiaResultViewModel>();
		
		try {
			
			ventasPorDia = detalleCuentaService.cantidadVentasPorDia();
			if(GenericUtil.isCollectionEmpty(ventasPorDia)) {
				return null;
			}
			else {
				return ventasPorDia;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<VentasPorVendedorResultViewModel> cantidadVentasPorVendedor() {
		
		List<VentasPorVendedorResultViewModel> ventasPorVendedor = new ArrayList<VentasPorVendedorResultViewModel>();
		
		try {
			
			ventasPorVendedor = detalleCuentaService.cantidadVentasPorVendedor();
			if(GenericUtil.isCollectionEmpty(ventasPorVendedor)) {
				return null;
			}
			else {
				return ventasPorVendedor;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CuentasResultViewModel> listarCuentasPorDia(CuentaRequest request) {
		
		List<CuentasResultViewModel> cuentasPorDia = new ArrayList<CuentasResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorDia = detalleCuentaService.listarCuentasPorDia(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorDia)) {
					return null;
				}
				else {
					return cuentasPorDia;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CuentaPorEstadoResultViewModel> listarCuentasPorEstado(CuentaPorEstadoRequest request) {
		
		List<CuentaPorEstadoResultViewModel> cuentasPorEstado = new ArrayList<CuentaPorEstadoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorEstado = detalleCuentaService.listarCuentasPorEstado(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorEstado) && cuentasPorEstado.isEmpty()) {
					return null;
				}
				else {
					return cuentasPorEstado;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CuentaPorVendedorResultViewModel> cuentasPorVendedor(CuentaPorVendedorRequest request) {
		
		List<CuentaPorVendedorResultViewModel> cuentasPorVendedor = new ArrayList<CuentaPorVendedorResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorVendedor = detalleCuentaService.cuentasPorVendedor(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorVendedor)) {
					return null;
				}
				else {
					return cuentasPorVendedor;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CuentasRangoResultViewModel> listarCuentasPorRango(CuentasRangoRequest request) {
		
		List<CuentasRangoResultViewModel> cuentasPorRango = new ArrayList<CuentasRangoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorRango = detalleCuentaService.listarCuentasPorRango(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorRango)) {
					return null;
				}
				else {
					return cuentasPorRango;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CuentasInstaladasResultViewModel> listarCuentasInstaladasPorFecha(CuentasInstaladasRequest request) {
		
		List<CuentasInstaladasResultViewModel> cuentasInstaladas = new ArrayList<CuentasInstaladasResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasInstaladas = detalleCuentaService.listarCuentasInstaladasPorFecha(request);
				if(GenericUtil.isCollectionEmpty(cuentasInstaladas)) {
					return null;
				}
				else {
					return cuentasInstaladas;
				}
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
