package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_cliente", schema="public")
@IdClass(value=ClientePK.class)
@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name="listarClientesVendedor", procedureName="sp_listar_cliente_vendedor",
			resultClasses = {Cliente.class}, parameters= {
			@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_USU", type=String.class)
	}),
	@NamedStoredProcedureQuery(name="insertarCliente", procedureName="sp_inserccion_cliente", resultClasses= {Cliente.class}, parameters= {
			@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_DOC", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="NOM_COM", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="ACT_CLI", type=Boolean.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="COR_CLI", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="FAX_CLI", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_SEX", type=BigDecimal.class)
	})
})
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161632597950975614L;
	
	@Id
	@Column(name="cons_cliente")
	private Integer consecutivoCliente;
	
	@Id
	@Column(name="documento_personac", length=11)
	private String documentoPersonaCliente;
	
	@Column(name="codigo_cliente", length=6)
	private String codigoCliente;
	
	@Column(name="nombrecom_cliente")
	private String nombreComercialCliente;
	
	@Column(name="activo_cliente")
	private Boolean estado;
	
	@Column(name="correo_cliente")
	private String correoCliente;
	
	@Column(name="facebook_cliente")
	private String facebookCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_sexo", nullable=false)
	private Sexo sexo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	private List<CableServicio> cablesServicios;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	private List<Pago> pagos;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	private List<InternetServicio> internetServicios;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Reclamo> reclamos;

	public Cliente() {
		cablesServicios = new ArrayList<CableServicio>();
		pagos = new ArrayList<Pago>();
		internetServicios = new ArrayList<InternetServicio>();
		reclamos = new ArrayList<Reclamo>();
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombreComercialCliente() {
		return nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getFacebookCliente() {
		return facebookCliente;
	}

	public void setFacebookCliente(String facebookCliente) {
		this.facebookCliente = facebookCliente;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<CableServicio> getCablesServicios() {
		return cablesServicios;
	}

	public void setCablesServicios(List<CableServicio> cablesServicios) {
		this.cablesServicios = cablesServicios;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<InternetServicio> getInternetServicios() {
		return internetServicios;
	}

	public void setInternetServicios(List<InternetServicio> internetServicios) {
		this.internetServicios = internetServicios;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}
}
