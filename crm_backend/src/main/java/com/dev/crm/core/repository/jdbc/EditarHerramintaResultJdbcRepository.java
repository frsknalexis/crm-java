package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.EditarHerramientaResultViewModel;

public interface EditarHerramintaResultJdbcRepository {

	EditarHerramientaResultViewModel spBuscarDatosEditar(String codherra);
}
