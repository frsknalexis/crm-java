package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;
import com.dev.crm.core.dto.MaterialResultViewModel;

public interface MaterialFacade {

	List<MaterialResultViewModel> listarMateriales();
	
	LiquidacionMaterialResultViewModel generarLiquidacionMaterial(Integer codigoServicioInternet);
}
