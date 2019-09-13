package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.CodigoConsecutivoClienteRequest;
import com.dev.crm.core.dto.CodigoConsecutivoClienteResultViewModel;

public interface ConsecutivoClienteJdbcRepository {

	CodigoConsecutivoClienteResultViewModel generarCodigoConsecutivoCliente(CodigoConsecutivoClienteRequest request);
}
