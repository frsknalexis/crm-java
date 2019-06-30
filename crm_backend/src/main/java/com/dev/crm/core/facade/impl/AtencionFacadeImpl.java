package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionResultViewModel;
import com.dev.crm.core.dto.ClienteDatosAtencionResultViewModel;
import com.dev.crm.core.dto.DatosOnuRequest;
import com.dev.crm.core.dto.DatosOnusResultViewModel;
import com.dev.crm.core.dto.InsertarReclamoRequest;
import com.dev.crm.core.dto.InsertarTecnicTareaRequest;
import com.dev.crm.core.dto.MensajeNotiResultViewModel;
import com.dev.crm.core.dto.ObtenernumerotareaRequest;
import com.dev.crm.core.dto.ReclamoResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.TareasResultViewModel;
import com.dev.crm.core.facade.AtencionFacade;
import com.dev.crm.core.service.AtencionService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("atencionFacade")
public class AtencionFacadeImpl implements AtencionFacade {

	@Autowired
	@Qualifier("atencionService")
	private AtencionService atencionService;
	
	@Override
	public List<ClienteAtencionResultViewModel> spListarClientesAtencion() {
		
		List<ClienteAtencionResultViewModel> clientesAtencion = new  ArrayList<ClienteAtencionResultViewModel>();
		
		try {
			
			clientesAtencion = atencionService.spListarClientesAtencion();
			if(!GenericUtil.isEmpty(clientesAtencion)) {
				return clientesAtencion;
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
	public List<ClienteAtencionDetalleResultViewModel> spListarClientesAtencionDetalle(String documentoPersonaCliente) {
		
		List<ClienteAtencionDetalleResultViewModel> clientesAtencionDetalle = new ArrayList<ClienteAtencionDetalleResultViewModel>();
		
		try {
			
			if(!GenericUtil.isEmpty(documentoPersonaCliente)) {
				clientesAtencionDetalle = atencionService.spListarClientesAtencionDetalle(documentoPersonaCliente);
				if(!GenericUtil.isEmpty(clientesAtencionDetalle)) {
					return clientesAtencionDetalle;
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
	public ClienteDatosAtencionResultViewModel spListarDatosGeneralesCliente(String documentoPersonaCliente) {
		
		ClienteDatosAtencionResultViewModel clienteDatosAtencion;
		
		try {
			
			if(!GenericUtil.isEmpty(documentoPersonaCliente)) {
				clienteDatosAtencion = atencionService.spListarDatosGeneralesCliente(documentoPersonaCliente);
				if(GenericUtil.isNotNull(clienteDatosAtencion)) {
					return clienteDatosAtencion;
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
	public DatosOnusResultViewModel spRecuperarDatosOnu(DatosOnuRequest request) {
		
		DatosOnusResultViewModel datosOnu;
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				datosOnu = atencionService.spRecuperarDatosOnu(request);
				if(GenericUtil.isNotNull(datosOnu)) {
					return datosOnu;
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
	public ResponseBaseOperation spInsertarReclamo(InsertarReclamoRequest codirecl) {

		try {
			
			if(GenericUtil.isNotNull(codirecl)) {
				String result = atencionService.InserrcionReclamo(codirecl);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codirecl);
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
	public List<AsignarTecnicoComboResultViewModel> spListarComboTecnico(String persona) {
		
		List<AsignarTecnicoComboResultViewModel> tecnicoasig = new  ArrayList<AsignarTecnicoComboResultViewModel>();
		
		try {
			
			tecnicoasig = atencionService.spListarcOmboTecnico(persona);
			if(!GenericUtil.isEmpty(tecnicoasig)) {
				return tecnicoasig;
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
	public List<ReclamoResultViewModel> spListarReclamo(String usuario) {

		List<ReclamoResultViewModel> tecnicoasig = new  ArrayList<ReclamoResultViewModel>();
		
		try {
			
			tecnicoasig = atencionService.spListarReclamo(usuario);
			if(!GenericUtil.isEmpty(tecnicoasig)) {
				return tecnicoasig;
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
	public ResponseBaseOperation speditarreclmaotecnico(InsertarTecnicTareaRequest codidocu) {

		try {
			
			if(GenericUtil.isNotNull(codidocu)) {
				String result = atencionService.speditarreclamotecnico(codidocu);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codidocu);
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
	public ResponseBaseOperation spObtnerCantidadTarea(ObtenernumerotareaRequest cantidad) {
		
		try {
			
			if(GenericUtil.isNotNull(cantidad)) {
				String result = atencionService.ObtenerTarea(cantidad);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, cantidad);
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
	public MensajeNotiResultViewModel spbuscardatosmensaje(String usuario) {

		MensajeNotiResultViewModel cusuario = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				cusuario = atencionService.sprecuperardatosmensaje(usuario);
			}
			if(GenericUtil.isNotNull(cusuario)) {
				return cusuario;
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
	public List<TareasResultViewModel> spListarTareas(String usuario) {
		
		List<TareasResultViewModel> clientesAtencion = new  ArrayList<TareasResultViewModel>();
		
		try {
			
			clientesAtencion = atencionService.spListarTarea(usuario);
			if(!GenericUtil.isEmpty(clientesAtencion)) {
				return clientesAtencion;
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
	public ResponseBaseOperation speditartarea(String valor) {

		try {
			
			if(GenericUtil.isNotNull(valor)) {
				String result = atencionService.speditartarea(valor);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, valor);
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
	public ResponseBaseOperation speditarinstmaotecnico(InsertarTecnicTareaRequest codidocu) {

		try {
			
			if(GenericUtil.isNotNull(codidocu)) {
				String result = atencionService.speditarinstalaciontecnico(codidocu);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codidocu);
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
}
