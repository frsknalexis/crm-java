package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PersonaClienteRequest;

public interface EditarPersonaClienteJdbcRepository {

	String updatePersonaCliente(PersonaClienteRequest request);
}
