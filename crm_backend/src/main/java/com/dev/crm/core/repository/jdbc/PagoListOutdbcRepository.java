package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DescuentoPagoResultViewModel;

public interface PagoListOutdbcRepository {

	DescuentoPagoResultViewModel spRecuperarDatosPago(String persona);
}
