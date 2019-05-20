package com.dev.crm.core.repository.jdbc;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.util.Constantes;

@Repository("servicioInternetJdbcRepository")
public class ServicioInternetCustomJdbcRepository implements ServicioInternetJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public ServicioInternetCustomJdbcRepository(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public void spUpdateServicioInternet(Integer codigoServicioInternet) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_UPDATE_SERVICIO_INTERNET);
			simpleJdbcCall.declareParameters(new SqlParameter("CODSERIN", Types.INTEGER));
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODSERIN", codigoServicioInternet);
			
			simpleJdbcCall.execute(inParams);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
