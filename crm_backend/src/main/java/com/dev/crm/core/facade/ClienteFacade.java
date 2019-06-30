package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.CambioDireccionRequest;
import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.dto.ClienteVendedorResultViewModel;
import com.dev.crm.core.dto.DatosClienteResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PersonaClienteRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface ClienteFacade {

	List<ClienteDTO> findAll();
	
	List<ClienteDTO> getActiveListClientes();
		
	List<ClienteVendedorResultViewModel> listarClientesPorVendedor(String usuario);
	
	List<PdfClienteResultViewModel> spListarPdfCliente(String usuario);
	
	ClienteDTO getByDocumentoPersonaCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation spInsertarCliente(ClienteDTO clienteDTO);
	
	ResponseBaseOperation updateCliente(ClienteDTO clienteDTO);
	
	ResponseBaseOperation disabledCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation enabledCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation totalRegistrosCliente();
	
	ResponseBaseOperation updatePersonaCliente(PersonaClienteRequest request);
	
	ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro);
	
	ClientePagoResultViewModel spBuscarClientePago(String documentoPersona);
	
	DatosClienteResultViewModel recuperarDatosCliente(String documentoPersonaCliente);
	
	ResponseBaseOperation spModificarDomicilio(CambioDireccionRequest request);
}
