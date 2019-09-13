package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentasRangoRequest;
import com.dev.crm.core.dto.CuentasRangoResultViewModel;

public interface CuentaPorRangoJdbcRepository {

	List<CuentasRangoResultViewModel> listarCuentasPorRango(CuentasRangoRequest request);
}
