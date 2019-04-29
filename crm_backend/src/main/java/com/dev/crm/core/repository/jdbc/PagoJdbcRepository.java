package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PagoRequest;

public interface PagoJdbcRepository {
	
	String spPagoServicio(PagoRequest pagoRequest);
}
