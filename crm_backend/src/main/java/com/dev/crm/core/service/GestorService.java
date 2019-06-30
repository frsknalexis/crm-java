package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.GestoresResultViewModel;

public interface GestorService {

	List<ClienteGestorResultViewModel> listarClienteGestor();
	
	List<GestoresResultViewModel> listarGestores();
	
	String updateClienteGestor(ClienteGestorRequest request);
}
