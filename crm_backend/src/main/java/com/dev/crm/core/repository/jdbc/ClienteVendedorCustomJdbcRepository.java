package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ClienteVendedorResultViewModel;
import com.dev.crm.core.mapper.ClienteVendedorResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("clienteVendedorJdbcRepository")
public class ClienteVendedorCustomJdbcRepository implements ClienteVendedorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteVendedorResultViewModel> spListarClienteVendedor(String usuario) {
		
		List<ClienteVendedorResultViewModel> clientes = new ArrayList<ClienteVendedorResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CLIENTE_VENDEDOR);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_USU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("clientes", new ClienteVendedorResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("COD_USU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			clientes = (List<ClienteVendedorResultViewModel>) result.get("clientes");
			return clientes;
		}
		catch(Exception e) {
			
		}
		return null;
	}
}
