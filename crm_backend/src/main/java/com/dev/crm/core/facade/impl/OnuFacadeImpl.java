package com.dev.crm.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.OnuFacade;
import com.dev.crm.core.service.OnuService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("onuFacade")
public class OnuFacadeImpl implements OnuFacade {

	@Autowired
	@Qualifier("onuService")
	private OnuService onuService;
	
	@Override
	public ResponseBaseOperation envioDatosOnu(DatosOnuInstalacionRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = onuService.envioDatosOnu(request);
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
