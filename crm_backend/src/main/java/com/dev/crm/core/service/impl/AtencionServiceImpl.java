package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionResultViewModel;
import com.dev.crm.core.dto.ClienteDatosAtencionResultViewModel;
import com.dev.crm.core.dto.DatosOnusResultViewModel;
import com.dev.crm.core.dto.InsertarReclamoRequest;
import com.dev.crm.core.dto.InsertarTecnicTareaRequest;
import com.dev.crm.core.dto.MensajeNotiResultViewModel;
import com.dev.crm.core.dto.ObtenernumerotareaRequest;
import com.dev.crm.core.dto.ReclamoResultViewModel;
import com.dev.crm.core.dto.TareasResultViewModel;
import com.dev.crm.core.repository.jdbc.ClienteAtencionDetalleJdbcRepository;
import com.dev.crm.core.repository.jdbc.ClienteAtencionJdbcRepository;
import com.dev.crm.core.repository.jdbc.ClienteDatosAtencionJdbcRepository;
import com.dev.crm.core.repository.jdbc.DatosOnusJdbcRepository;
import com.dev.crm.core.repository.jdbc.EditarTecnicoInstalacionRequestJdbcRepository;
import com.dev.crm.core.repository.jdbc.EditarTecnicoReclamoRequesJdbcRepository;
import com.dev.crm.core.repository.jdbc.InserccionReclamoResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.MensajeNotiResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.NotiTareaJdbcRepository;
import com.dev.crm.core.repository.jdbc.TareaRequestJdbcRepository;
import com.dev.crm.core.repository.jdbc.TareaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.TecnicoAsignadoJdbcRepository;
import com.dev.crm.core.repository.jdbc.ViewReclamoJdbcRepository;
import com.dev.crm.core.service.AtencionService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("atencionService")
@Transactional("hibernateTransactionManager")
public class AtencionServiceImpl implements AtencionService {

	@Autowired
	@Qualifier("clienteAtencionJdbc")
	private ClienteAtencionJdbcRepository clienteAtencionJdbcRepository;
	
	@Autowired
	@Qualifier("clienteDatosAtencionJdbcRepository")
	private ClienteDatosAtencionJdbcRepository clienteDatosAtencionJdbcRepository;
	
	@Autowired
	@Qualifier("TareaResultJdbcRepository")
	private TareaResultJdbcRepository tareaResultJdbcRepository;
	
	@Autowired
	@Qualifier("clienteAtencionDetalleJdbcRepository")
	private ClienteAtencionDetalleJdbcRepository clienteAtencionDetalleJdbcRepository;
	
	@Autowired
	@Qualifier("InserccionReclamoResultJdbcRepository")
	private InserccionReclamoResultJdbcRepository InserccionreclamoResultJdbcRepository;

	@Autowired
	@Qualifier("TecnicoAsignadoJdbcRepository")
	private TecnicoAsignadoJdbcRepository tecnicoAsignadoJdbcRepository;
	
	@Autowired
	@Qualifier("ViewReclamoJdbcRepository")
	private ViewReclamoJdbcRepository viewReclamoJdbcRepository;
	
	@Autowired
	@Qualifier("EditarTecnicoReclamoRequesJdbcRepository")
	private EditarTecnicoReclamoRequesJdbcRepository editarTecnicoReclamoRequesJdbcRepository;
	
	@Autowired
	@Qualifier("EditarTecnicoInstalacionRequestJdbcRepository")
	private EditarTecnicoInstalacionRequestJdbcRepository editarTecnicoInstalacionRequestJdbcRepository;
	
	@Autowired
	@Qualifier("NotiTareaJdbcRepository")
	private NotiTareaJdbcRepository notiTareaJdbcRepository;
	
	@Autowired
	@Qualifier("MensajeNotiResultJdbcRepository")
	private MensajeNotiResultJdbcRepository mensajeNotiResultJdbcRepository;
	
	@Autowired
	@Qualifier("TareaRequestJdbcRepository")
	private TareaRequestJdbcRepository tareaRequestJdbcRepository;
	
	@Autowired
	@Qualifier("DatosOnusJdbcRepository")
	private DatosOnusJdbcRepository datosOnusJdbcRepository;
	
	
	@Override
	public List<ClienteAtencionResultViewModel> spListarClientesAtencion() {
		
		List<ClienteAtencionResultViewModel> clientesAtencion = new ArrayList<ClienteAtencionResultViewModel>();
		
		try {
			
			clientesAtencion = clienteAtencionJdbcRepository.spListarClientesAtencion();
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
			
			if(StringUtil.hasText(documentoPersonaCliente)) {
				clientesAtencionDetalle = clienteAtencionDetalleJdbcRepository.spListarClientesAtencionDetalle(documentoPersonaCliente);
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
				clienteDatosAtencion = clienteDatosAtencionJdbcRepository.spListarDatosGeneralesCliente(documentoPersonaCliente);
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
	public String InserrcionReclamo(InsertarReclamoRequest codirecl) {
		
		try {
			
			if(GenericUtil.isNotNull(codirecl)) {
				String result = InserccionreclamoResultJdbcRepository.spInsertarReclamo(codirecl);
				if(StringUtil.hasText(result)) {
					return result;
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
	public List<AsignarTecnicoComboResultViewModel> spListarcOmboTecnico(String persona){
		
		List<AsignarTecnicoComboResultViewModel> tencicoasig = new ArrayList<AsignarTecnicoComboResultViewModel>();
		
		try {
			
			tencicoasig = tecnicoAsignadoJdbcRepository.spComboTecnico(persona);
			if(!GenericUtil.isEmpty(tencicoasig)) {
				return tencicoasig;
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
		
		List<ReclamoResultViewModel> tencicoasig = new ArrayList<ReclamoResultViewModel>();
		
		try {
			
			tencicoasig = viewReclamoJdbcRepository.spListaReclamo(usuario);
			if(!GenericUtil.isEmpty(tencicoasig)) {
				return tencicoasig;
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
	public String speditarreclamotecnico(InsertarTecnicTareaRequest codidocu) {

		try {
			
			if(GenericUtil.isNotNull(codidocu)) {
				String result = editarTecnicoReclamoRequesJdbcRepository.speditrecltec(codidocu);
				if(StringUtil.hasText(result)) {
					return result;
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
	public String ObtenerTarea(ObtenernumerotareaRequest cantidad) {

		try {
			
			if(GenericUtil.isNotNull(cantidad)) {
				String result = notiTareaJdbcRepository.spObtenercantidadtarea(cantidad);
				if(StringUtil.hasText(result)) {
					return result;
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
	public MensajeNotiResultViewModel sprecuperardatosmensaje(String usuario) {

		MensajeNotiResultViewModel cusuario = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				cusuario = mensajeNotiResultJdbcRepository.sorecuperdaddatos(usuario);
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
	public List<TareasResultViewModel> spListarTarea(String usuario){
		
		List<TareasResultViewModel> tarea = new ArrayList<TareasResultViewModel>();
		
		try {
			
			tarea = tareaResultJdbcRepository.spListaTarea(usuario);
			if(!GenericUtil.isEmpty(tarea)) {
				return tarea;
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
	public String speditartarea(String valor) {
		
		try {
			
			if(GenericUtil.isNotNull(valor)) {
				String result = tareaRequestJdbcRepository.spEditarTarea(valor);
				if(StringUtil.hasText(result)) {
					return result;
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
	public DatosOnusResultViewModel spRecuperarDatos(String sn, String mac) {

		DatosOnusResultViewModel cDaOn;
		
		try {
			
			if(!GenericUtil.isEmpty(sn) && !GenericUtil.isEmpty(mac)) {
				cDaOn = datosOnusJdbcRepository.spRecuperarDatos(sn, mac);
				if(GenericUtil.isNotNull(cDaOn)) {
					return cDaOn;
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
	public String speditarinstalaciontecnico(InsertarTecnicTareaRequest codidocu) {

		try {
			
			if(GenericUtil.isNotNull(codidocu)) {
				String result = editarTecnicoInstalacionRequestJdbcRepository.speditinsttec(codidocu);
				if(StringUtil.hasText(result)) {
					return result;
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
