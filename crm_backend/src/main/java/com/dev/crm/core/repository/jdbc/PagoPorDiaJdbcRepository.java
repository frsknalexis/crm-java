package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;

public interface PagoPorDiaJdbcRepository {

	List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request);
}
