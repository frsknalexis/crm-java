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

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.mapper.HerramientaAtencionResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("herramientaAtencionJdbcRepository")
public class HerramientaAtencionCustomJdbcRepository implements HerramientaAtencionJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HerramientaResultViewModel> spListarHerramientaAtencion(String usuario)  {
		
		List<HerramientaResultViewModel> herramientas = new ArrayList<HerramientaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_HERRAMIENTA_GENERAL);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_USU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("herramientas", new HerramientaAtencionResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("COD_USU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			herramientas = (List<HerramientaResultViewModel>) result.get("herramientas");
			return herramientas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
