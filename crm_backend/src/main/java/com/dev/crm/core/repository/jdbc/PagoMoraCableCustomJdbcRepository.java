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

import com.dev.crm.core.dto.PagoMoraCableRequest;
import com.dev.crm.core.util.Constantes;

@Repository("pagoMoraCableJdbcRepository")
public class PagoMoraCableCustomJdbcRepository implements PagoMoraCableJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String pagoMoraCable(PagoMoraCableRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_INSERCION_PAGO_MORA_CABLE)
					.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
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
			inParams.put("COD_DOC", request.getDocumentoPersonaClienteDeuda());
			inParams.put("COD_SER", request.getTipoServicio());
			inParams.put("COD_CMP", request.getCodigoComprobanteDeuda());
			inParams.put("DESCU", request.getDescuento());
			inParams.put("DOC_PAG", request.getDocumentoPersonaPagoDeuda());
			inParams.put("DBE", request.getMontoDeuda());
			inParams.put("PAGA", request.getMontoPago());
			inParams.put("MES", request.getMesPago());
			inParams.put("COD_CAJ", request.getCodigoCaja());
			inParams.put("ANIO", request.getAniValidoPago());
			
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
