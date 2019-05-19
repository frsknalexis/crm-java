package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface PagoFacade {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
	
	ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest);
	
	ResponseBaseOperation spPagoMora(PagoMoraRequest pagoMora);
}
