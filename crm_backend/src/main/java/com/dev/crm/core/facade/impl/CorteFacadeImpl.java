package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.CorteInternetResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.CorteFacade;
import com.dev.crm.core.service.CorteService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Component("corteFacade")
public class CorteFacadeImpl implements CorteFacade {

	@Autowired
	@Qualifier("corteService")
	private CorteService corteService;
	
	@Override
	public List<CorteInternetResultViewModel> spListarCorteInternet() {
		
		List<CorteInternetResultViewModel> cortesInternet = new ArrayList<CorteInternetResultViewModel>();
		
		try {
			
			cortesInternet = corteService.spListarCorteInternet();
			if(GenericUtil.isEmpty(cortesInternet)) {
				return null;
			}
			else {
				return cortesInternet;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spUpdateServicioInternet(Integer codigoServicioInternet) {
		
		try {
			
			if(GenericUtil.isNotNull(codigoServicioInternet) && codigoServicioInternet.intValue() > 0) {
				corteService.spUpdateServicioInternet(codigoServicioInternet);
				return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, codigoServicioInternet);
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
