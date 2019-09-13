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

import com.dev.crm.core.dto.CuentasRangoRequest;
import com.dev.crm.core.dto.CuentasRangoResultViewModel;
import com.dev.crm.core.mapper.CuentasRangoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentaPorRangoJdbcRepository")
public class CuentaPorRangoCustomJdbcRepository implements CuentaPorRangoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentasRangoResultViewModel> listarCuentasPorRango(CuentasRangoRequest request) {
		
		List<CuentasRangoResultViewModel> cuentasPorRango = new ArrayList<CuentasRangoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CUENTAS_RANGO_SOLICITADO);
			simpleJdbcCall.declareParameters(new SqlParameter("FECHAI", Types.DATE),
					new SqlParameter("FECHAF", Types.DATE));
			simpleJdbcCall.returningResultSet("cuentasPorRango", new CuentasRangoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("FECHAI", request.getFechaInicio());
			inParams.addValue("FECHAF", request.getFechaFin());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			cuentasPorRango = (List<CuentasRangoResultViewModel>) result.get("cuentasPorRango");
			return cuentasPorRango;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
