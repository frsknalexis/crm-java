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

import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("observacionCuentaJdbcRepository")
public class ObservacionCuentaCustomJdbcRepository implements ObservacionCuentaJdbcRepository {
	
	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta) {
			
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_RECUPERAR_OBSERVACION);
			simpleJdbcCall.declareParameters(new SqlParameter("SERCOD", Types.INTEGER),
					new SqlOutParameter("VALOR", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("SERCOD", codigoDetalleCuenta);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			
			if(GenericUtil.isNotNull(out.get("VALOR"))) {
				ObservacionResultViewModel observacion = new ObservacionResultViewModel();
				observacion.setObservacion((String) out.get("VALOR"));
				return observacion;
			}
			else if(GenericUtil.isNull(out.get("VALOR"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
