package com.dev.crm.core.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.dev.crm.core.dto.DetalleCuentaDuoRequest;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.EstadoCuentasResultViewModel;
import com.dev.crm.core.dto.EstadosCuentaResultViewModel;
import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.VentasPorDiaResultViewModel;
import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;
import com.dev.crm.core.enums.ExportReportType;
import com.dev.crm.core.facade.DetalleCuentaFacade;
import com.dev.crm.core.report.ReportService;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/detalleCuenta")
public class DetalleCuentaRestController {

	@Autowired
	@Qualifier("detalleCuentaFacade")
	private DetalleCuentaFacade detalleCuentaFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@Autowired
	@Qualifier("reportService")
	private ReportService reportService;
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@GetMapping("/cuentas")
	public ResponseEntity<List<CuentasPorInstalarResultViewModel>> listarCuentaPorInstalar() {
		
		try {
			
			List<CuentasPorInstalarResultViewModel> cuentasPorInstalar = detalleCuentaFacade.listarCuentaPorInstalar();
			if(GenericUtil.isCollectionEmpty(cuentasPorInstalar)) {
				return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(cuentasPorInstalar, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/estadoCuentas")
	public ResponseEntity<List<EstadoCuentasResultViewModel>> listarEstadoCuentas() {
		
		try {
			
			List<EstadoCuentasResultViewModel> estadoCuentas = detalleCuentaFacade.listarEstadoCuentas();
			if(GenericUtil.isCollectionEmpty(estadoCuentas)) {
				return new ResponseEntity<List<EstadoCuentasResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<EstadoCuentasResultViewModel>>(estadoCuentas, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<EstadoCuentasResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/anular/{codigoDetalleCuenta}")
	public ResponseEntity<ResponseBaseOperation> spUpdateDetalleCuenta(@PathVariable(value = "codigoDetalleCuenta") Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				ResponseBaseOperation response = detalleCuentaFacade.spUpdateDetalleCuenta(codigoDetalleCuenta);
				return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/observacion/{codigoDetalleCuenta}")
	public ResponseEntity<ObservacionResultViewModel> spRecuperarObservacion(@PathVariable(value = "codigoDetalleCuenta") Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				ObservacionResultViewModel observacion = detalleCuentaFacade.spRecuperarObservacion(codigoDetalleCuenta);
				if(GenericUtil.isNotNull(observacion)) {
					return new ResponseEntity<ObservacionResultViewModel>(observacion, HttpStatus.OK);
				}
				else if(GenericUtil.isNull(observacion)) {
					return new ResponseEntity<ObservacionResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ObservacionResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/saveCuentaInternet")
	public ResponseEntity<ResponseBaseOperation> spInsercionCuentaInternet(@Valid @RequestBody DetalleCuentaRequest request) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			request.setCodigoUsuario(usuario);
			ResponseBaseOperation response = detalleCuentaFacade.spInsercionCuentaInternet(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveCuentaCable")
	public ResponseEntity<ResponseBaseOperation> insercionCuentaCable(@Valid @RequestBody DetalleCuentaCableRequest request) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			request.setCodigoUsuario(usuario);
			ResponseBaseOperation response = detalleCuentaFacade.insercionCuentaCable(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/saveCuentaDuo",
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseBaseOperation> insercionCuentaDuo(@Valid @RequestBody DetalleCuentaDuoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				User usuarioLogueado = userDetail.findLoggedInUser();
				String usuario = usuarioLogueado.getUsername();
				request.setCodigoUsuario(usuario);
				ResponseBaseOperation response = detalleCuentaFacade.insercionCuentaDuo(request);
				return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<ResponseBaseOperation>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/envioDatos")
	public ResponseEntity<ResponseBaseOperation> spEnvioDatosInternetServicio(@Valid @RequestBody DatosInternetServicioRequest request) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spEnvioDatosInternetServicio(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/datosMateriales")
	public ResponseEntity<ResponseBaseOperation> spEnvioDatosMaterial(@Valid @RequestBody DatosMaterialesRequest request) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spEnvioDatosMaterial(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/contadorPendientesCable")
	public ResponseEntity<ResponseBaseOperation> spContadorPendientesCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spContadorPendientesCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/contadorPendientesInternet")
	public ResponseEntity<ResponseBaseOperation> spContadorPendientesInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spContadorPendientesInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reprogramacionInstalacionCable")
	public ResponseEntity<ResponseBaseOperation> spReprogramarInstalacionCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spReprogramarInstalacionCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reprogramacionInstalacionInternet")
	public ResponseEntity<ResponseBaseOperation> spReprogramarInstalacionInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spReprogramarInstalacionInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/revalidandoInstalacionCable")
	public ResponseEntity<ResponseBaseOperation> spRevalidandoFechaCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spRevalidandoFechaCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/revalidandoInstalacionInternet")
	public ResponseEntity<ResponseBaseOperation> spRevalidandoFechaInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spRevalidandoFechaInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/reporteCuentasPorDia")
	public ResponseEntity<List<CuentasResultViewModel>> reporteCuentasPorDia(@Valid @RequestBody CuentaRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<CuentasResultViewModel> cuentasPorDia = detalleCuentaFacade.listarCuentasPorDia(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorDia)) {
					return new ResponseEntity<List<CuentasResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<CuentasResultViewModel>>(cuentasPorDia, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentasResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/estados")
	public ResponseEntity<List<EstadosCuentaResultViewModel>> listarEstadosCuentas() {
		
		try {
			
			List<EstadosCuentaResultViewModel> estadosCuentas = detalleCuentaFacade.listarEstadosCuentas();
			if(GenericUtil.isCollectionEmpty(estadosCuentas) && estadosCuentas.isEmpty()) {
				return new ResponseEntity<List<EstadosCuentaResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<EstadosCuentaResultViewModel>>(estadosCuentas, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<EstadosCuentaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/cuentasPorEstado")
	public ResponseEntity<List<CuentaPorEstadoResultViewModel>> listarCuentasPorEstado(@Valid @RequestBody CuentaPorEstadoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<CuentaPorEstadoResultViewModel> cuentasPorEstado = detalleCuentaFacade.listarCuentasPorEstado(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorEstado)) {
					return new ResponseEntity<List<CuentaPorEstadoResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<CuentaPorEstadoResultViewModel>>(cuentasPorEstado, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentaPorEstadoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/ventasPorDia")
	public ResponseEntity<List<VentasPorDiaResultViewModel>> cantidadVentasPorDia() {
		
		try {
			
			List<VentasPorDiaResultViewModel> ventasPorDia = detalleCuentaFacade.cantidadVentasPorDia();
			if(GenericUtil.isCollectionEmpty(ventasPorDia)) {
				return new ResponseEntity<List<VentasPorDiaResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<VentasPorDiaResultViewModel>>(ventasPorDia, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<VentasPorDiaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ventasPorVendedor")
	public ResponseEntity<List<VentasPorVendedorResultViewModel>> cantidadVentasPorVendedor() {
		
		try {
			
			List<VentasPorVendedorResultViewModel> ventasPorVendedor = detalleCuentaFacade.cantidadVentasPorVendedor();
			if(GenericUtil.isCollectionEmpty(ventasPorVendedor)) {
				return new ResponseEntity<List<VentasPorVendedorResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<VentasPorVendedorResultViewModel>>(ventasPorVendedor, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<VentasPorVendedorResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/cuentasPorVendedor")
	public ResponseEntity<List<CuentaPorVendedorResultViewModel>> cuentasPorVendedor(@Valid @RequestBody CuentaPorVendedorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<CuentaPorVendedorResultViewModel> cuentasPorVendedor = detalleCuentaFacade.cuentasPorVendedor(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorVendedor)) {
					return new ResponseEntity<List<CuentaPorVendedorResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<CuentaPorVendedorResultViewModel>>(cuentasPorVendedor, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentaPorVendedorResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/cuentasInstaladas")
	public ResponseEntity<List<CuentasInstaladasResultViewModel>> listarCuentasInstaladasPorFecha(@Valid @RequestBody CuentasInstaladasRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<CuentasInstaladasResultViewModel> cuentasInstaladas = detalleCuentaFacade.listarCuentasInstaladasPorFecha(request);
				if(GenericUtil.isCollectionEmpty(cuentasInstaladas)) {
					return new ResponseEntity<List<CuentasInstaladasResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<CuentasInstaladasResultViewModel>>(cuentasInstaladas, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentasInstaladasResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/reporteCuentasPorRango")
	public ResponseEntity<List<CuentasRangoResultViewModel>> reporteCuentasPorRango(@Valid @RequestBody CuentasRangoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<CuentasRangoResultViewModel> cuentasPorRango = detalleCuentaFacade.listarCuentasPorRango(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorRango)) {
					return new ResponseEntity<List<CuentasRangoResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<CuentasRangoResultViewModel>>(cuentasPorRango, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentasRangoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping(value = "/reporteCuentas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ByteArrayResource> generarReporteCuentasPorDia(@Valid @RequestBody CuentaRequest request) {
		
		try {
			
			List<CuentasResultViewModel> cuentas = detalleCuentaFacade.listarCuentasPorDia(request);
			if(GenericUtil.isCollectionEmpty(cuentas)) {
				return new ResponseEntity<ByteArrayResource>(HttpStatus.NO_CONTENT);
			}
			else {
				
				ByteArrayResource byteArrayResource = reportService.generateReportCuentas(cuentas, ExportReportType.PDF);
				
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Disposition", "attachment; filename=reporteCuentas.pdf");
				
				return ResponseEntity
						.ok()
						.header("Content-Type", "application/pdf; charset=UTF-8")
						.headers(headers)
						.contentType(MediaType.APPLICATION_PDF)
						.body(byteArrayResource);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ByteArrayResource>(HttpStatus.BAD_REQUEST);
		}
	}
}
