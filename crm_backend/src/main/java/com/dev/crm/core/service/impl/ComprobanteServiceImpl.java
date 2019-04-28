package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ComprobanteResultViewModel;
import com.dev.crm.core.repository.jdbc.ComprobanteJdbcRepository;
import com.dev.crm.core.service.ComprobanteService;
import com.dev.crm.core.util.GenericUtil;

@Service("comprobanteService")
@Transactional("hibernateTransactionManager")
public class ComprobanteServiceImpl implements ComprobanteService {

	@Autowired
	@Qualifier("comprobanteJdbcRepository")
	private ComprobanteJdbcRepository comprobanteJdbcRepository;
	
	@Override
	public List<ComprobanteResultViewModel> spListarComprobante() {
		
		List<ComprobanteResultViewModel> comprobantes = new ArrayList<ComprobanteResultViewModel>();
		
		try {
			
			comprobantes = comprobanteJdbcRepository.spListarComprobante();
			if(GenericUtil.isNotNull(comprobantes)) {
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
