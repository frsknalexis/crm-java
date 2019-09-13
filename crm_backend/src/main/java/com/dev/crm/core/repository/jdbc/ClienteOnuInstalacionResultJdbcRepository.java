package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosOnuInstalacionResultViewModel;;

public interface ClienteOnuInstalacionResultJdbcRepository {

	DatosOnuInstalacionResultViewModel spBuscarDatos(String codigo);
}
