package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.CargoDTO;
import com.dev.crm.core.facade.CargoFacade;
import com.dev.crm.core.model.entity.Cargo;
import com.dev.crm.core.service.CargoService;
import com.dev.crm.core.util.GenericUtil;

@Component("cargoFacade")
public class CargoFacadeImpl implements CargoFacade {
	
	@Autowired
	@Qualifier("cargoService")
	private CargoService cargoService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CargoDTO> findAll() {
		
		List<CargoDTO> cargosDTO = new ArrayList<CargoDTO>();
		
		try {
			
			List<Cargo> cargos = cargoService.findAll();
			cargos.stream().forEach(c -> {
				cargosDTO.add(modelMapper.map(c, CargoDTO.class));
			});
			return cargosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CargoDTO> findByDescripcionCargo(String termino) {
		
		List<CargoDTO> cargosDTO = new ArrayList<CargoDTO>();
		
		try {
			
			if(GenericUtil.isNotEmpty(termino)) {
				List<Cargo> cargos = cargoService.findByDescripcionCargo(termino);
				cargos.stream().forEach(c -> {
					cargosDTO.add(modelMapper.map(c, CargoDTO.class));
				});
				return cargosDTO;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
