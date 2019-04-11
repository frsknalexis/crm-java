package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface ClienteFacade {

	List<ClienteDTO> findAll();
	
	List<ClienteDTO> getActiveListClientes();
	
	List<ClienteDTO> spListarClienteVendedor(String creadoPor);
	
	ClienteDTO getByDocumentoPersonaCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation spInsertarCliente(ClienteDTO clienteDTO);
	
	ResponseBaseOperation disabledCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation enabledCliente(String documentoPersonaCliente);
}