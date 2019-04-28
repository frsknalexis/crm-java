package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;

public interface PagoService {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	String spPagoServicio(PagoRequest pagoRequest);
}
