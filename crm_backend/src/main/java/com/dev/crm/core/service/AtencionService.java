package com.dev.crm.core.service;

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
import com.dev.crm.core.dto.TareasResultViewModel;

public interface AtencionService {

	List<ClienteAtencionResultViewModel> spListarClientesAtencion();
	
	ClienteDatosAtencionResultViewModel spListarDatosGeneralesCliente(String documentoPersonaCliente); 
	
	List<ClienteAtencionDetalleResultViewModel> spListarClientesAtencionDetalle(String documentoPersonaCliente);
	
	String InserrcionReclamo(InsertarReclamoRequest codirecl);
	
	List<AsignarTecnicoComboResultViewModel> spListarcOmboTecnico(String persona);
	
	List<ReclamoResultViewModel> spListarReclamo(String usuario);
	
	String speditarreclamotecnico(InsertarTecnicTareaRequest codidocu);
	
	String speditarinstalaciontecnico(InsertarTecnicTareaRequest codidocu);
	
	String ObtenerTarea(ObtenernumerotareaRequest cantidad);
	
	MensajeNotiResultViewModel sprecuperardatosmensaje(String usuario);
	
	List<TareasResultViewModel> spListarTarea(String usuario);
	
	String speditartarea(String valor);
	
	DatosOnusResultViewModel spRecuperarDatos(String sn,String mac);
}
