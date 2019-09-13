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

import com.dev.crm.core.dto.GananciaPorMesCajaResultViewModel;
import com.dev.crm.core.mapper.GananciaPorMesCajaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("gananciaPorMesCajaJdbcRepository")
public class GananciaPorMesCajaCustomJdbcRepository implements GananciaPorMesCajaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GananciaPorMesCajaResultViewModel> ganaciaPorMesCaja() {
		
		List<GananciaPorMesCajaResultViewModel> gananciaPorMesCaja = new ArrayList<GananciaPorMesCajaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_GANANCIA_POR_MES_CAJA)
							.returningResultSet("gananciaPorMesCaja", new GananciaPorMesCajaResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			gananciaPorMesCaja = (List<GananciaPorMesCajaResultViewModel>) result.get("gananciaPorMesCaja");
			return gananciaPorMesCaja;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
