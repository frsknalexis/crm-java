package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ComprobanteResultViewModel;
import com.dev.crm.core.facade.ComprobanteFacade;
import com.dev.crm.core.service.ComprobanteService;
import com.dev.crm.core.util.GenericUtil;

@Component("comprobanteFacade")
public class ComprobanteFacadeImpl implements ComprobanteFacade {

	@Autowired
	@Qualifier("comprobanteService")
	private ComprobanteService comprobanteService;
	
	@Override
	public List<ComprobanteResultViewModel> spListarComprobante() {
		
		List<ComprobanteResultViewModel> comprobantes = new ArrayList<ComprobanteResultViewModel>();
		
		try {
			
			comprobantes = comprobanteService.spListarComprobante();
			if(!GenericUtil.isCollectionEmpty(comprobantes)) {
				return comprobantes;
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
