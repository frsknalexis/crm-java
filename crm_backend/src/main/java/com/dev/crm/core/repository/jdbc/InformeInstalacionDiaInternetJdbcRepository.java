package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;

public interface InformeInstalacionDiaInternetJdbcRepository {

	List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia();
}
