package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DetalleCuentaDuoRequest;

public interface DetalleCuentaDuoJdbcRepository {

	String insercionCuentaDuo(DetalleCuentaDuoRequest request);
}
