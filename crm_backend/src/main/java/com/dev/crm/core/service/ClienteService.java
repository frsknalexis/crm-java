package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.CambioDireccionRequest;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.dto.ClienteVendedorResultViewModel;
import com.dev.crm.core.dto.DatosClienteResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PersonaClienteRequest;
import com.dev.crm.core.model.entity.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	List<Cliente> getActiveListClientes();
	
	List<ClienteVendedorResultViewModel> listarClientesPorVendedor(String usuario);
	
	List<PdfClienteResultViewModel> spListarPdfCliente(String usuario);
	
	Cliente getByDocumentoPersonaCliente(String documentoPersonaCliente);
	
	DatosClienteResultViewModel recuperarDatosCliente(String documentoPersonaCliente);
	
	void disabledCliente(String documentoPersonaCliente);
	
	void enabledCliente(String documentoPersonaCliente);
	
	void spInsertarCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);
	
	boolean isClientePresent(String documentoPersonaCliente);
	
	Long totalRegistrosCliente();
	
	ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro);
		
	ClientePagoResultViewModel spBuscarClientePago(String documentoPersona);
	
	String updatePersonaCliente(PersonaClienteRequest request);
	
	String spModificarDomicilio(CambioDireccionRequest request);
}
