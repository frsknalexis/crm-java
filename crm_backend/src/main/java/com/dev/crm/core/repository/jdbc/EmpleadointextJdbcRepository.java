package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.EmpleadoEXTINTResultViewModel;

public interface EmpleadointextJdbcRepository {

	List<EmpleadoEXTINTResultViewModel> spListarEmpleadoDetalleGeneral();
}
