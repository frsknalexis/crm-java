package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.EmpleadoDAO;
import com.dev.crm.core.dto.EmpleadoResultViewModel;
import com.dev.crm.core.model.entity.Empleado;
import com.dev.crm.core.repository.jdbc.EmpleadoJdbcRepository;
import com.dev.crm.core.service.EmpleadoService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Service("empleadoService")
@Transactional("hibernateTransactionManager")
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	@Qualifier("empleadoDAO")
	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	@Qualifier("empleadoJdbcRepository")
	private EmpleadoJdbcRepository empleadoJdbcRepository;
	
	@Override
	public void spInsercionEmpleado(Empleado e) {
		
		try {
			
			e.setEstado(Constantes.HABILITADO);
			empleadoDAO.spInsercionEmpleado(e);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void spActualizarEmpleado(Empleado e) {
		
		try {
			
			if(empleadoDAO.isEmpleadoPresent(e.getDocumentoPersonaEmpleado())) {
				Empleado empleado = empleadoDAO.getByDocumentoPersonaEmpleado(e.getDocumentoPersonaEmpleado());
				empleado.setDocumentoPersonaEmpleado(e.getDocumentoPersonaEmpleado());
				empleado.setCargo(e.getCargo());
				empleadoDAO.spActualizarEmpleado(empleado);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Empleado> getActiveListEmpleados() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			empleados = empleadoDAO.getActiveListEmpleados();
			if(GenericUtil.isNotNull(empleados)) {
				return empleados;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isEmpleadoPresent(String documentoPersonaEmpleado) {
		
		if(GenericUtil.isNotEmpty(documentoPersonaEmpleado)) {
			return empleadoDAO.isEmpleadoPresent(documentoPersonaEmpleado);
		}
		return false;
	}

	@Override
	public Empleado getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		
		Empleado empleado = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaEmpleado)) {
				empleado = empleadoDAO.getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
			}
			if(GenericUtil.isNotNull(empleado)) {
				return empleado;
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
	public List<Empleado> findAll() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			empleados = empleadoDAO.findAll(Empleado.class);
			if(GenericUtil.isNotEmpty(empleados)) {
				return empleados;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disabledEmpleado(String documentoPersonaEmpleado) {
		
		try {
			
			Empleado empleado = null;
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				empleado = empleadoDAO.getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
			}
			empleadoDAO.disabledEmpleado(empleado);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledEmpleado(String documentoPersonaEmpleado) {
		
		try {
			
			Empleado empleado = null;
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				empleado = empleadoDAO.getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
			}
			empleadoDAO.enabledEmpleado(empleado);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Empleado> spListarPersonaEmpleado(String creadoPor) {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			empleados = empleadoDAO.spListarPersonaEmpleado(creadoPor);
			if(GenericUtil.isNotNull(empleados)) {
				return empleados;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long totalRegistrosEmpleado() {
		
		try {
			
			Long totalRegistrosEmpleado = empleadoDAO.totalRegistrosEmpleado();
			return totalRegistrosEmpleado;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpleadoResultViewModel> spListarEmpleadosIntExt() {
		
		List<EmpleadoResultViewModel> empleados = new ArrayList<EmpleadoResultViewModel>();
		
		try {
			
			empleados = empleadoJdbcRepository.spListarEmpleadosIntExt();
			if(GenericUtil.isNotNull(empleados)) {
				return empleados;
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
