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

import com.dev.crm.core.dto.PagoPorDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.mapper.PagoPorDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagosPorDiaJdbcRepository")
public class PagosPorDiaCustomJdbcRepository implements PagosPorDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagoPorDiaResultViewModel> listarPagosPorDiaSolicitado(PagosPorDiaRequest request) {
		
		List<PagoPorDiaResultViewModel> pagosPorDia = new ArrayList<PagoPorDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PAGOS_DIA_SOLICITADO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlParameter("FECHAP", Types.DATE));
			simpleJdbcCall.returningResultSet("pagosPorDia", new PagoPorDiaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", request.getCodigoUsuario());
			inParams.addValue("FECHAP", request.getFechaBusqueda());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pagosPorDia = (List<PagoPorDiaResultViewModel>) result.get("pagosPorDia");
			return pagosPorDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
