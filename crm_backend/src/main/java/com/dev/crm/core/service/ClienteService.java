package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.model.entity.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	List<Cliente> getActiveListClientes();
	
	List<Cliente> spListarClienteVendedor(String creadoPor);
	
	Cliente getByDocumentoPersonaCliente(String documentoPersonaCliente);
	
	void disabledCliente(String documentoPersonaCliente);
	
	void enabledCliente(String documentoPersonaCliente);
	
	void spInsertarCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);
	
	boolean isClientePresent(String documentoPersonaCliente);
	
	Long totalRegistrosCliente();
	
	ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro);
		
	ClientePagoResultViewModel spBuscarClientePago(String documentoPersona);
}
