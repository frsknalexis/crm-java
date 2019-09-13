package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentaPorVendedorRequest;
import com.dev.crm.core.dto.CuentaPorVendedorResultViewModel;

public interface CuentaPorVendedorJdbcRepository {

	List<CuentaPorVendedorResultViewModel> cuentasPorVendedor(CuentaPorVendedorRequest request);
}
