package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.repository.jdbc.InformeInstalacionDiaInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.InstalacionDiaInternetJdbcRepository;
import com.dev.crm.core.service.InstalacionService;
import com.dev.crm.core.util.GenericUtil;

@Service("instalacionService")
@Transactional("hibernateTransactionManager")
public class InstalacionServiceImpl implements InstalacionService {

	@Autowired
	@Qualifier("instalacionDiaInternetJdbcRepsitory")
	private InstalacionDiaInternetJdbcRepository instalacionDiaInternetJdbcRepsitory;
	
	@Autowired
	@Qualifier("informeInstalacionDiaInternetJdbcRepository")
	private InformeInstalacionDiaInternetJdbcRepository informeInstalacionDiaInternetJdbcRepository;
	
	@Override
	public List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario) {
		
		List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = new ArrayList<InstalacionDiaInternetResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(usuario)) {
				instalacionesDiaInternet = instalacionDiaInternetJdbcRepsitory.spListarInstalacionDiaInternet(usuario);
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

	@Override
	public List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia() {
		
		List<InformeInstalacionDiaResultViewModel> informesInstalacionDia = new ArrayList<InformeInstalacionDiaResultViewModel>();
		
		try {
			
			informesInstalacionDia = informeInstalacionDiaInternetJdbcRepository.listarInformeInstalacionDia();
			if(GenericUtil.isCollectionEmpty(informesInstalacionDia)) {
				return null;
			}
			else {
				return informesInstalacionDia;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
