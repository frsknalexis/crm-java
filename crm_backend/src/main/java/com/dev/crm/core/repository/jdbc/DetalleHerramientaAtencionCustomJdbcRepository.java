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

import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("detalleherramintaJdbcRepository")

public class DetalleHerramientaAtencionCustomJdbcRepository implements DetalleHerramintaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spinsercciondetalleHerramienta(DetalleHerramientaRequest inserther) {
		
		simpleJdbcCall.withProcedureName(Constantes.SP_INSERCCION_DETALLE_HERRAMIENTA);
		simpleJdbcCall.declareParameters(
				new SqlParameter("COD_USU", Types.VARCHAR),
				new SqlParameter("CODIGE", Types.VARCHAR),
				new SqlParameter("PREGUNTAS", Types.VARCHAR),
				new SqlOutParameter("MENSAJE", Types.VARCHAR),
				new SqlOutParameter("DES", Types.VARCHAR));
		
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("COD_USU", inserther.getCodigousuario());
		inParams.put("CODIGE", inserther.getCodigoherramientareq());
		inParams.put("PREGUNTAS", inserther.getPreguntadescripcion());
		
		Map<String, Object> out = simpleJdbcCall.execute(inParams);
		
		inserther.setDescripcionherramienta((String) out.get("DES"));
		String result = (String) out.get("MENSAJE");
		return result;
	}
}
