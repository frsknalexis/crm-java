package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DescuentoHistorialRequest;

public interface HistorialDescuentoResquestdbcRepository {

	String spGenerarDescuento(DescuentoHistorialRequest codigo);
}
