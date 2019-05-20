package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.facade.InstalacionFacade;
import com.dev.crm.core.service.InstalacionService;
import com.dev.crm.core.util.GenericUtil;

@Component("instalacionFacade")
public class InstalacionFacadeImpl implements InstalacionFacade {

	@Autowired
	@Qualifier("instalacionService")
	private InstalacionService instalacionService;
	
	@Override
	public List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario) {
		
		List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = new ArrayList<InstalacionDiaInternetResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				instalacionesDiaInternet = instalacionService.spListarInstalacionDiaInternet(usuario);
				if(GenericUtil.isCollectionEmpty(instalacionesDiaInternet)) {
					return null;
				}
				else {
					return instalacionesDiaInternet;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
