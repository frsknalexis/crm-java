package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.DetalleCuentaDAO;
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
import com.dev.crm.core.dto.VentasPorDiaResultViewModel;
import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.repository.jdbc.AnularDetalleCuentaJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentaPorDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentaPorEstadoJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentaPorRangoJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentaPorVendedorJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentasInstaladasJdbcRepository;
import com.dev.crm.core.repository.jdbc.CuentasPorInstalarJdbcRepository;
import com.dev.crm.core.repository.jdbc.DatosInternetServicioJdbcRepository;
import com.dev.crm.core.repository.jdbc.DatosMaterialesJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetalleCuentaCableJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetalleCuentaDuoJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetalleCuentaInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.EstadoCuentasJdbcRepository;
import com.dev.crm.core.repository.jdbc.EstadosCuentaJdbcRepository;
import com.dev.crm.core.repository.jdbc.ObservacionCuentaJdbcRepository;
import com.dev.crm.core.repository.jdbc.VentasPorDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.VentasPorVendedorJdbcRepository;
import com.dev.crm.core.service.DetalleCuentaService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("detalleCuentaService")
@Transactional("hibernateTransactionManager")
public class DetalleCuentaServiceImpl implements DetalleCuentaService {

	@Autowired
	@Qualifier("detalleCuentaDAO")
	private DetalleCuentaDAO detalleCuentaDAO;
	
	@Autowired
	@Qualifier("detalleCuentaInternetJdbcRepository")
	private DetalleCuentaInternetJdbcRepository detalleCuentaInternetJdbcRepository;
	
	@Autowired
	@Qualifier("datosInternetServicioJdbcRepository")
	private DatosInternetServicioJdbcRepository datosInternetServicioJdbcRepository;
	
	@Autowired
	@Qualifier("datosMaterialesJdbcRepository")
	private DatosMaterialesJdbcRepository datosMaterialesJdbcRepository;
	
	@Autowired
	@Qualifier("cuentasPorInstalarJdbcRepository")
	private CuentasPorInstalarJdbcRepository cuentasPorInstalarJdbcRepository;
	
	@Autowired
	@Qualifier("anularDetalleCuentaJdbcRepository")
	private AnularDetalleCuentaJdbcRepository anularDetalleCuentaJdbcRepository;
	
	@Autowired
	@Qualifier("observacionCuentaJdbcRepository")
	private ObservacionCuentaJdbcRepository observacionCuentaJdbcRepository;
	
	@Autowired
	@Qualifier("cuentaPorDiaJdbcRepository")
	private CuentaPorDiaJdbcRepository cuentaPorDiaJdbcRepository;
	
	@Autowired
	@Qualifier("cuentaPorRangoJdbcRepository")
	private CuentaPorRangoJdbcRepository cuentaPorRangoJdbcRepository;
	
	@Autowired
	@Qualifier("estadoCuentasJdbcRepository")
	private EstadoCuentasJdbcRepository estadoCuentasJdbcRepository;
	
	@Autowired
	@Qualifier("cuentaPorEstadoJdbcRepository")
	private CuentaPorEstadoJdbcRepository cuentaPorEstadoJdbcRepository;
	
	@Autowired
	@Qualifier("estadosCuentaJdbcRepository")
	private EstadosCuentaJdbcRepository estadosCuentaJdbcRepository;
	
	@Autowired
	@Qualifier("cuentaPorVendedorJdbcRepository")
	private CuentaPorVendedorJdbcRepository cuentaPorVendedorJdbcRepository;
	
	@Autowired
	@Qualifier("ventasPorDiaJdbcRepository")
	private VentasPorDiaJdbcRepository ventasPorDiaJdbcRepository;
	
	@Autowired
	@Qualifier("ventasPorVendedorJdbcRepository")
	private VentasPorVendedorJdbcRepository ventasPorVendedorJdbcRepository;
	
	@Autowired
	@Qualifier("cuentasInstaladasJdbcRepository")
	private CuentasInstaladasJdbcRepository cuentasInstaladasJdbcRepository;
	
	@Autowired
	@Qualifier("detalleCuentaCableJdbcRepository")
	private DetalleCuentaCableJdbcRepository detalleCuentaCableJdbcRepository;
	
	@Autowired
	@Qualifier("detalleCuentaDuoJdbcRepository")
	private DetalleCuentaDuoJdbcRepository detalleCuentaDuoJdbcRepository;
	
	@Override
	public String spInsercionCuentaInternet(DetalleCuentaRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaInternetJdbcRepository.spInsercionCuentaInternet(request);
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
	public String insercionCuentaCable(DetalleCuentaCableRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaCableJdbcRepository.insercionCuentaCable(request);
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
	public String insercionCuentaDuo(DetalleCuentaDuoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaDuoJdbcRepository.insercionCuentaDuo(request);
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
	public String spInsercionCuentaCable(DetalleCuenta dC) {
		
		try {
			
			if(GenericUtil.isNotNull(dC)) {
				String result = detalleCuentaDAO.spInsercionCuentaCable(dC);
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
	public String spEnvioDatosInternetServicio(DatosInternetServicioRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = datosInternetServicioJdbcRepository.spEnvioDatosInternetServicio(request);
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
	public String spEnvioDatosMaterial(DatosMaterialesRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = datosMaterialesJdbcRepository.spEnvioDatosMaterial(request);
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
	public Integer spContadorPendientesCable() {
		
		try {
			
			Integer result = detalleCuentaDAO.spContadorPendientesCable();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer spContadorPendientesInternet() {
		
		try {
			
			Integer result = detalleCuentaDAO.spContadorPendientesInternet();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String spReprogramarInstalacionCable() {
		
		try {
			
			String result = detalleCuentaDAO.spReprogramarInstalacionCable();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spReprogramarInstalacionInternet() {
		
		try {
			
			String result = detalleCuentaDAO.spReprogramarInstalacionInternet();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spRevalidandoFechaCable() {
		
		try {
			
			String result = detalleCuentaDAO.spRevalidandoFechaCable();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spRevalidandoFechaInternet() {
		
		try {
			
			String result = detalleCuentaDAO.spRevalidandoFechaInternet();
			if(StringUtil.hasText(result)) {
				return result;
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
			
			cuentasPorInstalar = cuentasPorInstalarJdbcRepository.listarCuentaPorInstalar();
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
			
			estadoCuentas = estadoCuentasJdbcRepository.listarEstadoCuentas();
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
		
		List<EstadosCuentaResultViewModel> estadosCuenta = new ArrayList<EstadosCuentaResultViewModel>();
		
		try {
			
			estadosCuenta = estadosCuentaJdbcRepository.listarEstadosCuentas();
			if(GenericUtil.isCollectionEmpty(estadosCuenta) && estadosCuenta.isEmpty()) {
				return null;
			}
			else {
				return estadosCuenta;
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
			
			ventasPorDia = ventasPorDiaJdbcRepository.cantidadVentasPorDia();
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
			
			ventasPorVendedor = ventasPorVendedorJdbcRepository.cantidadVentasPorVendedor();
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
				cuentasPorDia = cuentaPorDiaJdbcRepository.listarCuentasPorDia(request);
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
				cuentasPorEstado = cuentaPorEstadoJdbcRepository.listarCuentasPorEstado(request);
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
	public List<CuentasRangoResultViewModel> listarCuentasPorRango(CuentasRangoRequest request) {
		
		List<CuentasRangoResultViewModel> cuentasPorRango = new ArrayList<CuentasRangoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorRango = cuentaPorRangoJdbcRepository.listarCuentasPorRango(request);
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
				cuentasInstaladas = cuentasInstaladasJdbcRepository.listarCuentasInstaladasPorFecha(request);
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
	public List<CuentaPorVendedorResultViewModel> cuentasPorVendedor(CuentaPorVendedorRequest request) {
		
		List<CuentaPorVendedorResultViewModel> cuentasPorVendedor = new ArrayList<CuentaPorVendedorResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				cuentasPorVendedor = cuentaPorVendedorJdbcRepository.cuentasPorVendedor(request);
				if(GenericUtil.isCollectionEmpty(cuentasPorVendedor) && cuentasPorVendedor.isEmpty()) {
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
	public void spUpdateDetalleCuenta(Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				anularDetalleCuentaJdbcRepository.spUpdateDetalleCuenta(codigoDetalleCuenta);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta) {
		
		ObservacionResultViewModel observacion;
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				observacion = observacionCuentaJdbcRepository.spRecuperarObservacion(codigoDetalleCuenta);
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
