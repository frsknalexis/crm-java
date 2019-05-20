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

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.mapper.InstalacionDiaInternetResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("instalacionDiaInternetJdbcRepsitory")
public class InstalacionDiaInternetCustomJdbcRepository implements InstalacionDiaInternetJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public InstalacionDiaInternetCustomJdbcRepository(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario) {
		
		List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = new ArrayList<InstalacionDiaInternetResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_INSTALACION_DIA_INTERNET);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("instalacionesDiaInternet", new InstalacionDiaInternetResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			instalacionesDiaInternet = (List<InstalacionDiaInternetResultViewModel>) result.get("instalacionesDiaInternet");
			return instalacionesDiaInternet;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
