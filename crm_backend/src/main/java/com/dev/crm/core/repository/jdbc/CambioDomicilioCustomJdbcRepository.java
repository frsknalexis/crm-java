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

import com.dev.crm.core.dto.CambioDireccionRequest;
import com.dev.crm.core.util.Constantes;

@Repository("cambioDomicilioJdbcRepository")
public class CambioDomicilioCustomJdbcRepository implements CambioDomicilioJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spModificarDomicilio(CambioDireccionRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CAMBIO_DOMICILIO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODODC", Types.VARCHAR),
					new SqlParameter("DIRHIS", Types.VARCHAR),
					new SqlParameter("OBSDET", Types.VARCHAR),
					new SqlParameter("FECHCLI", Types.DATE),
					new SqlParameter("VENDEDO", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODODC", request.getDocumentoPersonaCliente());
			inParams.put("DIRHIS", request.getNuevaDireccion());
			inParams.put("OBSDET", request.getObservacionCuenta());
			inParams.put("FECHCLI", request.getFechaElegida());
			inParams.put("VENDEDO", request.getVendedorResponsable());
			
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
