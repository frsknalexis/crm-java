package com.dev.crm.core.repository.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.VentasPorInstalarResultViewModel;

@Repository("ventasPorInstalarJdbcRepository")
public class VentasPorInstalarCustomJdbcRepository implements VentasPorInstalarJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public List<VentasPorInstalarResultViewModel> listarVentasPorInstalar() {
		
		List<VentasPorInstalarResultViewModel> ventasPorInstalar = new ArrayList<VentasPorInstalarResultViewModel>();
		
		try {
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
