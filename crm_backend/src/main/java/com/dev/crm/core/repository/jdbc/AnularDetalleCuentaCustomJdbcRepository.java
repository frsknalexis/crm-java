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

@Repository("anularDetalleCuentaJdbcRepository")
public class AnularDetalleCuentaCustomJdbcRepository implements AnularDetalleCuentaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public void spUpdateDetalleCuenta(Integer codigoDetalleCuenta) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_UPDATE_DETALLE_CUENTA);
			simpleJdbcCall.declareParameters(new SqlParameter("CODDET", Types.INTEGER));
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODDET", codigoDetalleCuenta);
			
			simpleJdbcCall.execute(inParams);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
