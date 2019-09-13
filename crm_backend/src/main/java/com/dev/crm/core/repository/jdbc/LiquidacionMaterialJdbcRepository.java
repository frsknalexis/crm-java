package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;

public interface LiquidacionMaterialJdbcRepository {

	LiquidacionMaterialResultViewModel generarLiquidacionMaterial(Integer codigoServicioInternet);
}
