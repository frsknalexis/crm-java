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

import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;
import com.dev.crm.core.mapper.DeudasGestorMontoAcumuladoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("deudasGestorMontoAcumuladoJdbcRepository")
public class DeudasGestorMontoAcumuladoCustomJdbcRepository implements DeudasGestorMontoAcumuladoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeudasGestorMontoAcumuladoResultViewModel> listarDeudasGestorMontoAcumulado() {
		
		List<DeudasGestorMontoAcumuladoResultViewModel> listaDeudasGestorAcumulado = new ArrayList<DeudasGestorMontoAcumuladoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_RECUPERAR_DIAS_DEUDAS_GESTOR_MONTO_ACUMULADO)
				.returningResultSet("listaDeudasGestorAcumulado", new DeudasGestorMontoAcumuladoResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			listaDeudasGestorAcumulado = (List<DeudasGestorMontoAcumuladoResultViewModel>) result.get("listaDeudasGestorAcumulado");
			return listaDeudasGestorAcumulado;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
