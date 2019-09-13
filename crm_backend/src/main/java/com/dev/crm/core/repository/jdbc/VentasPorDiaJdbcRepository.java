package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.VentasPorDiaResultViewModel;

public interface VentasPorDiaJdbcRepository {

	List<VentasPorDiaResultViewModel> cantidadVentasPorDia();
}
