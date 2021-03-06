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

import com.dev.crm.core.dto.PagoServicioGestorRequest;
import com.dev.crm.core.util.Constantes;

@Repository("pagoServicioGestorJdbcRepository")
public class PagoServicioGestorCustomJdbcRepository implements PagoServicioGestorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String realizarPagoServicioGestor(PagoServicioGestorRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_PAGO_SERVICIO_GESTOR)
				.declareParameters(new SqlParameter("DNIRUC", Types.VARCHAR),
						new SqlParameter("CODCMP", Types.INTEGER),
						new SqlParameter("DNIPAGA", Types.VARCHAR),
						new SqlParameter("CODUSU", Types.VARCHAR),
						new SqlParameter("CANTPAGO", Types.DECIMAL),
						new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DNIRUC", request.getDocumentoPersonaCliente());
			inParams.put("CODCMP", request.getCodigoComprobante());
			inParams.put("DNIPAGA", request.getDocumentoPersonaPago());
			inParams.put("CODUSU", request.getNombreGestor());
			inParams.put("CANTPAGO", request.getCantidadPago());
			
			
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
