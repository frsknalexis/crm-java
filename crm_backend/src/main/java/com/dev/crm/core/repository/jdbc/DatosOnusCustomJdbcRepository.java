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

import com.dev.crm.core.dto.DatosOnuRequest;
import com.dev.crm.core.dto.DatosOnusResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("datosOnusJdbcRepository")
public class DatosOnusCustomJdbcRepository implements DatosOnusJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public DatosOnusResultViewModel spRecuperarDatosOnu(DatosOnuRequest request) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_DATOS_ONUS);
			simpleJdbcCall.declareParameters(new SqlParameter("SN", Types.VARCHAR),
					new SqlParameter("MAC", Types.VARCHAR),
					new SqlOutParameter("OUTMAC", Types.VARCHAR),
					new SqlOutParameter("OUTSN", Types.VARCHAR),
					new SqlOutParameter("OUTUSER", Types.VARCHAR),
					new SqlOutParameter("OUTPASS", Types.VARCHAR),
					new SqlOutParameter("OUTSSID", Types.VARCHAR),
					new SqlOutParameter("OUTWIFFIPASS", Types.VARCHAR),
					new SqlOutParameter("OUTESTADO", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("SN", request.getSnDescripcion());
			inParams.put("MAC", request.getMacDescripcion());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			
			if(GenericUtil.isNotNull(out.get("OUTMAC")) && GenericUtil.isNotNull(out.get("OUTSN"))) {
				
				DatosOnusResultViewModel datosOnu = new DatosOnusResultViewModel();
				datosOnu.setMacDescripcion((String) out.get("OUTMAC"));
				datosOnu.setSnDescripcion((String) out.get("OUTSN"));
				datosOnu.setWinUser((String) out.get("OUTUSER"));
				datosOnu.setWinPassword((String) out.get("OUTPASS"));
				datosOnu.setWifissidDescripcion((String) out.get("OUTSSID"));
				datosOnu.setWifiPasswordDescripcion((String) out.get("OUTWIFFIPASS"));
				datosOnu.setEstado((String) out.get("OUTESTADO"));
				return datosOnu;
			}
			else if(GenericUtil.isNull(out.get("OUTMAC")) && GenericUtil.isNull(out.get("OUTSN"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
