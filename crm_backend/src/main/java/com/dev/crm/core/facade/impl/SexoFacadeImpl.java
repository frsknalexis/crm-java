package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.SexoDTO;
import com.dev.crm.core.dto.SexoResultViewModel;
import com.dev.crm.core.facade.SexoFacade;
import com.dev.crm.core.model.entity.Sexo;
import com.dev.crm.core.service.SexoService;
import com.dev.crm.core.util.GenericUtil;

@Component("sexoFacade")
public class SexoFacadeImpl implements SexoFacade {

	@Autowired
	@Qualifier("sexoService")
	private SexoService sexoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<SexoDTO> findAll() {
		
		List<SexoDTO> sexosDTO = new ArrayList<SexoDTO>();
		
		try {
			
			List<Sexo> sexos = sexoService.findAll();
			sexos.stream().forEach(s -> {
				sexosDTO.add(modelMapper.map(s, SexoDTO.class));
			});
			return sexosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SexoResultViewModel> listarSexo() {
		
		List<SexoResultViewModel> listaSexo = new ArrayList<SexoResultViewModel>();
		
		try {
			
			listaSexo = sexoService.listarSexo();
			if(GenericUtil.isCollectionEmpty(listaSexo)) {
				return null;
			}
			else {
				return listaSexo;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
