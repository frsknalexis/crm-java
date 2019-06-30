package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;

public interface ListaPagosPorCajaJdbcRepository {

	List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario);
}
