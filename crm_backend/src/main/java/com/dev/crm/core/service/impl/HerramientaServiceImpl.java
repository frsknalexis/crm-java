package com.dev.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.dto.ValorHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.dto.HerramientaRequest;
import com.dev.crm.core.repository.jdbc.DetalleHerramintaJdbcRepository;
import com.dev.crm.core.repository.jdbc.HerramientaAtencionJdbcRepository;
import com.dev.crm.core.repository.jdbc.InserccionHerramintaJdbcRepository;
import com.dev.crm.core.repository.jdbc.RequestEditarHerramintaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.ValorHerramintaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.ViewHerramentaJdbcRepository;
import com.dev.crm.core.repository.jdbc.EditarHerramintaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.EditarPreguntaResultJdbcRepository;
import com.dev.crm.core.service.HerramientaService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@Service("herramientaService")
@Transactional("hibernateTransactionManager")
public class HerramientaServiceImpl implements HerramientaService {

	@Autowired
	@Qualifier("herramientaAtencionJdbcRepository")
	private HerramientaAtencionJdbcRepository herramientaAtencionJdbcRepository;
	
	@Autowired
	@Qualifier("InserccionHerramintaJdbcRepository")
	private InserccionHerramintaJdbcRepository InserccionHerramintaJdbcRepository;
	
	@Autowired
	@Qualifier("detalleherramintaJdbcRepository")
	private DetalleHerramintaJdbcRepository InsercciondetalleHerramintaJdbcRepository;
	
	@Autowired
	@Qualifier("ValorHerramintaResultJdbcRepository")
	private ValorHerramintaResultJdbcRepository ValorHerramintaResultJdbcRepository;
	
	@Autowired
	@Qualifier("ViewHerramentaJdbcRepository")
	private ViewHerramentaJdbcRepository ViewHerramentaJdbcRepository;
	
	@Autowired
	@Qualifier("EditarHerramintaResultJdbcRepository")
	private EditarHerramintaResultJdbcRepository editarHerramintaResultJdbcRepository;
	
	@Autowired
	@Qualifier("RequestEditarHerramintaResultJdbcRepository")
	private RequestEditarHerramintaResultJdbcRepository requestEditarHerramintaResultJdbcRepository;
	
	@Autowired
	@Qualifier("EditarPreguntaResultJdbcRepository")
	private EditarPreguntaResultJdbcRepository EditarpreguntaResultJdbcRepository;
	
	@Override
	public List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario) {
		
		List<HerramientaResultViewModel> herramientasAtencion = new ArrayList<HerramientaResultViewModel>();
		
		try {
			
			if(StringUtil.hasText(usuario)) {
				herramientasAtencion = herramientaAtencionJdbcRepository.spListarHerramientaAtencion(usuario);
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
	public String spInserccionHerramienta(HerramientaRequest inserther) {
		
		try {
			
			if(GenericUtil.isNotNull(inserther)) {
				String result = InserccionHerramintaJdbcRepository.spinserccionHerramienta(inserther);
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
	public String spInsercciondetalleHerramienta(DetalleHerramientaRequest detalleinserther) {
		
		try {
			
			if(GenericUtil.isNotNull(detalleinserther)) {
				String result = InsercciondetalleHerramintaJdbcRepository.spinsercciondetalleHerramienta(detalleinserther);
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
	public ValorHerramientaRequest soBuscarHerramienta(String codherra) {
		
		ValorHerramientaRequest codher = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(codherra)) {
				codher = ValorHerramintaResultJdbcRepository.spBuscarHerra(codherra);
			}
			if(GenericUtil.isNotNull(codher)) {
				return codher;
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
				herramientasAtencion = ViewHerramentaJdbcRepository.soListarPregunta(usuario);
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
	
	public EditarHerramientaResultViewModel spBuscarDatosHerramienta(String codiherr) {
		
		EditarHerramientaResultViewModel codher = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(codiherr)) {
				codher = editarHerramintaResultJdbcRepository.spBuscarDatosEditar(codiherr);
			}
			if(GenericUtil.isNotNull(codher)) {
				return codher;
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
	public String spEditarHerramienta(EditarHerramientaRequest codiherr) {
		
		try {
			
			if(GenericUtil.isNotNull(codiherr)) {
				String result = requestEditarHerramintaResultJdbcRepository.spEditarHerramienta(codiherr);
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
	public String spEdiatrPregunta(EditarPreguntaRequest codiherr) {
		
		try {
			
			if(GenericUtil.isNotNull(codiherr)) {
				String result = EditarpreguntaResultJdbcRepository.spBuscarDatosEditar(codiherr);
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
}
