package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.MaterialResultViewModel;
import com.dev.crm.core.repository.jdbc.ListarMaterialesJdbcRepository;
import com.dev.crm.core.service.MaterialService;
import com.dev.crm.core.util.GenericUtil;

@Service("materialService")
@Transactional("hibernateTransactionManager")
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	@Qualifier("listarMaterialesJdbcRepository")
	private ListarMaterialesJdbcRepository listarMaterialesJdbcRepository;
	
	@Override
	public List<MaterialResultViewModel> listarMaterial() {
		
		List<MaterialResultViewModel> materiales = new ArrayList<MaterialResultViewModel>();
		
		try {
			
			materiales = listarMaterialesJdbcRepository.spListarMaterial();
			if(GenericUtil.isCollectionEmpty(materiales)) {
				return null;
			}
			else {
				return materiales;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
