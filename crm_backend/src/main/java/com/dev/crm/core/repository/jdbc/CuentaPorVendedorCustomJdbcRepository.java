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

import com.dev.crm.core.dto.CuentaPorVendedorRequest;
import com.dev.crm.core.dto.CuentaPorVendedorResultViewModel;
import com.dev.crm.core.mapper.CuentaPorVendedorResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentaPorVendedorJdbcRepository")
public class CuentaPorVendedorCustomJdbcRepository implements CuentaPorVendedorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentaPorVendedorResultViewModel> cuentasPorVendedor(CuentaPorVendedorRequest request) {
		
		List<CuentaPorVendedorResultViewModel> cuentasPorVendedor = new ArrayList<CuentaPorVendedorResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CUENTAS_POR_VENDEDOR);
			simpleJdbcCall.declareParameters(new SqlParameter("NAMEVENDOR", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("cuentasPorVendedor", new CuentaPorVendedorResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("NAMEVENDOR", request.getVendedorResponsable());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			cuentasPorVendedor = (List<CuentaPorVendedorResultViewModel>) result.get("cuentasPorVendedor");
			return cuentasPorVendedor;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
