package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface DetalleCuentaFacade {

	ResponseBaseOperation spInsercionCuentaInternet(DetalleCuentaRequest request);
	
	ResponseBaseOperation spInsercionCuentaCable(DetalleCuentaDTO detalleCuentaDTO);
	
	ResponseBaseOperation spEnvioDatosInternetServicio(DatosInternetServicioRequest request);
	
	ResponseBaseOperation spEnvioDatosMaterial(DatosMaterialesRequest request);
	
	ResponseBaseOperation spContadorPendientesCable();
	
	ResponseBaseOperation spContadorPendientesInternet();
	
	ResponseBaseOperation spReprogramarInstalacionCable();
	
	ResponseBaseOperation spReprogramarInstalacionInternet();
	
	ResponseBaseOperation spRevalidandoFechaCable();
	
	ResponseBaseOperation spRevalidandoFechaInternet();
	
	List<CuentasPorInstalarResultViewModel> listarCuentaPorInstalar();
	
	ResponseBaseOperation spUpdateDetalleCuenta(Integer codigoDetalleCuenta);
	
	ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta);
}
