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

import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.mapper.DetallePagoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("DetallePagoResultJdbcRepository")
public class DetallePagoResultCustomJdbcRepository implements DetallePagoResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePagoResultViewModel> spListaDetallePago(String persona) {

		List<DetallePagoResultViewModel> Dpago = new ArrayList<DetallePagoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_DETALLE_PAGO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODDOC", Types.VARCHAR));
			
			simpleJdbcCall.returningResultSet("Dpago", new DetallePagoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODDOC", persona);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			Dpago = (List<DetallePagoResultViewModel>) result.get("Dpago");
			return Dpago;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
