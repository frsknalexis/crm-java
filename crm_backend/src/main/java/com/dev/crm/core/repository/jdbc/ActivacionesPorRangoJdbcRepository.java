package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ActivacionesPorRangoRequest;
import com.dev.crm.core.dto.ActivacionesPorRangoResultViewModel;

public interface ActivacionesPorRangoJdbcRepository {

	List<ActivacionesPorRangoResultViewModel> listarActivacionesPorRango(ActivacionesPorRangoRequest request);
}
