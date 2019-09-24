package com.dev.crm.core.repository.jdbc;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.GananciaMesTotalResultViewModel;
import com.dev.crm.core.util.Constantes;

@Repository("gananciaMesTotalJdbcRepository")
public class GananciaMesTotalCustomJdbcRepository implements GananciaMesTotalJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public GananciaMesTotalResultViewModel contadorGananciaMesTotal() {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_GANANCIA_MES_TOTAL)
				.declareParameters(new SqlOutParameter("valor", Types.DECIMAL));
			
			Map<String, Object> out = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			GananciaMesTotalResultViewModel gananciaTotal = new GananciaMesTotalResultViewModel();
			gananciaTotal.setTotal((BigDecimal) out.get("valor"));
			return gananciaTotal;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
