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

import com.dev.crm.core.dto.InsertarReclamoRequest;
import com.dev.crm.core.util.Constantes;

@Repository("InserccionReclamoResultJdbcRepository")
public class InserccionReclamoCustomJdbcRepository implements InserccionReclamoResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spInsertarReclamo(InsertarReclamoRequest codirecl) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_GUARDAR_RECLAMO);
			simpleJdbcCall.declareParameters(
					new SqlParameter("COD_USU", Types.VARCHAR),
					new SqlParameter("DESC_REC", Types.VARCHAR),
					new SqlParameter("DNI_RUC", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("COD_USU", codirecl.getCodigousuario());
			inParams.put("DESC_REC", codirecl.getDescripcionreclamo());
			inParams.put("DNI_RUC", codirecl.getDocumento());
			
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
