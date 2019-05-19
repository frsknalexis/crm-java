package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.TareasResultViewModel;;

public interface TareaResultJdbcRepository {

	List<TareasResultViewModel> spListaTarea(String usuario);
}
