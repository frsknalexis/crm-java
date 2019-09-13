package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.GananciaPorDiaCajaResultViewModel;

public interface GananciaPorDiaCajaJdbcRepository {

	List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja();
}
