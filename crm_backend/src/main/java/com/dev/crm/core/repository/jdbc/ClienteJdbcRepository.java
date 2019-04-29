package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClienteResultViewModel;

public interface ClienteJdbcRepository {

	ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro);
}
