package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PersonaRequest;

public interface PersonaRequestJdbcRepository {

	String spInsertarPersona(PersonaRequest valor);
}
