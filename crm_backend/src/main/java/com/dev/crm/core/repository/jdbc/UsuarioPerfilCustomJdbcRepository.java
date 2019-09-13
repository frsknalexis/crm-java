package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.UsuarioPerfilRequest;
import com.dev.crm.core.util.Constantes;

@Repository("usuarioPerfilJdbcRepository")
public class UsuarioPerfilCustomJdbcRepository implements UsuarioPerfilJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public void actualizarPerfilPassword(UsuarioPerfilRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_UPDATE_USUARIO_PERFIL);
			simpleJdbcCall.declareParameters(new SqlParameter("ENPA", Types.VARCHAR),
					new SqlParameter("CONT", Types.VARCHAR),
					new SqlParameter("CODUSU", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("ENPA", request.getEncryptedPasswordActual());
			inParams.put("CONT", request.getPasswordActual());
			inParams.put("CODUSU", request.getUsuario());
			
			simpleJdbcCall.execute(inParams);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
