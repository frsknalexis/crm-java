package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.UbigeoResultViewModel;

public interface UbigeoJdbcRepository {

	List<UbigeoResultViewModel> listarUbigeo();
}
