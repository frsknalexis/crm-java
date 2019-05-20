package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;

public interface InstalacionService {

	List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario);
}
