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

import com.dev.crm.core.dto.CuentaRequest;
import com.dev.crm.core.dto.CuentasResultViewModel;
import com.dev.crm.core.mapper.CuentasResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentaPorDiaJdbcRepository")
public class CuentaPorDiaCustomJdbcRepository implements CuentaPorDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentasResultViewModel> listarCuentasPorDia(CuentaRequest request) {
		
		List<CuentasResultViewModel> cuentasPorDia = new ArrayList<CuentasResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CUENTAS_DIA_SOLICITADO);
			simpleJdbcCall.declareParameters(new SqlParameter("FECHAP", Types.DATE));
			simpleJdbcCall.returningResultSet("cuentasPorDia", new CuentasResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("FECHAP", request.getFechaBusqueda());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			cuentasPorDia = (List<CuentasResultViewModel>) result.get("cuentasPorDia");
			return cuentasPorDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
