package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DetalleCuentaRequest;

public interface DetalleCuentaInternetJdbcRepository {

	String spInsercionCuentaInternet(DetalleCuentaRequest request);
}
