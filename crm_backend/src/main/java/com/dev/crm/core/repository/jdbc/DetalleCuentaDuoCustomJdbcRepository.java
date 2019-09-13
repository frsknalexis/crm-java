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

import com.dev.crm.core.dto.DetalleCuentaDuoRequest;
import com.dev.crm.core.util.Constantes;

@Repository("detalleCuentaDuoJdbcRepository")
public class DetalleCuentaDuoCustomJdbcRepository implements DetalleCuentaDuoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String insercionCuentaDuo(DetalleCuentaDuoRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_INSERCION_CUENTA_DUO)
				.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
						new SqlParameter("OBS", Types.VARCHAR),
						new SqlParameter("CODUSU", Types.VARCHAR),
						new SqlParameter("FECHACLI", Types.DATE),
						new SqlParameter("NOMBREVENDEDOR", Types.VARCHAR),
						new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>(0);
			inParams.put("COD_DOC", request.getDocumentoPersonCliente());
			inParams.put("OBS", request.getObservacionDetalleCuenta());
			inParams.put("CODUSU", request.getCodigoUsuario());
			inParams.put("FECHACLI", request.getFechaSolicitudClienteDetalleCuenta());
			inParams.put("NOMBREVENDEDOR", request.getNombreVendedor());
			
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
