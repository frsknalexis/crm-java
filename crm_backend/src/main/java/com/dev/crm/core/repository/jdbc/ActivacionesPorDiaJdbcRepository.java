package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.ActivacionesPorDiaRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaResultViewModel;

public interface ActivacionesPorDiaJdbcRepository {

	List<ActivacionesPorDiaResultViewModel> listarActivacionesPorDia(ActivacionesPorDiaRequest request);
}
