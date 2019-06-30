package com.dev.crm.core.repository.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.mapper.ClienteGestorResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("clienteGestorJdbcRepository")
public class ClienteGestorCustomJdbcRepository implements ClienteGestorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteGestorResultViewModel> listarClienteGestor() {
		
		List<ClienteGestorResultViewModel> clientesGestor = new ArrayList<ClienteGestorResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CLIENTE_GESTOR);
			simpleJdbcCall.returningResultSet("clientesGestor", new ClienteGestorResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			clientesGestor = (List<ClienteGestorResultViewModel>) result.get("clientesGestor");
			return clientesGestor;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
