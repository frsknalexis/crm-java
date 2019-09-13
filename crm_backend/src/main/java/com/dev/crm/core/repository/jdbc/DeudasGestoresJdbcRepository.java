package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;

public interface DeudasGestoresJdbcRepository {

	List<DeudasGestoresResultViewModel> recuperarDiasDeudasGestoresParametrizado(DiasDeudasRequest request);
}
