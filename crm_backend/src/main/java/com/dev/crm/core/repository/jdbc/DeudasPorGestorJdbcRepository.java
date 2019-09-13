package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DeudasPorGestorRequest;
import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;

public interface DeudasPorGestorJdbcRepository {

	List<DeudasPorGestorResultViewModel> listarDeudasPorGestor(DeudasPorGestorRequest request);
}
