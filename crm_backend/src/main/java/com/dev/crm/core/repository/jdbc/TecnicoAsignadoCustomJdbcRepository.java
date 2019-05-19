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

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;
import com.dev.crm.core.mapper.ComboTecnicoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("TecnicoAsignadoJdbcRepository")
public class TecnicoAsignadoCustomJdbcRepository implements TecnicoAsignadoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AsignarTecnicoComboResultViewModel> spComboTecnico(String persona) {
		
		List<AsignarTecnicoComboResultViewModel> asiganartecni = new ArrayList<AsignarTecnicoComboResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_COMBO_TECNICO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODOC", Types.VARCHAR));
			
			simpleJdbcCall.returningResultSet("asiganartecni", new ComboTecnicoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODOC", persona);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			asiganartecni = (List<AsignarTecnicoComboResultViewModel>) result.get("asiganartecni");
			return asiganartecni;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
