package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosMaterialesRequest;

public interface DatosMaterialesJdbcRepository {

	String spEnvioDatosMaterial(DatosMaterialesRequest request);
}
