package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.DeudasPorGestorRequest;
import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;
import com.dev.crm.core.mapper.DeudasPorGestorResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("deudasPorGestorJdbcRepository")
public class DeudasPorGestorCustomJdbcRepository implements DeudasPorGestorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeudasPorGestorResultViewModel> listarDeudasPorGestor(DeudasPorGestorRequest request) {
		
		List<DeudasPorGestorResultViewModel> deudasPorGestor = new ArrayList<DeudasPorGestorResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_RECUPERAR_DEUDAS_POR_GESTOR)
					.declareParameters(new SqlParameter("TEXTO", Types.VARCHAR))
					.returningResultSet("deudasPorGestor", new DeudasPorGestorResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("TEXTO", request.getGestorResponsable());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			deudasPorGestor = (List<DeudasPorGestorResultViewModel>) result.get("deudasPorGestor");
			return deudasPorGestor;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
