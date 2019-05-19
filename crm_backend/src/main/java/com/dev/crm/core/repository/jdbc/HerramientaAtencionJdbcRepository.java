package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.HerramientaResultViewModel;

public interface HerramientaAtencionJdbcRepository {
	
	List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario);
}
