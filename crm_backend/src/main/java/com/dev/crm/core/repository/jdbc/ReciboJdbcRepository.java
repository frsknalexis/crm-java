package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ReciboResultViewModel;

public interface ReciboJdbcRepository {

	ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago);
}
