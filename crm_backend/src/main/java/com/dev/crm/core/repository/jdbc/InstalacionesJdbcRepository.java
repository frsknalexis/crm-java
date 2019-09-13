package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.InstalacionesResultViewModel;

public interface InstalacionesJdbcRepository {

	List<InstalacionesResultViewModel> contadorInstalacionesRealizadas();
}
