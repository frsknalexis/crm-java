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

import com.dev.crm.core.dto.MensajeNotiResultViewModel;
import com.dev.crm.core.util.Constantes;

@Repository("MensajeNotiResultJdbcRepository")
public class MensajeNotiResultCustomJdbcRepository implements MensajeNotiResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public MensajeNotiResultViewModel sorecuperdaddatos(String usuario) {
		
	try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_RECUPERAR_MENSAJE_NOTI);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("CODUSU");
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlOutParameter("VDATO", Types.VARCHAR),
					new SqlOutParameter("DES", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("CODUSU", usuario);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			MensajeNotiResultViewModel cMen = new MensajeNotiResultViewModel();
			cMen.setNombrepersona((String) out.get("VDATO"));
			cMen.setDescripcionmensaje((String) out.get("DES"));
			
			System.out.println(cMen);
			return cMen;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
