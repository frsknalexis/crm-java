package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PerfilUsuarioResultViewModel;

public interface PerfilUsuarioJdbcRepository {

	PerfilUsuarioResultViewModel perfilUsuario(String usuario);
}
