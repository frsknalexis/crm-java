package com.dev.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.DetalleCuentaDAO;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.service.DetalleCuentaService;

@Service("detalleCuentaService")
@Transactional("hibernateTransactionManager")
public class DetalleCuentaServiceImpl implements DetalleCuentaService {

	@Autowired
	@Qualifier("detalleCuentaDAO")
	private DetalleCuentaDAO detalleCuentaDAO;
	
	@Override
	public void spInsercionCuentaInternet(DetalleCuenta dC) {
		
		try {
			
			detalleCuentaDAO.spInsercionCuentaInternet(dC);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spInsercionCuentaCable(DetalleCuenta dC) {
		
		try {
			
			detalleCuentaDAO.spInsercionCuentaCable(dC);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
