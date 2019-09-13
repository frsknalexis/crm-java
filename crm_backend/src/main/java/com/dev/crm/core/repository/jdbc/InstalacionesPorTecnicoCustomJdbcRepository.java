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

import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.mapper.InstalacionesPorTecnicoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("instalacionesPorTecnicoJdbcRepository")
public class InstalacionesPorTecnicoCustomJdbcRepository implements InstalacionesPorTecnicoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico() {
		
		List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico = new ArrayList<InstalacionesPorTecnicoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_INSTALACIONES_POR_TECNICO);
			simpleJdbcCall.returningResultSet("instalacionesPorTecnico", new InstalacionesPorTecnicoResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			instalacionesPorTecnico = (List<InstalacionesPorTecnicoResultViewModel>) result.get("instalacionesPorTecnico");
			return instalacionesPorTecnico;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
