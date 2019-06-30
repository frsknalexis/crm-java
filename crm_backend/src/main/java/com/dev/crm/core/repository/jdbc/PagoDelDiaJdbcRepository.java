package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PagosDelDiaResultViewModel;

public interface PagoDelDiaJdbcRepository {

	List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario);
}
