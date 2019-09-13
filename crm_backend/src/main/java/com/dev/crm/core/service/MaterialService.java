package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;
import com.dev.crm.core.dto.MaterialResultViewModel;

public interface MaterialService {

	List<MaterialResultViewModel> listarMaterial();
	
	LiquidacionMaterialResultViewModel generarLiquidacionMaterial(Integer codigoServicioInternet);
}
