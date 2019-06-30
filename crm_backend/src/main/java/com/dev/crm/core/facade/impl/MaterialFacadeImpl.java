package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.MaterialResultViewModel;
import com.dev.crm.core.facade.MaterialFacade;
import com.dev.crm.core.service.MaterialService;
import com.dev.crm.core.util.GenericUtil;

@Component("materialFacade")
public class MaterialFacadeImpl implements MaterialFacade {

	@Autowired
	@Qualifier("materialService")
	private MaterialService materialService;
	
	@Override
	public List<MaterialResultViewModel> listarMateriales() {
		
		List<MaterialResultViewModel> materiales = new ArrayList<MaterialResultViewModel>();
		
		try {
			
			materiales = materialService.listarMaterial();
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
