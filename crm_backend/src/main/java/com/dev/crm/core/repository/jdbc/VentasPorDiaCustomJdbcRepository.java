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

import com.dev.crm.core.dto.VentasPorDiaResultViewModel;
import com.dev.crm.core.mapper.VentasPorDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ventasPorDiaJdbcRepository")
public class VentasPorDiaCustomJdbcRepository implements VentasPorDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VentasPorDiaResultViewModel> cantidadVentasPorDia() {
		
		List<VentasPorDiaResultViewModel> ventasPorDia = new ArrayList<VentasPorDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_CANTIDAD_VENTAS_POR_DIA)
					.returningResultSet("ventasPorDia", new VentasPorDiaResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			ventasPorDia = (List<VentasPorDiaResultViewModel>) result.get("ventasPorDia");
			return ventasPorDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
