package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.dto.HerramientaRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.ValorHerramientaRequest;
import com.dev.crm.core.facade.HerramientaFacade;
import com.dev.crm.core.service.HerramientaService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("herramientaFacade")
public class HerramientaFacadeImpl implements HerramientaFacade {

	@Autowired
	@Qualifier("herramientaService")
	private HerramientaService herramientaService;
	
	@Override
	public List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario) {
		
		List<HerramientaResultViewModel> herramientasAtencion = new ArrayList<HerramientaResultViewModel>();
		
		try {
			
			if(StringUtil.hasText(usuario)) {
				herramientasAtencion = herramientaService.spListarHerramientaAtencion(usuario);
				if(!GenericUtil.isCollectionEmpty(herramientasAtencion)) {
					return herramientasAtencion;
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
	public ResponseBaseOperation spInserccionHerramienta(HerramientaRequest inserther) {
		
		try {
			
			if(GenericUtil.isNotNull(inserther)) {
				String result = herramientaService.spInserccionHerramienta(inserther);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, inserther);
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
	public ResponseBaseOperation spInsercciondetalleHerramienta(DetalleHerramientaRequest inserther) {
		
		try {
			
			if(GenericUtil.isNotNull(inserther)) {
				String result = herramientaService.spInsercciondetalleHerramienta(inserther);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, inserther);
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
	public ValorHerramientaRequest soBusquedaHerramienta(String codiherra) {
		
		ValorHerramientaRequest clientePago = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(codiherra)) {
				clientePago = herramientaService.soBuscarHerramienta(codiherra);
			}
			if(GenericUtil.isNotNull(clientePago)) {
				return clientePago;
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
	
	@Override
	public List<DetalleHerramientaViewModel> soListarPregunta(String usuario) {
		
		List<DetalleHerramientaViewModel> herramientasAtencion = new ArrayList<DetalleHerramientaViewModel>();
		
		try {
			
			if(StringUtil.hasText(usuario)) {
				herramientasAtencion = herramientaService.soListarPregunta(usuario);
				if(!GenericUtil.isCollectionEmpty(herramientasAtencion)) {
					return herramientasAtencion;
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
	public EditarHerramientaResultViewModel soListarDatosHerra(String codiherr) {
		
		EditarHerramientaResultViewModel editar = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(codiherr)) {
				editar = herramientaService.spBuscarDatosHerramienta(codiherr);
			}
			if(GenericUtil.isNotNull(editar)) {
				return editar;
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

	@Override
	public ResponseBaseOperation spEditarHerramienta(EditarHerramientaRequest codiherr) {
		
		try {
			
			if(GenericUtil.isNotNull(codiherr)) {
				String result = herramientaService.spEditarHerramienta(codiherr);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codiherr);
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
	public ResponseBaseOperation spEditarPregunta(EditarPreguntaRequest codiherr) {

		try {
			
			if(GenericUtil.isNotNull(codiherr)) {
				String result = herramientaService.spEdiatrPregunta(codiherr);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, codiherr);
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
}
