package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ComprobanteResultViewModel;

public interface ComprobanteJdbcRepository {

	List<ComprobanteResultViewModel> spListarComprobante();
}
