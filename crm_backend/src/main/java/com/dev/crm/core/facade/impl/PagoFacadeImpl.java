package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.DescuentoHistorialRequest;
import com.dev.crm.core.dto.DescuentoPagoResultViewModel;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoAdelantadoRequest;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaRequest;
import com.dev.crm.core.dto.PdfPagoDiaResultViewModel;
import com.dev.crm.core.dto.ReciboResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PagoFacade;
import com.dev.crm.core.service.PagoService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("pagoFacade")
public class PagoFacadeImpl implements PagoFacade {

	@Autowired
	@Qualifier("pagoService")
	private PagoService pagoService;
	
	@Override
	public ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoRequest)) {
				String result = pagoService.spPagoServicio(pagoRequest);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, pagoRequest);
					}
					else
						if(StringUtil.eq(result, Constantes.AUTORIZADO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, pagoRequest);
					}
						else
							if(StringUtil.eq(result, Constantes.EXCEDIO)) {
							return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, pagoRequest);
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
	public ResponseBaseOperation spPagoMora(PagoMoraRequest pagoMora) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoMora)) {
				String result = pagoService.spPagoMora(pagoMora);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, pagoMora);
					}
					else if(StringUtil.eq(result, Constantes.EXCEDIO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, pagoMora);
					}
					else if(StringUtil.eq(result, Constantes.AUTORIZADO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, pagoMora);
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
	public ResponseBaseOperation spPagoAdelantado(PagoAdelantadoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoService.spPagoAdelantado(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.PAGO_RAPIDO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.PAGO_ADELANTADO_SIN_PROMO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.PAGO_ADELANTADO_CON_PROMO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
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
	public ResponseBaseOperation spInsertarConsecutivoPago(ConsecutivoPagoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoService.spInsertarConsecutivoPago(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.BUENO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.SIN_PERMISO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.ERROR)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
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
	public List<ClientePagoResultViewModel> spListarClientesPago(String usuario) {
		
		List<ClientePagoResultViewModel> clientesPagos = new ArrayList<ClientePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				clientesPagos = pagoService.spListarClientesPago(usuario);
			}
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return clientesPagos;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja) {
		
		List<MesDeudaResultViewModel> mesesDeudas = new ArrayList<MesDeudaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaCliente) && GenericUtil.isNotEmpty(numeroCaja)) {
				mesesDeudas = pagoService.spMesesDeudas(documentoPersonaCliente, numeroCaja);
			}
			if(GenericUtil.isNotEmpty(mesesDeudas)) {
				return mesesDeudas;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario) {
		
		List<PagosDelDiaResultViewModel> pagosDelDia = new ArrayList<PagosDelDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(usuario)) {
				pagosDelDia = pagoService.spListarPagosDelDia(usuario);
				if(GenericUtil.isCollectionEmpty(pagosDelDia)) {
					return null;
				}
				else {
					return pagosDelDia;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario) {
		
		List<ListaPagosPorCajaResultViewModel> pagosPorCaja = new ArrayList<ListaPagosPorCajaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(usuario)) {
				pagosPorCaja = pagoService.spListaPagosPorCajaReporte(usuario);
				if(GenericUtil.isCollectionEmpty(pagosPorCaja) && pagosPorCaja.isEmpty()) {
					return null;
				}
				else {
					return pagosPorCaja;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request) {
		
		List<PagosPorDiaResultViewModel> pagosPorDia = new ArrayList<PagosPorDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				pagosPorDia = pagoService.spReporteListaPagosPorDia(request);
				if(GenericUtil.isCollectionEmpty(pagosPorDia)) {
					return null;
				}
				else {
					return pagosPorDia;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosPorDiaResultViewModel> spReporteListaPagosPorRangoFecha(
			PagosPorRangoFechaBusquedaRequest request) {
		
		List<PagosPorDiaResultViewModel> pagosPorDia = new ArrayList<PagosPorDiaResultViewModel>();
		
		try {
			
			pagosPorDia = pagoService.spReporteListaPagosPorRangoFecha(request);
			if(GenericUtil.isCollectionEmpty(pagosPorDia)) {
				return null;
			}
			else {
				return pagosPorDia;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<DetallePagoResultViewModel> spListarDetallePago(String persona) {
		
		List<DetallePagoResultViewModel> Dpago = new ArrayList<DetallePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(persona)) {
				Dpago = pagoService.spListarDetallePago(persona);
			}
			if(GenericUtil.isNotEmpty(Dpago)) {
				return Dpago;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago) {
		
		ReciboResultViewModel reciboResult;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario) && GenericUtil.isNotNull(codigoPago) && codigoPago.intValue() > 0) {
				reciboResult = pagoService.spGenerarReciboPago(usuario, codigoPago);
				
				if(GenericUtil.isNotNull(reciboResult)) {
					return reciboResult;
				}
				else if(GenericUtil.isNull(reciboResult)) {
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
	public List<PdfPagoDiaResultViewModel> spListaPdfPagoDia(String usuario) {

		List<PdfPagoDiaResultViewModel> clientesPagos = new ArrayList<PdfPagoDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				clientesPagos = pagoService.spListaPdfPagosDia(usuario);
			}
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return clientesPagos;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spGenerarDescuento(DescuentoHistorialRequest codigo) {

		try {
			
			if(GenericUtil.isNotNull(codigo)) {
				String result = pagoService.spGenerarDescuento(codigo);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codigo);
					}
					else
						if(StringUtil.eq(result, Constantes.ERROR)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, codigo);
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
	public DescuentoPagoResultViewModel spRecuperarDatosMesPago(String persona) {

		DescuentoPagoResultViewModel cDaOnu;
		
		try {
			
			if(!GenericUtil.isEmpty(persona)) {
				cDaOnu = pagoService.spRecuperarMesPago(persona);
				if(GenericUtil.isNotNull(cDaOnu)) {
					return cDaOnu;
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
