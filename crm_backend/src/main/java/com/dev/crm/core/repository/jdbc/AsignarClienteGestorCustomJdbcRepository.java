package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.util.Constantes;

@Repository("asignarClienteGestorJdbcRepository")
public class AsignarClienteGestorCustomJdbcRepository implements AsignarClienteGestorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String updateClienteGestor(ClienteGestorRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_UPDATE_CLIENTE_GESTOR);
			simpleJdbcCall.declareParameters(new SqlParameter("DNIRUCIN", Types.VARCHAR),
					new SqlParameter("GESTORIN", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DNIRUCIN", request.getDocumentoPersonaCliente());
			inParams.put("GESTORIN", request.getGestorResponsable());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
