package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.UbigeoDAO;
import com.dev.crm.core.model.entity.Ubigeo;
import com.dev.crm.core.repository.jpa.UbigeoJpaRepository;
import com.dev.crm.core.service.UbigeoService;
import com.dev.crm.core.util.GenericUtil;

@Service("ubigeoService")
@Transactional("hibernateTransactionManager")
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	@Qualifier("ubigeoDAO")
	private UbigeoDAO ubigeoDAO;
	
	@Autowired
	@Qualifier("ubigeoJpaRepository")
	private UbigeoJpaRepository ubigeoJpaRepository;
	
	@Override
	public List<Ubigeo> findAll() {
		
		List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
		
		try {
			
			ubigeos = ubigeoDAO.findAll(Ubigeo.class);
			if(GenericUtil.isNotNull(ubigeos)) {
				return ubigeos;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ubigeo> findByNombreUbigeo(String termino) {
		
		List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
		
		try {
			
			if(!(GenericUtil.isEmpty(termino))) {
				ubigeos = ubigeoJpaRepository.findByNombreUbigeo(termino);
			}
			if(GenericUtil.isNotNull(ubigeos)) {
				return ubigeos;
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
