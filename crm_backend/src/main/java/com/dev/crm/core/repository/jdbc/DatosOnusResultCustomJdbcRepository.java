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

import com.dev.crm.core.dto.DatosOnusResultViewModel;
import com.dev.crm.core.util.Constantes;

@Repository("DatosOnusJdbcRepository")
public class DatosOnusResultCustomJdbcRepository implements DatosOnusJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public DatosOnusResultViewModel spRecuperarDatos(String sn, String mac) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_DATOS_ONUS);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("SN","MAC");
			simpleJdbcCall.declareParameters(new SqlParameter("SN", Types.VARCHAR),
					new SqlParameter("MAC", Types.VARCHAR),
					new SqlOutParameter("OUTMAC", Types.VARCHAR),
					new SqlOutParameter("OUTSN", Types.VARCHAR),
					new SqlOutParameter("OUTUSER", Types.VARCHAR),
					new SqlOutParameter("OUTPASS", Types.VARCHAR),
					new SqlOutParameter("OUTSSID", Types.VARCHAR),
					new SqlOutParameter("OUTWIFFIPASS", Types.VARCHAR),
					new SqlOutParameter("OUTESTADO", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("SN", sn);
			inParam.put("MAC", mac);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			DatosOnusResultViewModel cDaOn = new DatosOnusResultViewModel();
			cDaOn.setOutmacvalor((String) out.get("OUTMAC"));
			cDaOn.setOutsnvalor((String) out.get("OUTSN"));
			cDaOn.setOutuservalor((String) out.get("OUTUSER"));
			cDaOn.setOutpassvalor((String) out.get("OUTPASS"));
			cDaOn.setOutssidvalor((String) out.get("OUTSSID"));
			cDaOn.setOutwifipassvalor((String) out.get("OUTWIFFIPASS"));
			cDaOn.setOutestadovalor((String) out.get("OUTESTADO"));
			
			System.out.println(out);
			return cDaOn;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
