package com.dev.crm.core.dao;

import java.util.List;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.Cliente;

public interface ClienteDAO extends BaseDAOHibernate {

	List<Cliente> getActiveListClientes();
	
	List<Cliente> spListarClienteVendedor(String creadoPor);
	
	Cliente getByDocumentoPersonaCliente(String documentoPersonaCliente);
	
	boolean isClientePresent(String documentoPersonaCliente);
	
	void spInsertarCliente(Cliente cliente);
		
	void disabledCliente(Cliente cliente);
	
	void enabledCliente(Cliente cliente);
	
	Long totalRegistrosCliente();
}
