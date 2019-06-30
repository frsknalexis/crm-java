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

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.util.Constantes;

@Repository("datosOnuInstalacionJdbcRepository")
public class DatosOnuInstalacionCustomJdbcRepository implements DatosOnuInstalacionJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String envioDatosOnu(DatosOnuInstalacionRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_ENVIO_DATOS_ONU);
			simpleJdbcCall.declareParameters(new SqlParameter("CODDET", Types.INTEGER),
					new SqlParameter("DNIRUC", Types.VARCHAR),
					new SqlParameter("SERIE", Types.VARCHAR),
					new SqlParameter("MAC", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODDET", request.getCodigoDetalleCuenta());
			inParams.put("DNIRUC", request.getDocumentoPersonaCliente());
			inParams.put("SERIE", request.getSerieOnu());
			inParams.put("MAC", request.getMacOnu());
			
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
