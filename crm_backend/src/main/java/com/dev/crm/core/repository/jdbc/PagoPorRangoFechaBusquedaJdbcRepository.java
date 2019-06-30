package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaRequest;

public interface PagoPorRangoFechaBusquedaJdbcRepository {

	List<PagosPorDiaResultViewModel> spReporteListaPagosPorRangoFecha(PagosPorRangoFechaBusquedaRequest request);
}
