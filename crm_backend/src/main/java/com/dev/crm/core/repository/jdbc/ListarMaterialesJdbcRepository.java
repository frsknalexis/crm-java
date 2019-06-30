package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.MaterialResultViewModel;

public interface ListarMaterialesJdbcRepository {

	List<MaterialResultViewModel> spListarMaterial();
}
