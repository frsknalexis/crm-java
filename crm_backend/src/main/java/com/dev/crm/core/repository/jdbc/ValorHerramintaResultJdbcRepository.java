package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ValorHerramientaRequest;

public interface ValorHerramintaResultJdbcRepository {

	ValorHerramientaRequest spBuscarHerra(String codherra);
}
