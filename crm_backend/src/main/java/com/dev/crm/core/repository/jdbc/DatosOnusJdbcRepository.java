package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosOnusResultViewModel;

public interface DatosOnusJdbcRepository {

	DatosOnusResultViewModel spRecuperarDatos(String sn,String mac);
}