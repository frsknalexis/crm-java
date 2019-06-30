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

import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.mapper.InformeInstalacionDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("informeInstalacionDiaInternetJdbcRepository")
public class InformeInstalacionDiaInternetCustomJdbcRepository implements InformeInstalacionDiaInternetJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia() {
		
		List<InformeInstalacionDiaResultViewModel> informesInstalacionDia = new ArrayList<InformeInstalacionDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_INFORME_INSTALACION_DIA);
			simpleJdbcCall.returningResultSet("informesInstalacionDia", new InformeInstalacionDiaResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			informesInstalacionDia = (List<InformeInstalacionDiaResultViewModel>) result.get("informesInstalacionDia");
			return informesInstalacionDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
