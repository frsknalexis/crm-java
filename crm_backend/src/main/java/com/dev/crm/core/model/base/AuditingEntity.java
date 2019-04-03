package com.dev.crm.core.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditingEntity implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3826935142134122700L;

	@Column(name="habilitado")
	private Boolean habilitado;
	
	@Column(name="creado_por")
	private BigDecimal creadoPor;
	
	@Column(name="modificado_por")
	private BigDecimal modificadoPor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_activacion")
	private Date fechaActivacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_desactivacion")
	private Date fechaDesactivacion;
	
	@Column(name="ipusuario")
	private String ipUsuario;
	
	@Column(name="usuariomaquina")
	private String usuarioMaquina;
	
	@Column(name="usuariosistema")
	private String usuarioSistema;
	
	public AuditingEntity() {
		
	}

	@Override
	public Boolean getHabilitado() {
		return habilitado;
	}

	@Override
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	@Override
	public BigDecimal getCreadoPor() {
		return creadoPor;
	}
	
	@Override
	public void setCreadoPor(BigDecimal creadoPor) {
		this.creadoPor = creadoPor;
	}
	
	@Override
	public BigDecimal getModificadoPor() {
		return modificadoPor;
	}
	
	@Override
	public void setModificadoPor(BigDecimal modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	@Override
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	@Override
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	
	@Override
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;	
	}
	
	@Override
	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	@Override
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	
	@Override
	public Date getFechaDesactivacion() {
		return fechaDesactivacion;
	}
	
	@Override
	public void setFechaDesactivacion(Date fechaDesactivacion) {
		this.fechaDesactivacion = fechaDesactivacion;
	}

	@Override
	public String getIpUsuario() {
		return ipUsuario;
	}


	@Override
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}
	
	@Override
	public String getUsuarioMaquina() {
		return usuarioMaquina;
	}
	
	@Override
	public void setUsuarioMaquina(String usuarioMaquina) {
		this.usuarioMaquina = usuarioMaquina;		
	}
	
	@Override
	public String getUsuarioSistema() {
		return usuarioSistema;
	}
	
	@Override
	public void setUsuarioSistema(String usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}
}
