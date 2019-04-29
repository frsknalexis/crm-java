package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.MesDeudaResultViewModel;

public interface MesDeudaResultJdbcRepository {

	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
}
