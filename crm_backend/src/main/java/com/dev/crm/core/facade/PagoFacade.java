package com.dev.crm.core.facade;

import java.util.List;

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

public interface PagoFacade {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
	
	List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario);
	
	List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario);
	
	List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request);
	
	List<PagosPorRangoFechaBusquedaResultViewModel> spReporteListaPagosPorRangoFecha(PagosPorRangoFechaBusquedaRequest request);
	
	List<PagoPorDiaResultViewModel> listarPagosPorDiaSolicitado(PagosPorDiaRequest request);
	
	List<DiasDeudasResultViewModel> recuperarDiasDeudas();
	
	List<PagosPorMesResultViewModel> pagosPorMes();
	
	List<PagosPorMesCaja1ResultViewModel> pagosPorMesCaja1();
	
	List<PagosPorMesCaja2ResultViewModel> pagosPorMesCaja2();
	
	List<PagosPorMesCaja3ResultViewModel> pagosPorMesCaja3();
	
	List<GananciaPorMesCajaResultViewModel> ganaciaPorMesCaja();
	
	List<ConsolidadoInternetResultViewModel> listarConsolidadoInternet();
	
	List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja();
	
	List<DiasDeudasResultViewModel> recuperarDiasDeudasParametrizado(DiasDeudasRequest request);
	
	ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest);
	
	ResponseBaseOperation spPagoMora(PagoMoraRequest pagoMora);
	
	ResponseBaseOperation pagoMoraCable(PagoMoraCableRequest request);
	
	ResponseBaseOperation spPagoAdelantado(PagoAdelantadoRequest request);
	
	ResponseBaseOperation realizarPagoServicioGestor(PagoServicioGestorRequest request);
	
	ResponseBaseOperation spInsertarConsecutivoPago(ConsecutivoPagoRequest request);
	
	List<DetallePagoResultViewModel> spListarDetallePago(String persona);
	
	ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago);
	
	List<PdfPagoDiaResultViewModel> spListaPdfPagoDia(String usuario);
	
	ResponseBaseOperation spGenerarDescuento(DescuentoHistorialRequest codigo);
	
	DescuentoPagoResultViewModel spRecuperarDatosMesPago(String persona);
	
	MesActualDeuda spRecuperarMesMonto(String documentoPersona);
}
