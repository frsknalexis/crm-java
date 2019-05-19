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

import com.dev.crm.core.dto.ValorHerramientaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("ValorHerramintaResultJdbcRepository")
public class ValorHerramientaResultCustomJdbcRepository implements ValorHerramintaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ValorHerramientaRequest spBuscarHerra(String codherra) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_BUSQUEDA_HERRAMIENTA);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("COD_HERRA");
			simpleJdbcCall.declareParameters(new SqlParameter("COD_HERRA", Types.INTEGER),
					new SqlOutParameter("VALOR", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("COD_HERRA", codherra);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			ValorHerramientaRequest cHerra = new ValorHerramientaRequest();
			cHerra.setDescripcionherramienta((String) out.get("VALOR"));
			return cHerra;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
