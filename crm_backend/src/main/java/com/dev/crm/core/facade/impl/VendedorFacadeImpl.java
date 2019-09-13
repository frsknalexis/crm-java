package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.VendedoresResultViewModel;
import com.dev.crm.core.facade.VendedorFacade;
import com.dev.crm.core.service.VendedorService;
import com.dev.crm.core.util.GenericUtil;

@Component("vendedorFacade")
public class VendedorFacadeImpl implements VendedorFacade {

	@Autowired
	@Qualifier("vendedorService")
	private VendedorService vendedorService;
	
	@Override
	public List<VendedoresResultViewModel> listarVendedores() {
		
		List<VendedoresResultViewModel> vendedores = new ArrayList<VendedoresResultViewModel>();
		
		try {
			
			vendedores = vendedorService.listarVendedores();
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
