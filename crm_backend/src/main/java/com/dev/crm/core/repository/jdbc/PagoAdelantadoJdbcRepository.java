package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PagoAdelantadoRequest;

public interface PagoAdelantadoJdbcRepository {

	String spPagoAdelantado(PagoAdelantadoRequest request);
}
