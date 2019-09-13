package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;

public interface DeudasGestorMontoAcumuladoJdbcRepository {

	List<DeudasGestorMontoAcumuladoResultViewModel> listarDeudasGestorMontoAcumulado();
}
