package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.CambioDireccionRequest;
import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteRequest;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.dto.ClienteVendedorResultViewModel;
import com.dev.crm.core.dto.CodigoConsecutivoClienteRequest;
import com.dev.crm.core.dto.CodigoConsecutivoClienteResultViewModel;
import com.dev.crm.core.dto.DatosClienteResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PersonaClienteRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.ClienteFacade;
import com.dev.crm.core.model.entity.Cliente;
import com.dev.crm.core.service.ClienteService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

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
	public List<ClienteVendedorResultViewModel> listarClientesPorVendedor(String usuario) {
		
		List<ClienteVendedorResultViewModel> clientes = new ArrayList<ClienteVendedorResultViewModel>();
		
		try {

			if(StringUtil.hasText(usuario)) {
				clientes = clienteService.listarClientesPorVendedor(usuario);
				if(GenericUtil.isCollectionEmpty(clientes)) {
					return null;
				}
				else {
					return clientes;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PdfClienteResultViewModel> spListarPdfCliente(String usuario) {
		
		List<PdfClienteResultViewModel> pdfClientes = new ArrayList<PdfClienteResultViewModel>();
		
		try {
			
			if(StringUtil.hasText(usuario)) {
				pdfClientes = clienteService.spListarPdfCliente(usuario);
				if(GenericUtil.isCollectionEmpty(pdfClientes)) {
					return null;
				}
				else {
					return pdfClientes;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ClienteDTO getByDocumentoPersonaCliente(String documentoPersonaCliente) {
		
		ClienteDTO clienteDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersonaCliente)) && (documentoPersonaCliente.length() > 0)) {
				Cliente cliente = clienteService.getByDocumentoPersonaCliente(documentoPersonaCliente);
				if(GenericUtil.isNotNull(cliente)) {
					clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
				}
			}
			return clienteDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spInsertarCliente(ClienteDTO clienteDTO) {
		
		try {
			
			Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
			if(GenericUtil.isNotNull(cliente)) {
				
				if(clienteService.isClientePresent(clienteDTO.getDocumentoPersonaCliente())) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.MESSAGE_ERROR, clienteDTO);
				}
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
	public ResponseBaseOperation insertarCliente(ClienteRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				clienteService.insertarCliente(request);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.MESSAGE_CREATED, request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation updateCliente(ClienteDTO clienteDTO) {
		
		try {
			
			Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
			if(GenericUtil.isNotNull(cliente)) {
				
				if(clienteService.isClientePresent(clienteDTO.getDocumentoPersonaCliente())) {
					clienteService.updateCliente(cliente);
					return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, clienteDTO);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation disabledCliente(String documentoPersonaCliente) {
		
		try {
			
			ClienteDTO clienteDTO = null;
			if(GenericUtil.isNotNull(documentoPersonaCliente)) {
				clienteDTO = getByDocumentoPersonaCliente(documentoPersonaCliente);
			}
			if(GenericUtil.isNotNull(clienteDTO)) {
				if(clienteDTO.getEstado().equals(Constantes.HABILITADO)) {
					clienteService.disabledCliente(documentoPersonaCliente);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_DISABLED, clienteDTO);
				}
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
	public ResponseBaseOperation enabledCliente(String documentoPersonaCliente) {
		
		try {
			
			ClienteDTO clienteDTO = null;
			if(GenericUtil.isNotNull(documentoPersonaCliente)) {
				clienteDTO = getByDocumentoPersonaCliente(documentoPersonaCliente);
			}
			if(GenericUtil.isNotNull(clienteDTO)) {
				if(clienteDTO.getEstado().equals(Constantes.INHABILITADO)) {
					clienteService.enabledCliente(documentoPersonaCliente);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_ENABLED, clienteDTO);
				}
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
	public ResponseBaseOperation totalRegistrosCliente() {
		
		try {
			
			Long totalRegistrosCliente = clienteService.totalRegistrosCliente();
			if(totalRegistrosCliente == 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosCliente, totalRegistrosCliente);
			}
			else if(totalRegistrosCliente > 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosCliente, totalRegistrosCliente);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResponseBaseOperation updatePersonaCliente(PersonaClienteRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = clienteService.updatePersonaCliente(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.HECHO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.ERROR)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
					}
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spModificarDomicilio(CambioDireccionRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = clienteService.spModificarDomicilio(request);
				if(StringUtil.hasText(result)) {
					if(StringUtil.eq(result, Constantes.BUENO)) {
						return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
					}
					else if(StringUtil.eq(result, Constantes.ERROR)) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
					}
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro) {
		
		ClienteResultViewModel clienteRVM = null;
		
		try {
			
			if(GenericUtil.isNotNull(filtro)) {
				clienteRVM = clienteService.spBuscarPersonaClienteVendedor(filtro);
			}
			if(GenericUtil.isNotNull(clienteRVM)) {
				return clienteRVM;
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
				clientePago = clienteService.spBuscarClientePago(documentoPersona);
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

	@Override
	public DatosClienteResultViewModel recuperarDatosCliente(String documentoPersonaCliente) {
		
		DatosClienteResultViewModel clienteDatos = null;
		
		try {
			
			if(StringUtil.hasText(documentoPersonaCliente)) {
				clienteDatos = clienteService.recuperarDatosCliente(documentoPersonaCliente);
			}
			if(GenericUtil.isNotNull(clienteDatos)) {
				return clienteDatos;
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
	public CodigoConsecutivoClienteResultViewModel generarCodigoConsecutivoCliente(CodigoConsecutivoClienteRequest request) {
		
		CodigoConsecutivoClienteResultViewModel codigoConsecutivoCliente = null;
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				codigoConsecutivoCliente = clienteService.generarCodigoConsecutivoCliente(request);
			}
			if(GenericUtil.isNull(codigoConsecutivoCliente)) {
				return null;
			}
			return codigoConsecutivoCliente;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
