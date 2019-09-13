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

import com.dev.crm.core.dto.VendedoresResultViewModel;
import com.dev.crm.core.mapper.VendedoresResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("vendedorJdbcRepository")
public class VendedorCustomJdbcRepository implements VendedorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VendedoresResultViewModel> listarVendedores() {
		
		List<VendedoresResultViewModel> vendedores = new ArrayList<VendedoresResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_VENDEDORES);
			simpleJdbcCall.returningResultSet("vendedores", new VendedoresResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			vendedores = (List<VendedoresResultViewModel>) result.get("vendedores");
			return vendedores;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
