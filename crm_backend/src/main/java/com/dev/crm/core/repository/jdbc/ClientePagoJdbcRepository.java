package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;

public interface ClientePagoJdbcRepository {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
}
