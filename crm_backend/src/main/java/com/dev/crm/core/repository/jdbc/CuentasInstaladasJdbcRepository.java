package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CuentasInstaladasRequest;
import com.dev.crm.core.dto.CuentasInstaladasResultViewModel;

public interface CuentasInstaladasJdbcRepository {

	List<CuentasInstaladasResultViewModel> listarCuentasInstaladasPorFecha(CuentasInstaladasRequest request);
}
