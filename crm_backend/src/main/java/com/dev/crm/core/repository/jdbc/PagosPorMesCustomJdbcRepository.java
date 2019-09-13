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

import com.dev.crm.core.dto.PagosPorMesResultViewModel;
import com.dev.crm.core.mapper.PagosPorMesResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagosPorMesJdbcRepository")
public class PagosPorMesCustomJdbcRepository implements PagosPorMesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosPorMesResultViewModel> pagosPorMes() {
		
		List<PagosPorMesResultViewModel> pagosPorMes = new ArrayList<PagosPorMesResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_PAGO_POR_MES);
			simpleJdbcCall.returningResultSet("pagosPorMes", new PagosPorMesResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			pagosPorMes = (List<PagosPorMesResultViewModel>) result.get("pagosPorMes");
			return pagosPorMes;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
