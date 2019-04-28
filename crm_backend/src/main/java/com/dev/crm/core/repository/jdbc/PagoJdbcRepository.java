package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;

public interface PagoJdbcRepository {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	String spPagoServicio(PagoRequest pagoRequest);
}
