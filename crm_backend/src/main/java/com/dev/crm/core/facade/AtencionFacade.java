package com.dev.crm.core.facade;

import java.util.List;

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
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.TareasResultViewModel;

public interface AtencionFacade {

	List<ClienteAtencionResultViewModel> spListarClientesAtencion();
	
	ClienteDatosAtencionResultViewModel spListarDatosGeneralesCliente(String documentoPersonaCliente);
	
	List<ClienteAtencionDetalleResultViewModel> spListarClientesAtencionDetalle(String documentoPersonaCliente);
	
	ResponseBaseOperation spInsertarReclamo (InsertarReclamoRequest codirecl);
	
	List<AsignarTecnicoComboResultViewModel> spListarComboTecnico(String persona);
	
	List<ReclamoResultViewModel> spListarReclamo(String usuario);
	
	ResponseBaseOperation speditarreclmaotecnico(InsertarTecnicTareaRequest codidocu);
	
	ResponseBaseOperation spObtnerCantidadTarea(ObtenernumerotareaRequest cantidad);
	
	MensajeNotiResultViewModel spbuscardatosmensaje(String usuario);
	
	List<TareasResultViewModel> spListarTareas(String usuario);
	
	ResponseBaseOperation speditartarea(String valor);
	
	DatosOnusResultViewModel sppRecuperarDatos(String sn,String mac);
	
	ResponseBaseOperation speditarinstmaotecnico(InsertarTecnicTareaRequest codidocu);
}
