package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.ClienteDAO;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.model.entity.Cliente;
import com.dev.crm.core.repository.jdbc.ClienteJdbcRepository;
import com.dev.crm.core.repository.jdbc.ClientePagoResultJdbcRepository;
import com.dev.crm.core.service.ClienteService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Service("clienteService")
@Transactional("hibernateTransactionManager")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	@Qualifier("clienteDAO")
	private ClienteDAO clienteDAO;
	
	@Autowired
	@Qualifier("clienteJdbcRepository")
	private ClienteJdbcRepository clienteJdbcRepository;
	
	@Autowired
	@Qualifier("clientePagoResultJdbcRepository")
	private ClientePagoResultJdbcRepository clientePagoResultJdbcRepository;
	
	@Override
	public List<Cliente> findAll() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			clientes = clienteDAO.findAll(Cliente.class);
			if(GenericUtil.isNotNull(clientes)) {
				return clientes;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> getActiveListClientes() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			clientes = clienteDAO.getActiveListClientes();
			if(GenericUtil.isNotNull(clientes)) {
				return clientes;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> spListarClienteVendedor(String creadoPor) {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			clientes = clienteDAO.spListarClienteVendedor(creadoPor);
			if(GenericUtil.isNotNull(clientes)) {
				return clientes;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cliente getByDocumentoPersonaCliente(String documentoPersonaCliente) {
		
		Cliente cliente = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersonaCliente))) {
				cliente = clienteDAO.getByDocumentoPersonaCliente(documentoPersonaCliente);
			}
			if(GenericUtil.isNotNull(cliente)) {
				return cliente;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disabledCliente(String documentoPersonaCliente) {
		
		try {
			
			Cliente cliente = null;
			if(GenericUtil.isNotNull(documentoPersonaCliente)) {
				cliente = clienteDAO.getByDocumentoPersonaCliente(documentoPersonaCliente);
			}
			clienteDAO.disabledCliente(cliente);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledCliente(String documentoPersonaCliente) {
		
		try {
		
			Cliente cliente = null;
			if(GenericUtil.isNotNull(documentoPersonaCliente)) {
				cliente = clienteDAO.getByDocumentoPersonaCliente(documentoPersonaCliente);
			}
			clienteDAO.enabledCliente(cliente);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spInsertarCliente(Cliente c) {
		
		try {
			
			c.setEstado(Constantes.HABILITADO);
			clienteDAO.spInsertarCliente(c);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isClientePresent(String documentoPersonaCliente) {
		
		if(!(GenericUtil.isEmpty(documentoPersonaCliente))) {
			return clienteDAO.isClientePresent(documentoPersonaCliente);
		}
		return false;
	}

	@Override
	public void updateCliente(Cliente c) {
		
		try {
			
			c.setEstado(Constantes.HABILITADO);
			
			if(clienteDAO.isClientePresent(c.getDocumentoPersonaCliente())) {
				Cliente cliente = clienteDAO.getByDocumentoPersonaCliente(c.getDocumentoPersonaCliente());
				cliente.setCodigoCliente(c.getCodigoCliente());
				cliente.setConsecutivoCliente(c.getConsecutivoCliente());
				cliente.setNombreComercialCliente(c.getNombreComercialCliente());
				cliente.setCorreoCliente(c.getCorreoCliente());
				cliente.setFacebookCliente(c.getFacebookCliente());
				cliente.setSexo(c.getSexo());
				clienteDAO.update(cliente);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Long totalRegistrosCliente() {
		
		try {
			
			Long totalRegistrosCliente = clienteDAO.totalRegistrosCliente();
			return totalRegistrosCliente;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro) {
		
		ClienteResultViewModel cliente = null;
		
		try {
			
			if(GenericUtil.isNotNull(filtro)) {
				cliente = clienteJdbcRepository.spBuscarPersonaClienteVendedor(filtro);
			}
			if(GenericUtil.isNotNull(cliente)) {
				return cliente;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ClientePagoResultViewModel spBuscarClientePago(String documentoPersona) {
		
		ClientePagoResultViewModel clientePago = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersona)) {
				clientePago = clientePagoResultJdbcRepository.spBuscarClientePago(documentoPersona);
			}
			if(GenericUtil.isNotNull(clientePago)) {
				return clientePago;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
