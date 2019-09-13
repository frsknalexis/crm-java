package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.UsuarioPerfilRequest;

public interface UsuarioPerfilJdbcRepository {

	void actualizarPerfilPassword(UsuarioPerfilRequest request);
}
