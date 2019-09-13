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

import com.dev.crm.core.dto.CuentasInstaladasRequest;
import com.dev.crm.core.dto.CuentasInstaladasResultViewModel;
import com.dev.crm.core.mapper.CuentasInstaladasResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentasInstaladasJdbcRepository")
public class CuentasInstaladasCustomJdbcRepository implements CuentasInstaladasJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentasInstaladasResultViewModel> listarCuentasInstaladasPorFecha(CuentasInstaladasRequest request) {
		
		List<CuentasInstaladasResultViewModel> cuentasInstaladas = new ArrayList<CuentasInstaladasResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CUENTAS_INSTALADAS_RANGO_FECHA)
						.declareParameters(new SqlParameter("FECHAI", Types.DATE),
								new SqlParameter("FECHAF", Types.DATE))
						.returningResultSet("cuentasInstaladas", new CuentasInstaladasResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("FECHAI", request.getFechaInicial());
			inParams.addValue("FECHAF", request.getFechaFinal());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			cuentasInstaladas = (List<CuentasInstaladasResultViewModel>) result.get("cuentasInstaladas");
			return cuentasInstaladas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
