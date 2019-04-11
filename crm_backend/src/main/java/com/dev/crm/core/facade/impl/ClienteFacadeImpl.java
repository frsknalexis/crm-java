package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.ClienteFacade;
import com.dev.crm.core.model.entity.Cliente;
import com.dev.crm.core.service.ClienteService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Component("clienteFacade")
public class ClienteFacadeImpl implements ClienteFacade {

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ClienteDTO> findAll() {
		
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		
		try {
			
			List<Cliente> clientes = clienteService.findAll();
			clientes.stream().forEach(c -> {
				clientesDTO.add(modelMapper.map(c, ClienteDTO.class));
			});
			return clientesDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClienteDTO> getActiveListClientes() {
		
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		
		try {
			
			List<Cliente> clientes = clienteService.getActiveListClientes();
			for(Cliente c : clientes) {
				ClienteDTO clienteDTO = modelMapper.map(c, ClienteDTO.class);
				clientesDTO.add(clienteDTO);
			}
			return clientesDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ClienteDTO> spListarClienteVendedor(String creadoPor) {
		
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		
		try {
			
			List<Cliente> clientes = clienteService.spListarClienteVendedor(creadoPor);
			clientes.stream().forEach(c -> {
				clientesDTO.add(modelMapper.map(c, ClienteDTO.class));
			});
			return clientesDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ClienteDTO getByDocumentoPersonaCliente(String documentoPersonaCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBaseOperation spInsertarCliente(ClienteDTO clienteDTO) {
		
		try {
			
			Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
			if(GenericUtil.isNotNull(cliente)) {
				clienteService.spInsertarCliente(cliente);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.MESSAGE_CREATED, clienteDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation disabledCliente(String documentoPersonaCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBaseOperation enabledCliente(String documentoPersonaCliente) {
		// TODO Auto-generated method stub
		return null;
	}
}
