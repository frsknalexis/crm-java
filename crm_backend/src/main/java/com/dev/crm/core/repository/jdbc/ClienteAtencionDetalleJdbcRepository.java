package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;

public interface ClienteAtencionDetalleJdbcRepository {

	List<ClienteAtencionDetalleResultViewModel> spListarClientesAtencionDetalle(String documentoPersonaCliente);
}
