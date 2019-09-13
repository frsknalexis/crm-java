package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;
import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DeudasPorGestorRequest;
import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.repository.jdbc.AsignarClienteGestorJdbcRepository;
import com.dev.crm.core.repository.jdbc.ClienteGestorJdbcRepository;
import com.dev.crm.core.repository.jdbc.DeudasGestorMontoAcumuladoJdbcRepository;
import com.dev.crm.core.repository.jdbc.DeudasGestoresJdbcRepository;
import com.dev.crm.core.repository.jdbc.DeudasPorGestorJdbcRepository;
import com.dev.crm.core.repository.jdbc.GestoresJdbcRepository;
import com.dev.crm.core.service.GestorService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("gestorService")
@Transactional("hibernateTransactionManager")
public class GestorServiceImpl implements GestorService {

	@Autowired
	@Qualifier("clienteGestorJdbcRepository")
	private ClienteGestorJdbcRepository clienteGestorJdbcRepository;
	
	@Autowired
	@Qualifier("asignarClienteGestorJdbcRepository")
	private AsignarClienteGestorJdbcRepository asignarClienteGestorJdbcRepository;
	
	@Autowired
	@Qualifier("gestoresJdbcRepository")
	private GestoresJdbcRepository gestoresJdbcRepository;
	
	@Autowired
	@Qualifier("deudasGestoresJdbcRepository")
	private DeudasGestoresJdbcRepository deudasGestoresJdbcRepository;
	
	@Autowired
	@Qualifier("deudasPorGestorJdbcRepository")
	private DeudasPorGestorJdbcRepository deudasPorGestorJdbcRepository;
	
	@Autowired
	@Qualifier("deudasGestorMontoAcumuladoJdbcRepository")
	private DeudasGestorMontoAcumuladoJdbcRepository deudasGestorMontoAcumuladoJdbcRepository;
	
	@Override
	public List<ClienteGestorResultViewModel> listarClienteGestor() {
		
		List<ClienteGestorResultViewModel> clientesGestor = new ArrayList<ClienteGestorResultViewModel>();
		
		try {
			
			clientesGestor = clienteGestorJdbcRepository.listarClienteGestor();
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
	public String updateClienteGestor(ClienteGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = asignarClienteGestorJdbcRepository.updateClienteGestor(request);
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
	public List<DeudasPorGestorResultViewModel> listarDeudasPorGestor(DeudasPorGestorRequest request) {

		List<DeudasPorGestorResultViewModel> deudasPorGestor = new ArrayList<DeudasPorGestorResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				deudasPorGestor = deudasPorGestorJdbcRepository.listarDeudasPorGestor(request);
				if(GenericUtil.isCollectionEmpty(deudasPorGestor)) {
					return null;
				}
				else {
					return deudasPorGestor;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DeudasGestoresResultViewModel> recuperarDiasDeudasGestoresParametrizado(DiasDeudasRequest request) {
		
		List<DeudasGestoresResultViewModel> deudasGestores = new ArrayList<DeudasGestoresResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				deudasGestores = deudasGestoresJdbcRepository.recuperarDiasDeudasGestoresParametrizado(request);
				if(GenericUtil.isCollectionEmpty(deudasGestores) && deudasGestores.isEmpty()) {
					return null;
				}
				else  {
					return deudasGestores;
				}
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
			
			gestores = gestoresJdbcRepository.listarGestores();
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
	public List<DeudasGestorMontoAcumuladoResultViewModel> listarDeudasGestorMontoAcumulado() {
		
		List<DeudasGestorMontoAcumuladoResultViewModel> listaDeudasGestorAcumulado = new ArrayList<DeudasGestorMontoAcumuladoResultViewModel>();
		
		try {
			
			listaDeudasGestorAcumulado = deudasGestorMontoAcumuladoJdbcRepository.listarDeudasGestorMontoAcumulado();
			if(GenericUtil.isCollectionEmpty(listaDeudasGestorAcumulado)) {
				return null;
			}
			else {
				return listaDeudasGestorAcumulado;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
