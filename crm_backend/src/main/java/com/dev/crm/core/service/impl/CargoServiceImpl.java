package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.CargoDAO;
import com.dev.crm.core.model.entity.Cargo;
import com.dev.crm.core.repository.jpa.CargoJpaRepository;
import com.dev.crm.core.service.CargoService;
import com.dev.crm.core.util.GenericUtil;

@Service("cargoService")
@Transactional("hibernateTransactionManager")
public class CargoServiceImpl implements CargoService {

	@Autowired
	@Qualifier("cargoDAO")
	private CargoDAO cargoDAO;
	
	@Autowired
	@Qualifier("cargoJpaRepository")
	private CargoJpaRepository cargoJpaRepository;
	
	@Override
	public List<Cargo> findAll() {
		
		List<Cargo> cargos = new ArrayList<Cargo>();
		
		try {
			
			cargos = cargoDAO.findAll(Cargo.class);
			if(GenericUtil.isNotNull(cargos)) {
				return cargos;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cargo> findByDescripcionCargo(String termino) {
		
		List<Cargo> cargos = new ArrayList<Cargo>();
		
		try {
			
			if(GenericUtil.isNotEmpty(termino)) {
				cargos = cargoJpaRepository.findByDescripcionCargo(termino);
			}
			if(GenericUtil.isNotNull(cargos)) {
				return cargos;
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
