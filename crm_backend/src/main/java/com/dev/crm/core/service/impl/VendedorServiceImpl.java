package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.VendedoresResultViewModel;
import com.dev.crm.core.repository.jdbc.VendedorJdbcRepository;
import com.dev.crm.core.service.VendedorService;
import com.dev.crm.core.util.GenericUtil;

@Service("vendedorService")
@Transactional("hibernateTransactionManager")
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	@Qualifier("vendedorJdbcRepository")
	private VendedorJdbcRepository vendedorJdbcRepository;
	
	@Override
	public List<VendedoresResultViewModel> listarVendedores() {
		
		List<VendedoresResultViewModel> vendedores = new ArrayList<VendedoresResultViewModel>();
		
		try {
			
			vendedores = vendedorJdbcRepository.listarVendedores();
			if(GenericUtil.isCollectionEmpty(vendedores)) {
				return null;
			}
			else {
				return vendedores;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
