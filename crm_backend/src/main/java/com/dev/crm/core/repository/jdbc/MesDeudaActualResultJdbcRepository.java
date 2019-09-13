package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.MesActualDeuda;

public interface MesDeudaActualResultJdbcRepository {

	MesActualDeuda spRecuperarMesMonto(String documentoPersona);
}
