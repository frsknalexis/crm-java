package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ConsolidadoInternetResultViewModel;

public interface ConsolidadoInternetJdbcRepository {

	List<ConsolidadoInternetResultViewModel> listarConsolidadoInternet();
}
