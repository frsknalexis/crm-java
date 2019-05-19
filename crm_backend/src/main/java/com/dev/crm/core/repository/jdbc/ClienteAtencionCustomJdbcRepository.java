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

import com.dev.crm.core.dto.ClienteAtencionResultViewModel;
import com.dev.crm.core.mapper.ClienteAtencionResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("clienteAtencionJdbc")
public class ClienteAtencionCustomJdbcRepository implements ClienteAtencionJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteAtencionResultViewModel> spListarClientesAtencion() {
		
		List<ClienteAtencionResultViewModel> clientesAtencion = new ArrayList<ClienteAtencionResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CLIENTES_ATENCION)
					.returningResultSet("clientesAtencion", new ClienteAtencionResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			clientesAtencion = (List<ClienteAtencionResultViewModel>) result.get("clientesAtencion");
			return clientesAtencion;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
