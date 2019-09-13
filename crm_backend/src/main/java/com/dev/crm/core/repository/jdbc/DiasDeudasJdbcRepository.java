package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DiasDeudasResultViewModel;

public interface DiasDeudasJdbcRepository {

	List<DiasDeudasResultViewModel> recuperarDiasDeudas();
}
