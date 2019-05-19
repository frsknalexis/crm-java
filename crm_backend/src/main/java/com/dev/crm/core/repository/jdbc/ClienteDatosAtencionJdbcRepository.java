package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ClienteDatosAtencionResultViewModel;

public interface ClienteDatosAtencionJdbcRepository {

	ClienteDatosAtencionResultViewModel spListarDatosGeneralesCliente(String documentoPersonaCliente);
}
