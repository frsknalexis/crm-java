package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_empleado", schema="public")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930630574068721114L;

}
