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

import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.util.Constantes;

@Repository("consecutivoPagoJdbcRepository")
public class ConsecutivoPagoCustomJdbcRepository implements ConsecutivoPagoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spInsertarConsecutivoPago(ConsecutivoPagoRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_INSERTAR_CONSECUTIVO_PAGO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODPAG", Types.INTEGER),
					new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlParameter("CANTPA", Types.FLOAT),
					new SqlParameter("CODCOMP", Types.INTEGER),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODPAG", request.getCodigoPago());
			inParams.put("CODUSU", request.getCodigoUsuario());
			inParams.put("CANTPA", request.getCantidadPago());
			inParams.put("CODCOMP", request.getCodigoComprobante());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
