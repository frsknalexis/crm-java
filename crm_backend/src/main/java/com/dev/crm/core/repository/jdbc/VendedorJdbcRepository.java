package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.VendedoresResultViewModel;

public interface VendedorJdbcRepository {

	List<VendedoresResultViewModel> listarVendedores();
}
