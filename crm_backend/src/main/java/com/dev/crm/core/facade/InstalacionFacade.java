package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;

public interface InstalacionFacade {

	List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario);
}
