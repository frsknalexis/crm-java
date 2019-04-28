package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.repository.jdbc.PagoJdbcRepository;
import com.dev.crm.core.service.PagoService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("pagoService")
@Transactional("hibernateTransactionManager")
public class PagoServiceImpl implements PagoService {

	@Autowired
	@Qualifier("pagoJdbcRepository")
	private PagoJdbcRepository pagoJdbcRepository;
	
	@Override
	public String spPagoServicio(PagoRequest pagoRequest) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoRequest)) {
				String result = pagoJdbcRepository.spPagoServicio(pagoRequest);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClientePagoResultViewModel> spListarClientesPago(String usuario) {
		
		List<ClientePagoResultViewModel> clientesPagos = new ArrayList<ClientePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				clientesPagos = pagoJdbcRepository.spListarClientesPago(usuario);
			}
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return clientesPagos;
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
