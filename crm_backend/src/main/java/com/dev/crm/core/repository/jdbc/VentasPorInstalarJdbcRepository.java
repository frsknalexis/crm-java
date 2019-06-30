package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.VentasPorInstalarResultViewModel;

public interface VentasPorInstalarJdbcRepository {

	List<VentasPorInstalarResultViewModel> listarVentasPorInstalar();
}
