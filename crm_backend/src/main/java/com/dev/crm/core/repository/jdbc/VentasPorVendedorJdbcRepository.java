package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;

public interface VentasPorVendedorJdbcRepository {

	List<VentasPorVendedorResultViewModel> cantidadVentasPorVendedor();
}
