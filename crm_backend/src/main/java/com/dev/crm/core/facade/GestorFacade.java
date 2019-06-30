package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface GestorFacade {

	List<ClienteGestorResultViewModel> listarClienteGestor();
	
	List<GestoresResultViewModel> listarGestores();
	
	ResponseBaseOperation updateClienteGestor(ClienteGestorRequest request);
}
