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

import com.dev.crm.core.dto.DatosOnuInstalacionResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("ClienteOnuInstalacionResultJdbcRepository")
public class ClienteOnuInstalacionResultCustomJdbcRepository implements ClienteOnuInstalacionResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	@Override
	public DatosOnuInstalacionResultViewModel spBuscarDatos(String codigo) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_BUSCAR_DATOS_ONU_INSTALACION);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("COD");
			simpleJdbcCall.declareParameters(new SqlParameter("COD", Types.VARCHAR),
					new SqlOutParameter("sn", Types.VARCHAR),
					new SqlOutParameter("wp", Types.VARCHAR),
					new SqlOutParameter("wu", Types.VARCHAR),
					new SqlOutParameter("pd", Types.VARCHAR),
					new SqlOutParameter("md", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("COD", codigo);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("sn")) && GenericUtil.isNotNull(out.get("pd"))) {
				
				DatosOnuInstalacionResultViewModel cDatos = new DatosOnuInstalacionResultViewModel();
				cDatos.setMacDescripcion((String) out.get("md"));
				cDatos.setSnDescripcion((String) out.get("sn"));
				cDatos.setWinPassword((String) out.get("wp"));
				cDatos.setWinUser((String) out.get("wu"));
				cDatos.setPonDescripcion((String) out.get("pd"));
				return cDatos;
			}
			else if(GenericUtil.isNull(out.get("sn")) && GenericUtil.isNull(out.get("pd"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
