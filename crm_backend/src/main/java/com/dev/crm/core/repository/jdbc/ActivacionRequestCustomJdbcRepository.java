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

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.util.Constantes;

@Repository("ActivacionRequestJdbcRepository")
public class ActivacionRequestCustomJdbcRepository implements ActivacionRequestJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spInsertActivacion(ActivacionRequest codigo) {

		simpleJdbcCall.withProcedureName(Constantes.SP_INSERCCION_ACTIVACION);
		simpleJdbcCall.declareParameters(new SqlParameter("codigo", Types.VARCHAR),
		new SqlOutParameter("mensaje", Types.VARCHAR));
				
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("codigo",codigo.getCodigo());
				
		Map<String, Object> out = simpleJdbcCall.execute(inParams);
		System.out.println(out);
		String result = (String) out.get("mensaje");
			
		return result;
		
	}

}
