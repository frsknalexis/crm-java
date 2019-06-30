package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.GestorFacade;
import com.dev.crm.core.service.GestorService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("gestorFacade")
public class GestorFacadeImpl implements GestorFacade {

	@Autowired
	@Qualifier("gestorService")
	private GestorService gestorService;
	
	@Override
	public List<ClienteGestorResultViewModel> listarClienteGestor() {
		
		List<ClienteGestorResultViewModel> clientesGestor = new ArrayList<ClienteGestorResultViewModel>();
		
		try {
			
			clientesGestor = gestorService.listarClienteGestor();
			if(GenericUtil.isCollectionEmpty(clientesGestor)) {
				return null;
			}
			else {
				return clientesGestor;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<GestoresResultViewModel> listarGestores() {
	
		List<GestoresResultViewModel> gestores = new ArrayList<GestoresResultViewModel>();
		
		try {
			
			gestores = gestorService.listarGestores();
			if(GenericUtil.isCollectionEmpty(gestores)) {
				return null;
			}
			else {
				return gestores;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation updateClienteGestor(ClienteGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = gestorService.updateClienteGestor(request);
				if(StringUtil.eq(result, Constantes.BUENO)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
