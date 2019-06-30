package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.PersonaDAO;
import com.dev.crm.core.dto.PersonaRequest;
import com.dev.crm.core.dto.PersonaRequestE;
import com.dev.crm.core.model.entity.Persona;
import com.dev.crm.core.repository.jdbc.EditarPersonaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.PersonaRequestJdbcRepository;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.service.PersonaService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.DateUtil;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.IpUtil;
import com.dev.crm.core.util.StringUtil;

@Service("personaService")
@Transactional("hibernateTransactionManager")
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	@Qualifier("personaDAO")
	private PersonaDAO personaDAO;
	
	@Autowired
	@Qualifier("PersonaRequestJdbcRepository")
	private PersonaRequestJdbcRepository personaRequestJdbcRepository;
	
	@Autowired
	@Qualifier("EditarPersonaResultJdbcRepository")
	private EditarPersonaResultJdbcRepository editarPersonaResultJdbcRepository;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@Override
	public List<Persona> findAll() {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			personas = personaDAO.findAll(Persona.class);
			if(GenericUtil.isNotNull(personas)) {
				return personas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Persona> getActiveList() {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			personas = personaDAO.getActiveList(Persona.class);
			if(GenericUtil.isNotNull(personas)) {
				return personas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Persona> findPersonasByCreadoPor(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			personas = personaDAO.findPersonasByCreadoPor(creadoPor);
			if(GenericUtil.isNotNull(personas)) {
				return personas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Persona getByDocumentoPersona(String documentoPersona) {
		
		Persona persona = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersona))) {
				persona = personaDAO.getByDocumentoPersona(documentoPersona);
			}
			if(GenericUtil.isNotNull(persona)) {
				return persona;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disabledPersona(String documentoPersona) {
		
		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			Persona persona = null;
			if(!(GenericUtil.isEmpty(documentoPersona))) {
				persona = personaDAO.getByDocumentoPersona(documentoPersona);
				persona.setHabilitado(Constantes.INHABILITADO);
				persona.setFechaModificacion(DateUtil.getCurrentDate());
				persona.setFechaDesactivacion(DateUtil.getCurrentDate());
				persona.setModificadoPor(usuarioLogueado.getUsername());
				persona.setIpUsuario(IpUtil.getCurrentIPAddress());
				persona.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
			}
			personaDAO.disabledPersona(persona);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledPersona(String documentoPersona) {
		
		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			Persona persona = null;
			if(!(GenericUtil.isEmpty(documentoPersona))) {
				persona = personaDAO.getByDocumentoPersona(documentoPersona);
				persona.setHabilitado(Constantes.HABILITADO);
				persona.setFechaModificacion(DateUtil.getCurrentDate());
				persona.setFechaDesactivacion(DateUtil.getCurrentDate());
				persona.setModificadoPor(usuarioLogueado.getUsername());
				persona.setIpUsuario(IpUtil.getCurrentIPAddress());
				persona.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
			}
			personaDAO.enabledPersona(persona);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isPersonaPresent(String documentoPersona) {
		
		if(!(GenericUtil.isEmpty(documentoPersona))) {
			return personaDAO.isPersonaPresent(documentoPersona);
		}
		return false;
	}

	@Override
	public void save(Persona p) {
		
		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			p.setHabilitado(Constantes.HABILITADO);
			p.setIpUsuario(IpUtil.getCurrentIPAddress());
			p.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
			p.setUsuarioSistema(IpUtil.getCurrentUserSystem());
			
			p.setFechaRegistro(DateUtil.getCurrentDate());
			p.setCreadoPor(usuarioLogueado.getUsername());
			personaDAO.save(p);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Persona p) {
		
		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			p.setHabilitado(Constantes.HABILITADO);
			p.setIpUsuario(IpUtil.getCurrentIPAddress());
			p.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
			p.setUsuarioSistema(IpUtil.getCurrentUserSystem());
					
			if(personaDAO.isPersonaPresent(p.getDocumentoPersona())) {
				Persona persona = personaDAO.getByDocumentoPersona(p.getDocumentoPersona());
				persona.setUbigeo(p.getUbigeo());
				persona.setNombrePersona(p.getNombrePersona());
				persona.setApellidoPaternoPersona(p.getApellidoPaternoPersona());
				persona.setApellidoMaternoPersona(p.getApellidoMaternoPersona());
				persona.setDireccionReniecPersona(p.getDireccionReniecPersona());
				persona.setDireccionActualPersona(p.getDireccionActualPersona());
				persona.setReferenciaPersona(p.getReferenciaPersona());
				persona.setTelefonoUnoPersona(p.getTelefonoUnoPersona());
				persona.setTelefonoDosPersona(p.getTelefonoDosPersona());
				persona.setTelefonoTresPersona(p.getTelefonoTresPersona());
				
				persona.setFechaModificacion(DateUtil.getCurrentDate());
				persona.setModificadoPor(usuarioLogueado.getUsername());
				personaDAO.update(persona);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Persona> spListarPersonasNoClienteByCreadoPor(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			personas = personaDAO.spListarPersonasNoClienteByCreadoPor(creadoPor);
			if(GenericUtil.isNotNull(personas)) {
				return personas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Persona> spListaPersonaNoEmpleado(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			personas = personaDAO.spListaPersonaNoEmpleado(creadoPor);
			if(GenericUtil.isNotNull(personas)) {
				return personas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long obtenerTotalRegistrosPersona() {
		
		try {
			
			Long totalRegistrosPersona = personaDAO.totalRegistrosPersona();
			return totalRegistrosPersona;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long obtenerTotalRegistrosPersonas() {
		
		try {
			
			Long totalRegistrosPersonas = personaDAO.totalRegistrosPersonas();
			return totalRegistrosPersonas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String spInsertarPersona(PersonaRequest valor) {

		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			if(GenericUtil.isNotNull(valor)) {
				
				valor.setIpmaquina(IpUtil.getCurrentIPAddress());
				valor.setUsuariomaquina(IpUtil.getCurrentUserMachine());
				valor.setUsuariosistema(IpUtil.getCurrentUserSystem());
				
				valor.setCreadopor(usuarioLogueado.getUsername());
				String result = personaRequestJdbcRepository.spInsertarPersona(valor);
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
	public String spEditarPersona(PersonaRequestE valor) {

		User usuarioLogueado = userDetail.findLoggedInUser();
		
		try {
			
			if(GenericUtil.isNotNull(valor)) {
				
				valor.setIpMaquina(IpUtil.getCurrentIPAddress());
				valor.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
				valor.setUsuarioSistema(IpUtil.getCurrentUserSystem());
				
				valor.setModificadopor(usuarioLogueado.getUsername());
				String result = editarPersonaResultJdbcRepository.spEditarPersona(valor);
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
