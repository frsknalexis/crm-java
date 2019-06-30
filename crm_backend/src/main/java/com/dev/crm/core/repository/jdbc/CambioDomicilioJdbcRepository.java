package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.CambioDireccionRequest;

public interface CambioDomicilioJdbcRepository {

	String spModificarDomicilio(CambioDireccionRequest request);
}
