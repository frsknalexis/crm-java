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

import com.dev.crm.core.dto.InsertarTecnicTareaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("EditarTecnicoReclamoRequesJdbcRepository")
public class EditarTecnicoReclamoCustomJdbcRepository implements EditarTecnicoReclamoRequesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String speditrecltec(InsertarTecnicTareaRequest codoc) {

		simpleJdbcCall.withProcedureName(Constantes.SP_EDITAR_RECLAMO_TECNICO);
		/*simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
		simpleJdbcCall.useInParameterNames("CODOC");*/
		simpleJdbcCall.declareParameters(new SqlParameter("CODOC", Types.VARCHAR),
				new SqlParameter("DES", Types.VARCHAR),
				new SqlParameter("CODUSU", Types.VARCHAR),
				new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("CODOC", codoc.getDatovaluar());
		inParams.put("DES", codoc.getDescripciontarea());
		inParams.put("CODUSU", codoc.getCodigousuario());
			
		Map<String, Object> out = simpleJdbcCall.execute(inParams);
		System.out.println(out);
		String result = (String) out.get("MENSAJE");
		return result;
	}

}
