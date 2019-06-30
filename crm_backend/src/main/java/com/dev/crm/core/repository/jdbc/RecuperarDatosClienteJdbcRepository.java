package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosClienteResultViewModel;

public interface RecuperarDatosClienteJdbcRepository {

	DatosClienteResultViewModel recuperarDatosCliente(String documentoPersonaCliente);
}
