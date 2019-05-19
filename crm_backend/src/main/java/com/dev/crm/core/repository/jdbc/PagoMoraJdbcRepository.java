package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PagoMoraRequest;

public interface PagoMoraJdbcRepository {

	String spPagoMora(PagoMoraRequest pagoMoraRequest);
}
