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

import com.dev.crm.core.dto.ModuloResultViewModel;
import com.dev.crm.core.mapper.ModuloResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ModuloResultJdbcRepository")
public class ModuloResultCustomJdbcRepository implements ModuloResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ModuloResultViewModel spListaModulo(String usuario,String numero) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_MODULO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR),
											new SqlParameter("CODNUM", Types.VARCHAR),
											new SqlOutParameter("VNUMERO", Types.VARCHAR),
											new SqlOutParameter("VMODULO", Types.VARCHAR));
			
			simpleJdbcCall.returningResultSet("modulo", new ModuloResultViewModelMapper());
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("CODUSU", usuario);
			inParam.put("CODNUM", numero);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			ModuloResultViewModel cMen = new ModuloResultViewModel();
			cMen.setNumeracionmodulo((String) out.get("VNUMERO"));
			cMen.setDescripcionmodulo((String) out.get("VMODULO"));
			return cMen;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
