package com.dev.crm.core.service;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.dto.DatosOnuInstalacionResultViewModel;;

public interface OnuService {

	String envioDatosOnu(DatosOnuInstalacionRequest request);
	
	DatosOnuInstalacionResultViewModel spBuscarDatos(String codigo);
}
