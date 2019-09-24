package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dev.crm.core.json.JsonBigDecimalSimpleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class GananciaMesTotalResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4208928440907037866L;

	@JsonSerialize(using = JsonBigDecimalSimpleSerializer.class)
	private BigDecimal total;

	public GananciaMesTotalResultViewModel() {
		
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
