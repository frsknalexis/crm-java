package com.dev.crm.core.repository.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.GananciaPorDiaCajaResultViewModel;
import com.dev.crm.core.mapper.GananciaPorDiaCajaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("gananciaPorDiaCajaJdbcRepository")
public class GananciaPorDiaCustomJdbcRepository implements GananciaPorDiaCajaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja() {
		
		List<GananciaPorDiaCajaResultViewModel> gananciaPorDiaCaja = new ArrayList<GananciaPorDiaCajaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_GANANCIA_POR_DIA_CAJA)
						.returningResultSet("gananciaPorDiaCaja", new GananciaPorDiaCajaResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			gananciaPorDiaCaja = (List<GananciaPorDiaCajaResultViewModel>) result.get("gananciaPorDiaCaja");
			return gananciaPorDiaCaja;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
