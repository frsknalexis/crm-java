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

import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.mapper.PagosPorDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagoPorDiaJdbcRepository")
public class PagoPorDiaCustomJdbcRepository implements PagoPorDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request) {
		
		List<PagosPorDiaResultViewModel> pagosPorDia = new ArrayList<PagosPorDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PAGOS_PDF_DIA);
			simpleJdbcCall.declareParameters(new SqlParameter("FECHADIA", Types.DATE),
					new SqlParameter("CODUSU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("pagosPorDia", new PagosPorDiaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("FECHADIA", request.getFechaBusqueda());
			inParams.addValue("CODUSU", request.getCodigoUsuario());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pagosPorDia = (List<PagosPorDiaResultViewModel>) result.get("pagosPorDia");
			return pagosPorDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
