package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.ConsolidadoInternetResultViewModel;
import com.dev.crm.core.dto.DescuentoHistorialRequest;
import com.dev.crm.core.dto.DescuentoPagoResultViewModel;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.dto.DiasDeudasResultViewModel;
import com.dev.crm.core.dto.GananciaPorDiaCajaResultViewModel;
import com.dev.crm.core.dto.GananciaPorMesCajaResultViewModel;
import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.MesActualDeuda;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoAdelantadoRequest;
import com.dev.crm.core.dto.PagoMoraCableRequest;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoPorDiaResultViewModel;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagoServicioGestorRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorMesCaja1ResultViewModel;
import com.dev.crm.core.dto.PagosPorMesCaja2ResultViewModel;
import com.dev.crm.core.dto.PagosPorMesCaja3ResultViewModel;
import com.dev.crm.core.dto.PagosPorMesResultViewModel;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaRequest;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaResultViewModel;
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
	public ResponseBaseOperation pagoMoraCable(PagoMoraCableRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoService.pagoMoraCable(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.EXCEDIO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.AUTORIZADO)) {
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
	public ResponseBaseOperation realizarPagoServicioGestor(PagoServicioGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoService.realizarPagoServicioGestor(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.PAGO_ADELANTADO_CON_PROMO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.PAGO_ADELANTADO_CON_PROMO, request);
					}
					else if(StringUtil.eq(result, Constantes.PAGO_ADELANTADO_SIN_PROMO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.PAGO_ADELANTADO_SIN_PROMO, request);
					}
					else if(StringUtil.eq(result, Constantes.PAGO_RAPIDO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.PAGO_RAPIDO, request);
					}
					else if(StringUtil.eq(result, Constantes.ESTO_ES_MALO)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.ESTO_ES_MALO, request);
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
	public List<PagosPorRangoFechaBusquedaResultViewModel> spReporteListaPagosPorRangoFecha(
			PagosPorRangoFechaBusquedaRequest request) {
		
		List<PagosPorRangoFechaBusquedaResultViewModel> pagosPorRango = new ArrayList<PagosPorRangoFechaBusquedaResultViewModel>();
		
		try {
			
			pagosPorRango = pagoService.spReporteListaPagosPorRangoFecha(request);
			if(GenericUtil.isCollectionEmpty(pagosPorRango)) {
				return null;
			}
			else {
				return pagosPorRango;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagoPorDiaResultViewModel> listarPagosPorDiaSolicitado(PagosPorDiaRequest request) {
		
		List<PagoPorDiaResultViewModel> pagosPorDia = new ArrayList<PagoPorDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				pagosPorDia = pagoService.listarPagosPorDiaSolicitado(request);
				if(GenericUtil.isCollectionEmpty(pagosPorDia) && pagosPorDia.isEmpty()) {
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
	public List<DiasDeudasResultViewModel> recuperarDiasDeudas() {
		
		List<DiasDeudasResultViewModel> diasDeudas = new ArrayList<DiasDeudasResultViewModel>();
		
		try {
			
			diasDeudas = pagoService.recuperarDiasDeudas();
			if(GenericUtil.isCollectionEmpty(diasDeudas) && diasDeudas.isEmpty()) {
				return null;
			}
			else {
				return diasDeudas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosPorMesResultViewModel> pagosPorMes() {
		
		List<PagosPorMesResultViewModel> pagosPorMes = new ArrayList<PagosPorMesResultViewModel>();
		
		try {
			
			pagosPorMes = pagoService.pagosPorMes();
			if(GenericUtil.isCollectionEmpty(pagosPorMes) && pagosPorMes.isEmpty()) {
				return null;
			}
			else {
				return pagosPorMes;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PagosPorMesCaja1ResultViewModel> pagosPorMesCaja1() {
		
		List<PagosPorMesCaja1ResultViewModel> pagosPorMesCaja = new ArrayList<PagosPorMesCaja1ResultViewModel>();
		
		try {
			
			pagosPorMesCaja = pagoService.pagosPorMesCaja1();
			if(GenericUtil.isCollectionEmpty(pagosPorMesCaja) && pagosPorMesCaja.isEmpty()) {
				return null;
			}
			else {
				return pagosPorMesCaja;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosPorMesCaja2ResultViewModel> pagosPorMesCaja2() {
		
		List<PagosPorMesCaja2ResultViewModel> pagosPorMesCaja = new ArrayList<PagosPorMesCaja2ResultViewModel>();
		
		try {
			
			pagosPorMesCaja = pagoService.pagosPorMesCaja2();
			if(GenericUtil.isCollectionEmpty(pagosPorMesCaja)) {
				return null;
			}
			else {
				return pagosPorMesCaja;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosPorMesCaja3ResultViewModel> pagosPorMesCaja3() {
		
		List<PagosPorMesCaja3ResultViewModel> pagosPorMesCaja = new ArrayList<PagosPorMesCaja3ResultViewModel>();
		
		try {
			
			pagosPorMesCaja = pagoService.pagosPorMesCaja3();
			if(GenericUtil.isCollectionEmpty(pagosPorMesCaja) && pagosPorMesCaja.isEmpty()) {
				return null;
			}
			else {
				return pagosPorMesCaja;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<GananciaPorMesCajaResultViewModel> ganaciaPorMesCaja() {
		
		List<GananciaPorMesCajaResultViewModel> gananciaPorMesCaja = new ArrayList<GananciaPorMesCajaResultViewModel>();
		
		try {
			
			gananciaPorMesCaja = pagoService.ganaciaPorMesCaja();
			if(GenericUtil.isCollectionEmpty(gananciaPorMesCaja) && gananciaPorMesCaja.isEmpty()) {
				return null;
			}
			else {
				return gananciaPorMesCaja;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ConsolidadoInternetResultViewModel> listarConsolidadoInternet() {
		
		List<ConsolidadoInternetResultViewModel> listaConsolidadoInternet = new ArrayList<ConsolidadoInternetResultViewModel>();
		
		try {
			
			listaConsolidadoInternet = pagoService.listarConsolidadoInternet();
			if(GenericUtil.isCollectionEmpty(listaConsolidadoInternet)) {
				return null;
			}
			else {
				return listaConsolidadoInternet;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja() {
		
		List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja = new ArrayList<GananciaPorDiaCajaResultViewModel>();
		
		try {
			
			gananciaPorDiaCaja = pagoService.gananciaPorDiaCaja();
			if(GenericUtil.isCollectionEmpty(gananciaPorDiaCaja)) {
				return null;
			}
			else {
				return gananciaPorDiaCaja;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DiasDeudasResultViewModel> recuperarDiasDeudasParametrizado(DiasDeudasRequest request) {
		
		List<DiasDeudasResultViewModel> diasDeudas = new ArrayList<DiasDeudasResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				diasDeudas = pagoService.recuperarDiasDeudasParametrizado(request);
				if(GenericUtil.isCollectionEmpty(diasDeudas) && diasDeudas.isEmpty()) {
					return null;
				}
				else {
					return diasDeudas;
				}
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

	@Override
	public MesActualDeuda spRecuperarMesMonto(String documentoPersona) {
		
		MesActualDeuda mesActualDeuda;
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersona)) {
				mesActualDeuda = pagoService.spRecuperarMesMonto(documentoPersona);
				if(GenericUtil.isNotNull(mesActualDeuda)) {
					return mesActualDeuda;
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
