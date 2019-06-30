package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ConsecutivoPagoRequest;

public interface ConsecutivoPagoJdbcRepository {

	String spInsertarConsecutivoPago(ConsecutivoPagoRequest request);
}
