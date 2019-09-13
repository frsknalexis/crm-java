package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.EstadosCuentaResultViewModel;

public interface EstadosCuentaJdbcRepository {

	List<EstadosCuentaResultViewModel> listarEstadosCuentas();
}
