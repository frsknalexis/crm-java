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

import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("EditarPreguntaResultJdbcRepository")
public class EditarPreguntaResultCustomJdbcRepository implements EditarPreguntaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spBuscarDatosEditar(EditarPreguntaRequest codherra) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_EDITAR_PREGUNTA);
			simpleJdbcCall.declareParameters(
					new SqlParameter("CODEHERR", Types.INTEGER),
					new SqlParameter("DES", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODEHERR", codherra.getCodigodetalleherramienta());
			inParams.put("DES", codherra.getPregunta());
			
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
