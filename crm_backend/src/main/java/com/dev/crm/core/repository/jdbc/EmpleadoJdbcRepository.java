package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.EmpleadoResultViewModel;;

public interface EmpleadoJdbcRepository {

	List<EmpleadoResultViewModel> spListarEmpleadosIntExt();
}
