package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ModuloResultViewModel;

public interface ModuloResultJdbcRepository {

	ModuloResultViewModel spListaModulo(String usuario,String numero);
}
