package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentaPorEstadoRequest;
import com.dev.crm.core.dto.CuentaPorEstadoResultViewModel;

public interface CuentaPorEstadoJdbcRepository {

	List<CuentaPorEstadoResultViewModel> listarCuentasPorEstado(CuentaPorEstadoRequest request);
}
