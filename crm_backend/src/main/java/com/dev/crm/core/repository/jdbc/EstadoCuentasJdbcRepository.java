package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.EstadoCuentasResultViewModel;

public interface EstadoCuentasJdbcRepository {

	List<EstadoCuentasResultViewModel> listarEstadoCuentas();
}
