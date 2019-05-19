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

import com.dev.crm.core.dto.HerramientaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("InserccionHerramintaJdbcRepository")
public class InserccionHerramientaAtencionCustomJdbcRepository implements InserccionHerramintaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spinserccionHerramienta(HerramientaRequest inserther) {
		
		simpleJdbcCall.withProcedureName(Constantes.SP_INSERCCION_HERRAMIENTA);
		//simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
		//simpleJdbcCall.useInParameterNames("CDOCOMP", "CODDOC", "DNI_RUC", "PAGO", "COD_CAJ");
		simpleJdbcCall.declareParameters(new SqlParameter("OBS", Types.VARCHAR),
				new SqlParameter("CANT", Types.INTEGER),
				new SqlParameter("FECHAI", Types.DATE),
				new SqlParameter("FECHAF", Types.DATE),
				new SqlParameter("COD_TPH", Types.VARCHAR),
				new SqlOutParameter("MENSAJE", Types.VARCHAR));
		
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("OBS", inserther.getObservacion());
		inParams.put("CANT", inserther.getCantidad());
		inParams.put("FECHAI", inserther.getFechainicio());
		inParams.put("FECHAF", inserther.getFechafinal());
		inParams.put("COD_TPH", inserther.getTipoherramienta());
		inParams.put("COD_USU", inserther.getMensaje());
		
		Map<String, Object> out = simpleJdbcCall.execute(inParams);
		String result = (String) out.get("MENSAJE");
		return result;
	}
}
