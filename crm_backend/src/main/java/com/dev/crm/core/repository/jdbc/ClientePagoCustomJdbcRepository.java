package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.mapper.ClientePagoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("clientePagoJdbcRepository")
public class ClientePagoCustomJdbcRepository implements ClientePagoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientePagoResultViewModel> spListarClientesPago(String usuario) {
		
		List<ClientePagoResultViewModel> clientesPagos = new ArrayList<ClientePagoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CLIENTE_VENDEDOR);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_USU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("clientesPagos", new ClientePagoResultViewModelMapper());
			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("COD_USU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(in);
			clientesPagos = (List<ClientePagoResultViewModel>) result.get("clientesPagos");
			return clientesPagos;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
