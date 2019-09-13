package com.dev.crm.core.facade;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.dto.DatosOnuInstalacionResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface OnuFacade {

	ResponseBaseOperation envioDatosOnu(DatosOnuInstalacionRequest request);
	
	DatosOnuInstalacionResultViewModel spBuscarDatos(String codigo);
}