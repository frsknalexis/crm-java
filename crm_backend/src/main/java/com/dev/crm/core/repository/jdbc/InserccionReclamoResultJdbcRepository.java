package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.InsertarReclamoRequest;;

public interface InserccionReclamoResultJdbcRepository {

	String spInsertarReclamo(InsertarReclamoRequest codirecl);
}
