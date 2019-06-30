package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;

public interface CuentasPorInstalarJdbcRepository {

	List<CuentasPorInstalarResultViewModel> listarCuentaPorInstalar();
}
