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

import com.dev.crm.core.dto.PagosPorMesCaja1ResultViewModel;
import com.dev.crm.core.mapper.PagosPorMesCaja1ResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagosPorMesCaja1JdbcRepository")
public class PagosPorMesCaja1CustomJdbcRepository implements PagosPorMesCaja1JdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosPorMesCaja1ResultViewModel> pagosPorMesCaja1() {
		
		List<PagosPorMesCaja1ResultViewModel> pagosPorMesCaja = new ArrayList<PagosPorMesCaja1ResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_PAGOS_POR_MES_CAJA1);
			simpleJdbcCall.returningResultSet("pagosPorMesCaja", new PagosPorMesCaja1ResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			pagosPorMesCaja = (List<PagosPorMesCaja1ResultViewModel>) result.get("pagosPorMesCaja");
			return pagosPorMesCaja;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
