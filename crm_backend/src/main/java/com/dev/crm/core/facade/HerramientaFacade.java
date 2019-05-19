package com.dev.crm.core.facade;

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.dto.HerramientaRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.ValorHerramientaRequest;

import java.util.List;

public interface HerramientaFacade {

	List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario);
	
	ResponseBaseOperation spInserccionHerramienta(HerramientaRequest inserther);
	
	ResponseBaseOperation spInsercciondetalleHerramienta(DetalleHerramientaRequest inserther);
	
	ValorHerramientaRequest soBusquedaHerramienta(String codiherra);
	
	List<DetalleHerramientaViewModel> soListarPregunta(String usuario);
	
	EditarHerramientaResultViewModel soListarDatosHerra(String codiherr);
	
	ResponseBaseOperation spEditarHerramienta (EditarHerramientaRequest codiherr);
	
	ResponseBaseOperation spEditarPregunta (EditarPreguntaRequest codiherr);
	
}
