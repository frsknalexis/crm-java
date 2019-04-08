package com.dev.crm.core.model.base;

import java.util.Date;

public interface BaseEntity {

	public Boolean getHabilitado();
	
	public void setHabilitado(Boolean habilitado);
	
	public String getCreadoPor();
	
	public void setCreadoPor(String creadoPor);
	
	public String getModificadoPor();
	
	public void setModificadoPor(String modificadoPor);
	
	public Date getFechaRegistro();
	
	public void setFechaRegistro(Date fechaRegistro);
	
	public Date getFechaModificacion();
	
	public void setFechaModificacion(Date fechaModificacion);
	
	public Date getFechaActivacion();
	
	public void setFechaActivacion(Date fechaActivacion);
	
	public Date getFechaDesactivacion();
	
	public void setFechaDesactivacion(Date fechaDesactivacion);
	
	public String getIpUsuario();
	
	public void setIpUsuario(String ipUsuario);
	
	public String getUsuarioMaquina();
	
	public void setUsuarioMaquina(String usuarioMaquina);
	
	public String getUsuarioSistema();
	
	public void setUsuarioSistema(String usuarioSistema);
}
