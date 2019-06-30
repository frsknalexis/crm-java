package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ClienteVendedorResultViewModel;

public interface ClienteVendedorJdbcRepository {

	List<ClienteVendedorResultViewModel> spListarClienteVendedor(String usuario);
}
