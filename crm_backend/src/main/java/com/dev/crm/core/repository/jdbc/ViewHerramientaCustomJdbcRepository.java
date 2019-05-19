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

import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.mapper.DetalleHerramientaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ViewHerramentaJdbcRepository")
public class ViewHerramientaCustomJdbcRepository implements ViewHerramentaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleHerramientaViewModel> soListarPregunta(String usuario)  {
		
		List<DetalleHerramientaViewModel> herramientas = new ArrayList<DetalleHerramientaViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PREGUNTAS);
			simpleJdbcCall.declareParameters(new SqlParameter("CODIHERR", Types.INTEGER));
			simpleJdbcCall.returningResultSet("herramientas", new DetalleHerramientaResultViewModelMapper());
			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("CODIHERR", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(in);
			herramientas = (List<DetalleHerramientaViewModel>) result.get("herramientas");
			return herramientas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
