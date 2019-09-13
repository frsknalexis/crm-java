package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DetalleCuentaCableRequest;

public interface DetalleCuentaCableJdbcRepository {

	String insercionCuentaCable(DetalleCuentaCableRequest request);
}
