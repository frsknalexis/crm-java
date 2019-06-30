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

import com.dev.crm.core.dto.PersonaClienteRequest;
import com.dev.crm.core.util.Constantes;

@Repository("editarPersonaClienteJdbcRepository")
public class EditarPersonaClienteCustomJdbcRepository implements EditarPersonaClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String updatePersonaCliente(PersonaClienteRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_UPDATE_PERSONA_CLIENTE);
			simpleJdbcCall.declareParameters(new SqlParameter("CODODC", Types.VARCHAR),
					new SqlParameter("APPA", Types.VARCHAR),
					new SqlParameter("APMA", Types.VARCHAR),
					new SqlParameter("NOPE", Types.VARCHAR),
					new SqlParameter("TEUN", Types.VARCHAR),
					new SqlParameter("TEDO", Types.VARCHAR),
					new SqlParameter("TETR", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODODC", request.getDocumentoPersonaCliente());
			inParams.put("APPA", request.getApellidoPaternoCliente());
			inParams.put("APMA", request.getApellidoMaternoCliente());
			inParams.put("NOPE", request.getNombrePersonaCliente());
			inParams.put("TEUN", request.getTelefonoUnoCliente());
			inParams.put("TEDO", request.getTelefonoDosCliente());
			inParams.put("TETR", request.getTelefonoTresCliente());
			
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
