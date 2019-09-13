package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.SexoResultViewModel;

public interface SexoJdbcRepository {

	List<SexoResultViewModel> listarSexo();
}
