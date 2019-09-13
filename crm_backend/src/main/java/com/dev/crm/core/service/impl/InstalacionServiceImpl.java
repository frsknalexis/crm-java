package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaResultViewModel;
import com.dev.crm.core.dto.ActivacionesPorRangoRequest;
import com.dev.crm.core.dto.ActivacionesPorRangoResultViewModel;
import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.dto.InstalacionesResultViewModel;
import com.dev.crm.core.repository.jdbc.ActivacionRequestJdbcRepository;
import com.dev.crm.core.repository.jdbc.ActivacionesJdbcRepository;
import com.dev.crm.core.repository.jdbc.ActivacionesPorDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.ActivacionesPorRangoJdbcRepository;
import com.dev.crm.core.repository.jdbc.InformeInstalacionDiaInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.InstalacionDiaInternetJdbcRepository;
import com.dev.crm.core.repository.jdbc.InstalacionesJdbcRepository;
import com.dev.crm.core.repository.jdbc.InstalacionesPorTecnicoJdbcRepository;
import com.dev.crm.core.service.InstalacionService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("instalacionService")
@Transactional("hibernateTransactionManager")
public class InstalacionServiceImpl implements InstalacionService {

	@Autowired
	@Qualifier("instalacionDiaInternetJdbcRepsitory")
	private InstalacionDiaInternetJdbcRepository instalacionDiaInternetJdbcRepsitory;
	
	@Autowired
	@Qualifier("informeInstalacionDiaInternetJdbcRepository")
	private InformeInstalacionDiaInternetJdbcRepository informeInstalacionDiaInternetJdbcRepository;
	
	@Autowired
	@Qualifier("instalacionesPorTecnicoJdbcRepository")
	private InstalacionesPorTecnicoJdbcRepository instalacionesPorTecnicoJdbcRepository;
	
	@Autowired
	@Qualifier("ActivacionRequestJdbcRepository")
	private ActivacionRequestJdbcRepository activacionRequestJdbcRepository;
	
	@Autowired
	@Qualifier("instalacionesJdbcRepository")
	private InstalacionesJdbcRepository instalacionesJdbcRepository;
	
	@Autowired
	@Qualifier("activacionesJdbcRepository")
	private ActivacionesJdbcRepository activacionesJdbcRepository;
	
	@Autowired
	@Qualifier("activacionesPorDiaJdbcRepository")
	private ActivacionesPorDiaJdbcRepository activacionesPorDiaJdbcRepository;
	
	@Autowired
	@Qualifier("activacionesPorRangoJdbcRepository")
	private ActivacionesPorRangoJdbcRepository activacionesPorRangoJdbcRepository;
	
	@Override
	public List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario) {
		
		List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = new ArrayList<InstalacionDiaInternetResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(usuario)) {
				instalacionesDiaInternet = instalacionDiaInternetJdbcRepsitory.spListarInstalacionDiaInternet(usuario);
				if(GenericUtil.isCollectionEmpty(instalacionesDiaInternet)) {
					return null;
				}
				else {
					return instalacionesDiaInternet;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia() {
		
		List<InformeInstalacionDiaResultViewModel> informesInstalacionDia = new ArrayList<InformeInstalacionDiaResultViewModel>();
		
		try {
			
			informesInstalacionDia = informeInstalacionDiaInternetJdbcRepository.listarInformeInstalacionDia();
			if(GenericUtil.isCollectionEmpty(informesInstalacionDia)) {
				return null;
			}
			else {
				return informesInstalacionDia;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<InstalacionesResultViewModel> contadorInstalacionesRealizadas() {
		
		List<InstalacionesResultViewModel> instalacionesRealizadas = new ArrayList<InstalacionesResultViewModel>();
		
		try {
			
			instalacionesRealizadas = instalacionesJdbcRepository.contadorInstalacionesRealizadas();
			if(GenericUtil.isCollectionEmpty(instalacionesRealizadas)) {
				return null;
			}
			else {
				return instalacionesRealizadas;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico() {
		
		List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico = new ArrayList<InstalacionesPorTecnicoResultViewModel>();
		
		try {
			
			instalacionesPorTecnico = instalacionesPorTecnicoJdbcRepository.instalacionesPorTecnico();
			if(GenericUtil.isCollectionEmpty(instalacionesPorTecnico)) {
				return null;
			}
			else {
				return instalacionesPorTecnico;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ActivacionesResultViewModel> listarActivacionesInstalacion() {
		
		List<ActivacionesResultViewModel> activacionesInstalacion = new ArrayList<ActivacionesResultViewModel>();
		
		try {
			
			activacionesInstalacion = activacionesJdbcRepository.listarActivacionesInstalacion();
			if(GenericUtil.isCollectionEmpty(activacionesInstalacion)) {
				return null;
			}
			else {
				return activacionesInstalacion;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ActivacionesPorDiaResultViewModel> listarActivacionesPorDia(ActivacionesPorDiaRequest request) {
		
		List<ActivacionesPorDiaResultViewModel> activacionesPorDia = new ArrayList<ActivacionesPorDiaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				activacionesPorDia = activacionesPorDiaJdbcRepository.listarActivacionesPorDia(request);
				if(GenericUtil.isCollectionEmpty(activacionesPorDia)) {
					return null;
				}
				else {
					return activacionesPorDia;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ActivacionesPorRangoResultViewModel> listarActivacionesPorRango(ActivacionesPorRangoRequest request) {
		
		List<ActivacionesPorRangoResultViewModel> activacionesPorRango = new ArrayList<ActivacionesPorRangoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				activacionesPorRango = activacionesPorRangoJdbcRepository.listarActivacionesPorRango(request);
				if(GenericUtil.isCollectionEmpty(activacionesPorRango)) {
					return null;
				}
				else {
					return activacionesPorRango;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spInsertActivacion(ActivacionRequest codigo) {

		try {
			
			if(GenericUtil.isNotNull(codigo)) {
				String result = activacionRequestJdbcRepository.spInsertActivacion(codigo);
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
