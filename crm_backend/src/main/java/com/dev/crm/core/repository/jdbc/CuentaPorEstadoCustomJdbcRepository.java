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

import com.dev.crm.core.dto.CuentaPorEstadoRequest;
import com.dev.crm.core.dto.CuentaPorEstadoResultViewModel;
import com.dev.crm.core.mapper.CuentaPorEstadoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentaPorEstadoJdbcRepository")
public class CuentaPorEstadoCustomJdbcRepository implements CuentaPorEstadoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentaPorEstadoResultViewModel> listarCuentasPorEstado(CuentaPorEstadoRequest request) {
		
		List<CuentaPorEstadoResultViewModel> cuentasPorEstado = new ArrayList<CuentaPorEstadoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_ESTADO_CUENTA_POR_ESTADO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODEST", Types.INTEGER));
			simpleJdbcCall.returningResultSet("cuentasPorEstado", new CuentaPorEstadoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODEST", request.getCodigoEstado());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			cuentasPorEstado = (List<CuentaPorEstadoResultViewModel>) result.get("cuentasPorEstado");
			return cuentasPorEstado;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
