package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.ObservacionResultViewModel;

public interface ObservacionCuentaJdbcRepository {

	ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta);
}
