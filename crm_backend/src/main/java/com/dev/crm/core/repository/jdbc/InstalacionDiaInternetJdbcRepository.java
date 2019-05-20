package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;

public interface InstalacionDiaInternetJdbcRepository {

	List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario);
}
