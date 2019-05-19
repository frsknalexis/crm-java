package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.EmpleadoDTO;
import com.dev.crm.core.dto.EmpleadoEXTINTResultViewModel;
import com.dev.crm.core.dto.EmpleadoResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.EmpleadoFacade;
import com.dev.crm.core.model.entity.Empleado;
import com.dev.crm.core.service.EmpleadoService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("empleadoFacade")
public class EmpleadoFacadeImpl implements EmpleadoFacade {

	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService empleadoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ResponseBaseOperation spInsercionEmpleado(EmpleadoDTO empleadoDTO) {
		
		try {
			
			Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
			if(GenericUtil.isNotNull(empleado)) {
				
				if(empleadoService.isEmpleadoPresent(empleadoDTO.getDocumentoPersonaEmpleado())) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.MESSAGE_ERROR, empleadoDTO);
				}
				empleadoService.spInsercionEmpleado(empleado);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.MESSAGE_CREATED, empleadoDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spActualizarEmpleado(EmpleadoDTO empleadoDTO) {
		
		try {
			
			Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
			if(GenericUtil.isNotNull(empleado)) {
				if(empleadoService.isEmpleadoPresent(empleadoDTO.getDocumentoPersonaEmpleado())) {
					empleadoService.spActualizarEmpleado(empleado);
					return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, empleadoDTO);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpleadoDTO> getActiveListEmpleados() {
		
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		
		try {
			
			List<Empleado> empleados = empleadoService.getActiveListEmpleados();
			empleados.stream().forEach(e -> {
				empleadosDTO.add(modelMapper.map(e, EmpleadoDTO.class));
			});
			return empleadosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<EmpleadoDTO> spListarPersonaEmpleado(String creadoPor) {
		
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		
		try {
			
			List<Empleado> empleados = empleadoService.spListarPersonaEmpleado(creadoPor);
			empleados.stream().forEach(e -> {
				empleadosDTO.add(modelMapper.map(e, EmpleadoDTO.class));
			});
			return empleadosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmpleadoDTO getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		
		EmpleadoDTO empleadoDTO = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaEmpleado)) {
				Empleado empleado = empleadoService.getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
				if(GenericUtil.isNotNull(empleado)) {
					empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
				}
			}
			return empleadoDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<EmpleadoDTO> findAll() {
		
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		
		try {
			
			List<Empleado> empleados = empleadoService.findAll();
			empleados.stream().forEach(e -> {
				empleadosDTO.add(modelMapper.map(e, EmpleadoDTO.class));
			});
			return empleadosDTO;
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
			
			empleados = empleadoService.spListarEmpleadosIntExt();
			if(!GenericUtil.isCollectionEmpty(empleados)) {
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

	@Override
	public ResponseBaseOperation disabledEmpleado(String documentoPersonaEmpleado) {
		
		try {
			
			EmpleadoDTO empleadoDTO = null;
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				empleadoDTO = getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
			}
			if(GenericUtil.isNotNull(empleadoDTO)) {
				if(empleadoDTO.getEstado().equals(Constantes.HABILITADO)) {
					empleadoService.disabledEmpleado(documentoPersonaEmpleado);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_DISABLED, empleadoDTO);
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
	public ResponseBaseOperation enabledEmpleado(String documentoPersonaEmpleado) {
		
		try {
			
			EmpleadoDTO empleadoDTO = null;
			if(GenericUtil.isNotNull(documentoPersonaEmpleado)) {
				empleadoDTO = getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
			}
			if(GenericUtil.isNotNull(empleadoDTO)) {
				if(empleadoDTO.getEstado().equals(Constantes.INHABILITADO)) {
					empleadoService.enabledEmpleado(documentoPersonaEmpleado);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_ENABLED, empleadoDTO);
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
	public ResponseBaseOperation totalRegistrosEmpleado() {
		
		try {
			
			Long totalRegistrosEmpleado = empleadoService.totalRegistrosEmpleado();
			if(totalRegistrosEmpleado == 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ": " + totalRegistrosEmpleado, totalRegistrosEmpleado);
			}
			else if(totalRegistrosEmpleado > 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ": " + totalRegistrosEmpleado, totalRegistrosEmpleado);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpleadoEXTINTResultViewModel> spListarDatosGenrales() {
		
		List<EmpleadoEXTINTResultViewModel> empleados = new ArrayList<EmpleadoEXTINTResultViewModel>();
		
		try {
			
			empleados = empleadoService.spListarEmpleadoDatos();
			if(!GenericUtil.isCollectionEmpty(empleados)) {
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

	@Override
	public ResponseBaseOperation spEstadoPlanta(String codidocu) {
		
		try {
			
			if(GenericUtil.isNotNull(codidocu)) {
				String result = empleadoService.spEstadoPlanta(codidocu);
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
