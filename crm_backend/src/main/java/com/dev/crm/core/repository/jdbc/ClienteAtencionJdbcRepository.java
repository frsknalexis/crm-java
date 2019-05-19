package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ClienteAtencionResultViewModel;

public interface ClienteAtencionJdbcRepository {

	List<ClienteAtencionResultViewModel> spListarClientesAtencion();
}
