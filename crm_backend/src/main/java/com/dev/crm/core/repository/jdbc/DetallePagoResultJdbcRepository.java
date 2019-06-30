package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DetallePagoResultViewModel;;

public interface DetallePagoResultJdbcRepository {

	List<DetallePagoResultViewModel> spListaDetallePago(String persona);
}
