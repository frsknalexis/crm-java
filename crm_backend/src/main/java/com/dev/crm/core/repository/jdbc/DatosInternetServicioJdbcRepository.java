package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosInternetServicioRequest;

public interface DatosInternetServicioJdbcRepository {

	String spEnvioDatosInternetServicio(DatosInternetServicioRequest request); 
}
