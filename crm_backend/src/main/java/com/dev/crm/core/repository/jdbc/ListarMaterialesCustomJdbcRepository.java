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

import com.dev.crm.core.dto.MaterialResultViewModel;
import com.dev.crm.core.mapper.MaterialResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("listarMaterialesJdbcRepository")
public class ListarMaterialesCustomJdbcRepository implements ListarMaterialesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaterialResultViewModel> spListarMaterial() {
		
		List<MaterialResultViewModel> materiales = new ArrayList<MaterialResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_MATERIAL);
			simpleJdbcCall.returningResultSet("materiales", new MaterialResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>());
			materiales = (List<MaterialResultViewModel>) result.get("materiales");
			return materiales;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
