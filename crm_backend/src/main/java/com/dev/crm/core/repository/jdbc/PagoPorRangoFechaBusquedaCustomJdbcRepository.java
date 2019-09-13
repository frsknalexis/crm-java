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

import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaRequest;
import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaResultViewModel;
import com.dev.crm.core.mapper.PagosPorRangoFechaBusquedaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagoPorRangoFechaBusquedaJdbcRepository")
public class PagoPorRangoFechaBusquedaCustomJdbcRepository implements PagoPorRangoFechaBusquedaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosPorRangoFechaBusquedaResultViewModel> spReporteListaPagosPorRangoFecha(
			PagosPorRangoFechaBusquedaRequest request) {
		
		List<PagosPorRangoFechaBusquedaResultViewModel> pagosPorRango = new ArrayList<PagosPorRangoFechaBusquedaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PAGOS_PDF_RANGO);
			simpleJdbcCall.declareParameters(new SqlParameter("FECHAI", Types.DATE),
					new SqlParameter("FECHAF", Types.DATE),
					new SqlParameter("CODUSU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("pagosPorRango", new PagosPorRangoFechaBusquedaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("FECHAI", request.getFechaInicial());
			inParams.addValue("FECHAF", request.getFechaFinal());
			inParams.addValue("CODUSU", request.getCodigoUsuario());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pagosPorRango = (List<PagosPorRangoFechaBusquedaResultViewModel>) result.get("pagosPorRango");
			return pagosPorRango;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
