package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.PagoServicioGestorRequest;

public interface PagoServicioGestorJdbcRepository {

	String realizarPagoServicioGestor(PagoServicioGestorRequest request);
}
