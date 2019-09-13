package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.dev.crm.core.repository.jdbc.ClientePagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.ConsecutivoPagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.ConsolidadoInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetallePagoResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.DeudasJdbcRepository;
import com.dev.crm.core.repository.jdbc.DiasDeudasJdbcRepository;
import com.dev.crm.core.repository.jdbc.GananciaPorDiaCajaJdbcRepository;
import com.dev.crm.core.repository.jdbc.GananciaPorMesCajaJdbcRepository;
import com.dev.crm.core.repository.jdbc.HistorialDescuentoResquestdbcRepository;
import com.dev.crm.core.repository.jdbc.ListaPagosPorCajaJdbcRepository;
import com.dev.crm.core.repository.jdbc.MesDeudaActualResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.MesDeudaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoAdelantadoJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoDelDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoListOutdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoMoraCableJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoMoraJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoPorDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoPorRangoFechaBusquedaJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoServicioGestorJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagosPorDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagosPorMesCaja1JdbcRepository;
import com.dev.crm.core.repository.jdbc.PagosPorMesCaja2JdbcRepository;
import com.dev.crm.core.repository.jdbc.PagosPorMesCaja3JdbcRepository;
import com.dev.crm.core.repository.jdbc.PagosPorMesJdbcRepository;
import com.dev.crm.core.repository.jdbc.PdfPagoDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.ReciboJdbcRepository;
import com.dev.crm.core.service.PagoService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("pagoService")
@Transactional("hibernateTransactionManager")
public class PagoServiceImpl implements PagoService {

	@Autowired
	@Qualifier("pagoJdbcRepository")
	private PagoJdbcRepository pagoJdbcRepository;
	
	@Autowired
	@Qualifier("clientePagoJdbcRepository")
	private ClientePagoJdbcRepository clientePagoJdbcRepository;
	
	@Autowired
	@Qualifier("mesDeudaResultJdbcRepository")
	private MesDeudaResultJdbcRepository mesDeudaResultJdbcRepository;
	
	@Autowired
	@Qualifier("pagoMoraJdbcRepository")
	private PagoMoraJdbcRepository pagoMoraJdbcRepository;
	
	@Autowired
	@Qualifier("pagoDelDiaJdbcRepository")
	private PagoDelDiaJdbcRepository pagoDelDiaJdbcRepository;
	
	@Autowired
	@Qualifier("consecutivoPagoJdbcRepository")
	private ConsecutivoPagoJdbcRepository consecutivoPagoJdbcRepository;
	
	@Autowired
	@Qualifier("DetallePagoResultJdbcRepository")
	private DetallePagoResultJdbcRepository detallePagoResultJdbcRepository;
	
	@Autowired
	@Qualifier("reciboJdbcRepository")
	private ReciboJdbcRepository reciboJdbcRepository;
	
	@Autowired
	@Qualifier("listaPagosPorCajaJdbcRepository")
	private ListaPagosPorCajaJdbcRepository listaPagosPorCajaJdbcRepository;
	
	@Autowired
	@Qualifier("pagoPorDiaJdbcRepository")
	private PagoPorDiaJdbcRepository pagoPorDiaJdbcRepository;
	
	@Autowired
	@Qualifier("pagoPorRangoFechaBusquedaJdbcRepository")
	private PagoPorRangoFechaBusquedaJdbcRepository pagoPorRangoFechaBusquedaJdbcRepository;
	
	@Autowired
	@Qualifier("PdfPagoDiaJdbcRepository")
	private PdfPagoDiaJdbcRepository pdfPagoDiaJdbcRepository;
	
	@Autowired
	@Qualifier("HistorialDescuentoResquestdbcRepository")
	private HistorialDescuentoResquestdbcRepository historialDescuentoResquestdbcRepository;
	
	@Autowired
	@Qualifier("PagoListOutdbcRepository")
	private PagoListOutdbcRepository pagoListOutdbcRepository;
	
	@Autowired
	@Qualifier("pagoAdelantadoJdbcRepository")
	private PagoAdelantadoJdbcRepository pagoAdelantadoJdbcRepository;
	
	@Autowired
	@Qualifier("mesDeudaActualResultJdbcRepository")
	private MesDeudaActualResultJdbcRepository mesDeudaActualResultJdbcRepository;
	
	@Autowired
	@Qualifier("pagosPorDiaJdbcRepository")
	private PagosPorDiaJdbcRepository pagosPorDiaJdbcRepository;
	
	@Autowired
	@Qualifier("diasDeudasJdbcRepository")
	private DiasDeudasJdbcRepository diasDeudasJdbcRepository;
	
	@Autowired
	@Qualifier("deudasJdbcRepository")
	private DeudasJdbcRepository deudasJdbcRepository;
	
	@Autowired
	@Qualifier("pagosPorMesJdbcRepository")
	private PagosPorMesJdbcRepository pagosPorMesJdbcRepository;
	
	@Autowired
	@Qualifier("pagosPorMesCaja1JdbcRepository")
	private PagosPorMesCaja1JdbcRepository pagosPorMesCaja1JdbcRepository;
	
	@Autowired
	@Qualifier("pagosPorMesCaja2JdbcRepository")
	private PagosPorMesCaja2JdbcRepository pagosPorMesCaja2JdbcRepository;
	
	@Autowired
	@Qualifier("pagosPorMesCaja3JdbcRepository")
	private PagosPorMesCaja3JdbcRepository pagosPorMesCaja3JdbcRepository;
	
	@Autowired
	@Qualifier("gananciaPorMesCajaJdbcRepository")
	private GananciaPorMesCajaJdbcRepository gananciaPorMesCajaJdbcRepository;
	
	@Autowired
	@Qualifier("gananciaPorDiaCajaJdbcRepository")
	private GananciaPorDiaCajaJdbcRepository gananciaPorDiaCajaJdbcRepository;
	
	@Autowired
	@Qualifier("pagoServicioGestorJdbcRepository")
	private PagoServicioGestorJdbcRepository pagoServicioGestorJdbcRepository;
	
	@Autowired
	@Qualifier("consolidadoInternetJdbcRepository")
	private ConsolidadoInternetJdbcRepository consolidadoInternetJdbcRepository;
	
	@Autowired
	@Qualifier("pagoMoraCableJdbcRepository")
	private PagoMoraCableJdbcRepository pagoMoraCableJdbcRepository;
	
	@Override
	public String spPagoServicio(PagoRequest pagoRequest) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoRequest)) {
				String result = pagoJdbcRepository.spPagoServicio(pagoRequest);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String spPagoMora(PagoMoraRequest pagoMora) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoMora)) {
				String result = pagoMoraJdbcRepository.spPagoMora(pagoMora);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String pagoMoraCable(PagoMoraCableRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoMoraCableJdbcRepository.pagoMoraCable(request);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String spPagoAdelantado(PagoAdelantadoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoAdelantadoJdbcRepository.spPagoAdelantado(request);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String realizarPagoServicioGestor(PagoServicioGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = pagoServicioGestorJdbcRepository.realizarPagoServicioGestor(request);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String spInsertarConsecutivoPago(ConsecutivoPagoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = consecutivoPagoJdbcRepository.spInsertarConsecutivoPago(request);
				if(StringUtil.hasText(result)) {
					return result;
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
	public List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja) {
		
		List<MesDeudaResultViewModel> mesesDeuda = new ArrayList<MesDeudaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaCliente) && GenericUtil.isNotEmpty(numeroCaja)) {
				mesesDeuda = mesDeudaResultJdbcRepository.spMesesDeudas(documentoPersonaCliente, numeroCaja);
			}
			if(GenericUtil.isNotEmpty(mesesDeuda)) {
				return mesesDeuda;
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
			if(StringUtil.hasText(usuario)) {
				pagosDelDia = pagoDelDiaJdbcRepository.spListarPagosDelDia(usuario);
				if(GenericUtil.isEmpty(pagosDelDia)) {
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
			
			if(StringUtil.hasText(usuario)) {
				pagosPorCaja = listaPagosPorCajaJdbcRepository.spListaPagosPorCajaReporte(usuario);
				if(GenericUtil.isEmpty(pagosPorCaja) && pagosPorCaja.isEmpty()) {
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
				pagosPorDia = pagoPorDiaJdbcRepository.spReporteListaPagosPorDia(request);
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
			
			if(GenericUtil.isNotNull(request)) {
				pagosPorRango = pagoPorRangoFechaBusquedaJdbcRepository.spReporteListaPagosPorRangoFecha(request);
				if(GenericUtil.isCollectionEmpty(pagosPorRango)) {
					return null;
				}
				else {
					return pagosPorRango;
				}
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
				pagosPorDia = pagosPorDiaJdbcRepository.listarPagosPorDiaSolicitado(request);
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
	public List<DiasDeudasResultViewModel> recuperarDiasDeudas() {
		
		List<DiasDeudasResultViewModel> diasDeudas = new ArrayList<DiasDeudasResultViewModel>();
		
		try {
			
			diasDeudas = diasDeudasJdbcRepository.recuperarDiasDeudas();
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
			
			pagosPorMes = pagosPorMesJdbcRepository.pagosPorMes();
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
		
			pagosPorMesCaja = pagosPorMesCaja1JdbcRepository.pagosPorMesCaja1();
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
			
			pagosPorMesCaja = pagosPorMesCaja2JdbcRepository.pagosPorMesCaja2();
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
			
			pagosPorMesCaja = pagosPorMesCaja3JdbcRepository.pagosPorMesCaja3();
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
		
		List<GananciaPorMesCajaResultViewModel> gananciasPorMesCaja = new ArrayList<GananciaPorMesCajaResultViewModel>();
		
		try {
			
			gananciasPorMesCaja = gananciaPorMesCajaJdbcRepository.ganaciaPorMesCaja();
			if(GenericUtil.isCollectionEmpty(gananciasPorMesCaja) && gananciasPorMesCaja.isEmpty()) {
				return null;
			}
			else {
				return gananciasPorMesCaja;
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
			
			listaConsolidadoInternet = consolidadoInternetJdbcRepository.listarConsolidadoInternet();
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
			
			gananciaPorDiaCaja = gananciaPorDiaCajaJdbcRepository.gananciaPorDiaCaja();
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
				diasDeudas = deudasJdbcRepository.recuperarDiasDeudasParametrizado(request);
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
	public List<ClientePagoResultViewModel> spListarClientesPago(String usuario) {
		
		List<ClientePagoResultViewModel> clientesPagos = new ArrayList<ClientePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				clientesPagos = clientePagoJdbcRepository.spListarClientesPago(usuario);
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
	public List<DetallePagoResultViewModel> spListarDetallePago(String persona) {
		
		List<DetallePagoResultViewModel> Dpago = new ArrayList<DetallePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(persona)) {
				Dpago = detallePagoResultJdbcRepository.spListaDetallePago(persona);
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
				reciboResult = reciboJdbcRepository.spGenerarReciboPago(usuario, codigoPago);
				
				if(GenericUtil.isNotNull(reciboResult)) {
					return reciboResult;
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
	public List<PdfPagoDiaResultViewModel> spListaPdfPagosDia(String usuario) {

		List<PdfPagoDiaResultViewModel> Dpago = new ArrayList<PdfPagoDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				Dpago = pdfPagoDiaJdbcRepository.spListaPlanilla(usuario);
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
	public String spGenerarDescuento(DescuentoHistorialRequest codigo) {

		try {
			
			if(GenericUtil.isNotNull(codigo)) {
				String result = historialDescuentoResquestdbcRepository.spGenerarDescuento(codigo);
				if(StringUtil.hasText(result)) {
					return result;
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
	public DescuentoPagoResultViewModel spRecuperarMesPago(String gpersona) {

		DescuentoPagoResultViewModel clienteDatosAtencion;
		
		try {
			
			if(!GenericUtil.isEmpty(gpersona)) {
				clienteDatosAtencion = pagoListOutdbcRepository.spRecuperarDatosPago(gpersona);
				if(GenericUtil.isNotNull(clienteDatosAtencion)) {
					return clienteDatosAtencion;
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
				mesActualDeuda = mesDeudaActualResultJdbcRepository.spRecuperarMesMonto(documentoPersona);
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
