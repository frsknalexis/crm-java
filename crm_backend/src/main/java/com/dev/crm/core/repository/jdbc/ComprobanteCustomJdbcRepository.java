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

import com.dev.crm.core.dto.ComprobanteResultViewModel;
import com.dev.crm.core.mapper.ComprobanteResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("comprobanteJdbcRepository")
public class ComprobanteCustomJdbcRepository implements ComprobanteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComprobanteResultViewModel> spListarComprobante() {
		
		List<ComprobanteResultViewModel> comprobantes = new ArrayList<ComprobanteResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_COMPROBANTE)
							.returningResultSet("comprobantesResult", new ComprobanteResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			comprobantes = (List<ComprobanteResultViewModel>) result.get("comprobantesResult");
			return comprobantes;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
