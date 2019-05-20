package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.CorteInternetResultViewModel;

public interface CorteInternetJdbcRepository {

	List<CorteInternetResultViewModel> spListarCorte();
}
