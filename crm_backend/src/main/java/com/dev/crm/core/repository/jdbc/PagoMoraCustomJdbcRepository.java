package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.util.Constantes;

@Repository("pagoMoraJdbcRepository")
public class PagoMoraCustomJdbcRepository implements PagoMoraJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spPagoMora(PagoMoraRequest pagoMora) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_PAGO_MORA);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
					new SqlParameter("COD_SER", Types.VARCHAR),
					new SqlParameter("COD_CMP", Types.INTEGER),
					new SqlParameter("DESCU", Types.FLOAT), 
					new SqlParameter("DOC_PAG", Types.VARCHAR),
					new SqlParameter("DBE", Types.FLOAT),
					new SqlParameter("PAGA", Types.FLOAT),
					new SqlParameter("MES", Types.INTEGER),
					new SqlParameter("COD_CAJ", Types.VARCHAR),
					new SqlParameter("ANIO", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("COD_DOC", pagoMora.getDocumentoPersonaClienteDeuda());
			inParams.put("COD_SER", pagoMora.getTipoServicio());
			inParams.put("COD_CMP", pagoMora.getCodigoComprobanteDeuda());
			inParams.put("DESCU", pagoMora.getDescuento());
			inParams.put("DOC_PAG", pagoMora.getDocumentoPersonaPagoDeuda());
			inParams.put("DBE", pagoMora.getMontoPagoDeuda());
			inParams.put("PAGA", pagoMora.getCantidadPagoDeuda());
			inParams.put("MES", pagoMora.getMes());
			inParams.put("COD_CAJ", pagoMora.getNumeroCaja());
			inParams.put("ANIO", Integer.toString(pagoMora.getAnioValido()));
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			String result = (String) out.get("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
