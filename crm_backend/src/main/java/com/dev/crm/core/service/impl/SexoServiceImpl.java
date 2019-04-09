package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.SexoDAO;
import com.dev.crm.core.model.entity.Sexo;
import com.dev.crm.core.service.SexoService;
import com.dev.crm.core.util.GenericUtil;

@Service("sexoService")
@Transactional("hibernateTransactionManager")
public class SexoServiceImpl implements SexoService {

	@Autowired
	@Qualifier("sexoDAO")
	private SexoDAO sexoDAO;
	@Override
	public List<Sexo> findAll() {
		
		List<Sexo> sexos = new ArrayList<Sexo>();
		
		try {
			
			sexos = sexoDAO.findAll(Sexo.class);
			if(GenericUtil.isNotNull(sexos)) {
				return sexos;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
