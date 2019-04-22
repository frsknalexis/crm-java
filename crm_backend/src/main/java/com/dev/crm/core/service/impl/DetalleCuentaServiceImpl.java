package com.dev.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.DetalleCuentaDAO;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.service.DetalleCuentaService;
import com.dev.crm.core.util.GenericUtil;

@Service("detalleCuentaService")
@Transactional("hibernateTransactionManager")
public class DetalleCuentaServiceImpl implements DetalleCuentaService {

	@Autowired
	@Qualifier("detalleCuentaDAO")
	private DetalleCuentaDAO detalleCuentaDAO;
	
	@Override
	public String spInsercionCuentaInternet(DetalleCuenta dC) {
		
		try {
			
			if(GenericUtil.isNotNull(dC)) {
				String result = detalleCuentaDAO.spInsercionCuentaInternet(dC);
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spInsercionCuentaCable(DetalleCuenta dC) {
		
		try {
			
			if(GenericUtil.isNotNull(dC)) {
				String result = detalleCuentaDAO.spInsercionCuentaCable(dC);
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void spReprogramarInstalacionCable() {
		
		try {
			
			detalleCuentaDAO.spReprogramarInstalacionCable();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spReprogramarInstalacionInternet() {
		
		try {
			
			detalleCuentaDAO.spReprogramarInstalacionInternet();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spRevalidandoFechaCable() {
		
		try {
			
			detalleCuentaDAO.spRevalidandoFechaCable();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spRevalidandoFechaInternet() {
		
		try {
			
			detalleCuentaDAO.spRevalidandoFechaInternet();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
