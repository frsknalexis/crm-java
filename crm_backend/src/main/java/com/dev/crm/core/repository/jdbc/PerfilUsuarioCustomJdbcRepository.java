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

import com.dev.crm.core.dto.PerfilUsuarioResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("perfilUsuarioJdbcRepository")
public class PerfilUsuarioCustomJdbcRepository implements PerfilUsuarioJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public PerfilUsuarioResultViewModel perfilUsuario(String usuario) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_PERFIL_USUARIO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlOutParameter("AP", Types.VARCHAR),
					new SqlOutParameter("NOM", Types.VARCHAR),
					new SqlOutParameter("NU", Types.VARCHAR),
					new SqlOutParameter("CON", Types.VARCHAR),
					new SqlOutParameter("DIR", Types.VARCHAR),
					new SqlOutParameter("TEL", Types.VARCHAR),
					new SqlOutParameter("DESCA", Types.VARCHAR),
					new SqlOutParameter("CONCA", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODUSU", usuario);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("AP")) && GenericUtil.isNotNull(out.get("NOM")) && GenericUtil.isNotNull(out.get("NU"))
				&& GenericUtil.isNotNull(out.get("CON")) && GenericUtil.isNotNull(out.get("DIR")) && GenericUtil.isNotNull(out.get("TEL"))
				&& GenericUtil.isNotNull(out.get("DESCA")) && GenericUtil.isNotNull(out.get("CONCA"))) {
				
				PerfilUsuarioResultViewModel perfilUsuario = new PerfilUsuarioResultViewModel();
				perfilUsuario.setApellidosUsuario((String) out.get("AP"));
				perfilUsuario.setNombresUsuario((String) out.get("NOM"));
				perfilUsuario.setUsuario((String) out.get("NU"));
				perfilUsuario.setPasswordUsuario((String) out.get("CON"));
				perfilUsuario.setDireccionUsuario((String) out.get("DIR"));
				perfilUsuario.setTelefonoUsuario((String) out.get("TEL"));
				perfilUsuario.setCargoUsuario((String) out.get("DESCA"));
				perfilUsuario.setDescripcionCargo((String) out.get("CONCA"));
				return perfilUsuario;
			}
			else if(GenericUtil.isNull(out.get("AP")) && GenericUtil.isNull(out.get("NOM")) && GenericUtil.isNull(out.get("NU"))
					&& GenericUtil.isNull(out.get("CON")) && GenericUtil.isNull(out.get("DIR")) && GenericUtil.isNull(out.get("TEL"))
					&& GenericUtil.isNull(out.get("DESCA")) && GenericUtil.isNull(out.get("CONCA"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
