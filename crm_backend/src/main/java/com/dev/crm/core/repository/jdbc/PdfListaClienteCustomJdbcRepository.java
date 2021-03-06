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

import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.mapper.PdfClienteResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pdfListaClienteJdbcRepository")
public class PdfListaClienteCustomJdbcRepository implements PdfListaClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PdfClienteResultViewModel> spListarPdfCliente(String usuario) {
		
		List<PdfClienteResultViewModel> pdfClientes = new ArrayList<PdfClienteResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PDF_CLIENTE);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("pdfClientes", new PdfClienteResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pdfClientes = (List<PdfClienteResultViewModel>) result.get("pdfClientes");
			return pdfClientes;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
