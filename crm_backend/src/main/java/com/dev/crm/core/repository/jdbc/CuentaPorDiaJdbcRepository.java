package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentaRequest;
import com.dev.crm.core.dto.CuentasResultViewModel;

public interface CuentaPorDiaJdbcRepository {

	List<CuentasResultViewModel> listarCuentasPorDia(CuentaRequest request);
}
