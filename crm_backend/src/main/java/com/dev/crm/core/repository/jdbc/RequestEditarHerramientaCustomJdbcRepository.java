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

import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("RequestEditarHerramintaResultJdbcRepository")
public class RequestEditarHerramientaCustomJdbcRepository implements RequestEditarHerramintaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spEditarHerramienta(EditarHerramientaRequest CODIHERR){
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_EDITAR_HERRAMIENTA);
			simpleJdbcCall.declareParameters(new SqlParameter("CODIHERR", Types.INTEGER),
					new SqlParameter("DES", Types.VARCHAR),
					new SqlParameter("FECHAII", Types.VARCHAR),
					new SqlParameter("FECHAFF", Types.VARCHAR),
					new SqlParameter("SECUHERR", Types.INTEGER),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODIHERR", CODIHERR.getCodigoherramienta());
			inParams.put("DES", CODIHERR.getDescripcionherramienta());
			inParams.put("FECHAII", CODIHERR.getFechainicio());
			inParams.put("FECHAFF", CODIHERR.getFechafinal());
			inParams.put("SECUHERR", CODIHERR.getSecuencialherramienta());
			
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
