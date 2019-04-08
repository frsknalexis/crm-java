package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.UbigeoDTO;
import com.dev.crm.core.facade.UbigeoFacade;
import com.dev.crm.core.model.entity.Ubigeo;
import com.dev.crm.core.service.UbigeoService;
import com.dev.crm.core.util.GenericUtil;

@Component("ubigeoFacade")
public class UbigeoFacadeImpl implements UbigeoFacade {

	@Autowired
	@Qualifier("ubigeoService")
	private UbigeoService ubigeoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UbigeoDTO> findAll() {
		
		List<UbigeoDTO> ubigeosDTO = new ArrayList<UbigeoDTO>();
		
		try {
			
			List<Ubigeo> ubigeos = ubigeoService.findAll();
			ubigeos.stream().forEach(u -> {
				ubigeosDTO.add(modelMapper.map(u, UbigeoDTO.class));
			});
			return ubigeosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UbigeoDTO> findByNombreUbigeo(String termino) {
		
		List<UbigeoDTO> ubigeosDTO = new ArrayList<UbigeoDTO>();
		
		try {
			
			if(!(GenericUtil.isEmpty(termino))) {
				List<Ubigeo> ubigeos = ubigeoService.findByNombreUbigeo(termino);
				ubigeos.stream().forEach(u -> {
					ubigeosDTO.add(modelMapper.map(u, UbigeoDTO.class));
				});
				return ubigeosDTO;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
