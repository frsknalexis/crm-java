package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.CorteInternetResultViewModel;
import com.dev.crm.core.repository.jdbc.CorteInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.ServicioInternetJdbcRepository;
import com.dev.crm.core.service.CorteService;
import com.dev.crm.core.util.GenericUtil;

@Service("corteService")
@Transactional("hibernateTransactionManager")
public class CorteServiceImpl implements CorteService {

	@Autowired
	@Qualifier("servicioInternetJdbcRepository")
	private ServicioInternetJdbcRepository servicioInternetJdbcRepository;
	
	@Autowired
	@Qualifier("corteInternetJdbcRepository")
	private CorteInternetJdbcRepository corteInternetJdbcRepository;
	
	@Override
	public List<CorteInternetResultViewModel> spListarCorteInternet() {
		
		List<CorteInternetResultViewModel> cortesInternet = new ArrayList<CorteInternetResultViewModel>();
		
		try {
			
			cortesInternet = corteInternetJdbcRepository.spListarCorte();
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
	public void spUpdateServicioInternet(Integer codigoServicioInternet) {
		
		try {
			
			if(GenericUtil.isNotNull(codigoServicioInternet) && codigoServicioInternet.intValue() > 0) {
				servicioInternetJdbcRepository.spUpdateServicioInternet(codigoServicioInternet);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
