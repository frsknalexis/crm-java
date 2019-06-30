package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;

public interface DatosOnuInstalacionJdbcRepository {

	String envioDatosOnu(DatosOnuInstalacionRequest request);
}
