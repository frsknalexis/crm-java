package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PagoFacade;
import com.dev.crm.core.service.PagoService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("pagoFacade")
public class PagoFacadeImpl implements PagoFacade {

	@Autowired
	@Qualifier("pagoService")
	private PagoService pagoService;
	
	@Override
	public ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoRequest)) {
				String result = pagoService.spPagoServicio(pagoRequest);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, pagoRequest);
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
				clientesPagos = pagoService.spListarClientesPago(usuario);
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
