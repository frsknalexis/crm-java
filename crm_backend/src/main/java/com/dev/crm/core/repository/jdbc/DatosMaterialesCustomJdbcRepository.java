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

import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.util.Constantes;

@Repository("datosMaterialesJdbcRepository")
public class DatosMaterialesCustomJdbcRepository implements DatosMaterialesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spEnvioDatosMaterial(DatosMaterialesRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_ENVIO_DATOS_MATERIAL);
			simpleJdbcCall.declareParameters(new SqlParameter("CODMATVALUE", Types.VARCHAR),
					new SqlParameter("CANT_VALUE", Types.FLOAT),
					new SqlParameter("CODI_SER_VALUE", Types.INTEGER),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODMATVALUE", request.getNombreMaterial());
			inParams.put("CANT_VALUE", request.getCantidadMaterial());
			inParams.put("CODI_SER_VALUE", request.getCodigoInternetServicio());
			
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
