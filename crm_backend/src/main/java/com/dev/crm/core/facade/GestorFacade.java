package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;
import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DeudasPorGestorRequest;
import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface GestorFacade {

	List<ClienteGestorResultViewModel> listarClienteGestor();
	
	List<GestoresResultViewModel> listarGestores();
	
	List<DeudasGestorMontoAcumuladoResultViewModel> listarDeudasGestorMontoAcumulado();
	
	List<DeudasGestoresResultViewModel> recuperarDiasDeudasGestoresParametrizado(DiasDeudasRequest request);
	
	List<DeudasPorGestorResultViewModel> listarDeudasPorGestor(DeudasPorGestorRequest request);
	
	ResponseBaseOperation updateClienteGestor(ClienteGestorRequest request);
}
