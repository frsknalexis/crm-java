package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;

public interface InstalacionesPorTecnicoJdbcRepository {

	List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico();
}
