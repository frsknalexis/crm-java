package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface PagoFacade {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest);
}
