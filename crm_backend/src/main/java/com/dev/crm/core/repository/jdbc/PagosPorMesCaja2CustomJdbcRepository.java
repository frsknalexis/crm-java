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

import com.dev.crm.core.dto.PagosPorMesCaja2ResultViewModel;
import com.dev.crm.core.mapper.PagosPorMesCaja2ResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagosPorMesCaja2JdbcRepository")
public class PagosPorMesCaja2CustomJdbcRepository implements PagosPorMesCaja2JdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosPorMesCaja2ResultViewModel> pagosPorMesCaja2() {
		
		List<PagosPorMesCaja2ResultViewModel> pagosPorMesCaja = new ArrayList<PagosPorMesCaja2ResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_PAGOS_POR_MES_CAJA2);
			simpleJdbcCall.returningResultSet("pagosPorMesCaja", new PagosPorMesCaja2ResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			pagosPorMesCaja = (List<PagosPorMesCaja2ResultViewModel>) result.get("pagosPorMesCaja");
			return pagosPorMesCaja;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
