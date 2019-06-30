package com.dev.crm.core.service;

import java.util.List;

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

public interface PagoService {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
	
	List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario);
	
	List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario);
	
	List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request);
	
	List<PagosPorDiaResultViewModel> spReporteListaPagosPorRangoFecha(PagosPorRangoFechaBusquedaRequest request);
	
	String spPagoServicio(PagoRequest pagoRequest);
	
	String spPagoMora(PagoMoraRequest pagoMora);
	
	String spPagoAdelantado(PagoAdelantadoRequest request);
	
	String spInsertarConsecutivoPago(ConsecutivoPagoRequest request);
	
	List<DetallePagoResultViewModel> spListarDetallePago(String persona);
	
	ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago);
	
	List<PdfPagoDiaResultViewModel> spListaPdfPagosDia(String usuario);
	
	String spGenerarDescuento (DescuentoHistorialRequest codigo);
	
	DescuentoPagoResultViewModel spRecuperarMesPago(String gpersona);
}
