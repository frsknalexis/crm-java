package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PagosPorMesResultViewModel;

public interface PagosPorMesJdbcRepository {

	List<PagosPorMesResultViewModel> pagosPorMes();
}
