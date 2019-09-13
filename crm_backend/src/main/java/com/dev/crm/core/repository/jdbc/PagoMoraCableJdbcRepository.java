package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PagoMoraCableRequest;

public interface PagoMoraCableJdbcRepository {

	String pagoMoraCable(PagoMoraCableRequest request);
}
