package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DetalleHerramientaViewModel;

public interface ViewHerramentaJdbcRepository {
	
	List<DetalleHerramientaViewModel> soListarPregunta(String usuario);
}
