package com.dev.crm.core.service;

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.dto.ValorHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.dto.HerramientaRequest;

import java.util.List;

public interface HerramientaService {
	
	List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario); 
	
	String spInserccionHerramienta(HerramientaRequest inserther);
	
	String spInsercciondetalleHerramienta(DetalleHerramientaRequest detalleinserther);
	
	ValorHerramientaRequest soBuscarHerramienta(String codherra);
	
	List<DetalleHerramientaViewModel> soListarPregunta(String usuario);
	
	EditarHerramientaResultViewModel spBuscarDatosHerramienta(String codiherr);
	
	String spEditarHerramienta(EditarHerramientaRequest codiherr);
	
	String spEdiatrPregunta(EditarPreguntaRequest codiherr);
}
