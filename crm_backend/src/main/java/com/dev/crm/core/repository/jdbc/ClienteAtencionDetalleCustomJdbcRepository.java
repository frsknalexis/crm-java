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

import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;
import com.dev.crm.core.mapper.ClienteAtencionDetalleResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("clienteAtencionDetalleJdbcRepository")
public class ClienteAtencionDetalleCustomJdbcRepository implements ClienteAtencionDetalleJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteAtencionDetalleResultViewModel> spListarClientesAtencionDetalle(String documentoPersonaCliente) {
		
		List<ClienteAtencionDetalleResultViewModel> clientesAtencionDetalle = new ArrayList<ClienteAtencionDetalleResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CLIENTES_ATENCION_DETALLE);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("clientesAtencionDetalle", new ClienteAtencionDetalleResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("COD_DOC", documentoPersonaCliente);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			clientesAtencionDetalle = (List<ClienteAtencionDetalleResultViewModel>) result.get("clientesAtencionDetalle");
			return clientesAtencionDetalle;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
