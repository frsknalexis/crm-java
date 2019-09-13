package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ClienteRequest;

public interface InserccionClienteJdbcRepository {

	void insertarCliente(ClienteRequest request);
}
