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

import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;
import com.dev.crm.core.mapper.VentasPorVendedorResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ventasPorVendedorJdbcRepository")
public class VentasPorVendedorCustomJdbcRepository implements VentasPorVendedorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VentasPorVendedorResultViewModel> cantidadVentasPorVendedor() {
		
		List<VentasPorVendedorResultViewModel> ventasPorVendedor = new ArrayList<VentasPorVendedorResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_VENTAS_POR_VENDEDOR)
							.returningResultSet("ventasPorVendedor", new VentasPorVendedorResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			ventasPorVendedor = (List<VentasPorVendedorResultViewModel>) result.get("ventasPorVendedor");
			return ventasPorVendedor;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
