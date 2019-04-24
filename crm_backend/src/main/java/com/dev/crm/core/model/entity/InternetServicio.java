package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_in_servicio", schema = "public")
public class InternetServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626589759100362958L;

	@Id
	@Column(name = "codi_serin", nullable=false)
	private BigDecimal codigoInternetServicio;
	
	@Column(name="fechainicio_serin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioInternetServicio;
	
	@Column(name="fechatermino_serin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTerminoInternetServicio;
	
	@Column(name="observacion_serin")
	@Temporal(TemporalType.TIMESTAMP)
	private String ObservacionInternetServicio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_estado", nullable=false)
	private EstadoCuenta estadoCuenta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_tipo_Serv", nullable=false)
	private Servicio servicio;
}
