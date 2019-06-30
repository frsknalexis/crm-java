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

import com.dev.crm.core.dto.PdfPagoDiaResultViewModel;
import com.dev.crm.core.mapper.PdfPagosDelDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("PdfPagoDiaJdbcRepository")
public class PdfPagoDiaCustomJdbcRepository implements PdfPagoDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PdfPagoDiaResultViewModel> spListaPlanilla(String usuario) {

		List<PdfPagoDiaResultViewModel> pago_pdf = new ArrayList<PdfPagoDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_PLANILLA);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR));
			
			simpleJdbcCall.returningResultSet("pago_pdf", new PdfPagosDelDiaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pago_pdf = (List<PdfPagoDiaResultViewModel>) result.get("pago_pdf");
			return pago_pdf;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
