package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ActivacionesResultViewModel;

public interface ActivacionesJdbcRepository {

	List<ActivacionesResultViewModel> listarActivacionesInstalacion();
}
