package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.SexoDTO;
import com.dev.crm.core.dto.SexoResultViewModel;

public interface SexoFacade {

	List<SexoDTO> findAll();
	
	List<SexoResultViewModel> listarSexo();
}
