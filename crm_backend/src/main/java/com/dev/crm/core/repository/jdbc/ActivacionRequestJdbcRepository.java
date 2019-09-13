package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ActivacionRequest;

public interface ActivacionRequestJdbcRepository {

	String spInsertActivacion(ActivacionRequest codigo);
}
