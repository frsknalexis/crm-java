package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaRequest;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaResultViewModel;

public interface PagoPorRangoFechaBusquedaJdbcRepository {

	List<PagosPorRangoFechaBusquedaResultViewModel> spReporteListaPagosPorRangoFecha(PagosPorRangoFechaBusquedaRequest request);
}
