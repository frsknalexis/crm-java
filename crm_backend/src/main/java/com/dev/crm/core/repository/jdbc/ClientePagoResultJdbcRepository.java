package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ClientePagoResultViewModel;

public interface ClientePagoResultJdbcRepository {

	ClientePagoResultViewModel spBuscarClientePago(String documentoPersona);
}
