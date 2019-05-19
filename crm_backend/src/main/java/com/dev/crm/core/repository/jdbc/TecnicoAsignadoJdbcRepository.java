package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;;

public interface TecnicoAsignadoJdbcRepository {

	List<AsignarTecnicoComboResultViewModel> spComboTecnico(String persona);
}
