package com.dev.crm.core.dao;

import java.util.List;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.Empleado;

public interface EmpleadoDAO extends BaseDAOHibernate {

	List<Empleado> spListarPersonaEmpleado(String creadoPor);
	
	List<Empleado> getActiveListEmpleados();
	
	void spInsercionEmpleado(Empleado empleado);
	
	void spActualizarEmpleado(Empleado empleado);
	
	boolean isEmpleadoPresent(String documentoPersonaEmpleado);
	
	Empleado getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado);
	
	void disabledEmpleado(Empleado empleado);
	
	void enabledEmpleado(Empleado empleado);
	
	Long totalRegistrosEmpleado();
}
