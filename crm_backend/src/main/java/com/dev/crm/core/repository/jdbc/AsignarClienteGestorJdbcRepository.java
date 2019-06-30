package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ClienteGestorRequest;

public interface AsignarClienteGestorJdbcRepository {

	String updateClienteGestor(ClienteGestorRequest request);
}
