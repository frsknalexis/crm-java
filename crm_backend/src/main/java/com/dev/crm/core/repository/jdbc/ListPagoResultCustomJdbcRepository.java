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

import com.dev.crm.core.dto.DescuentoPagoResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("PagoListOutdbcRepository")
public class ListPagoResultCustomJdbcRepository implements PagoListOutdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public DescuentoPagoResultViewModel spRecuperarDatosPago(String persona) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_BUSCAR_DATOS_PAGOS_MES);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("val");
			simpleJdbcCall.declareParameters(new SqlParameter("val", Types.VARCHAR),
					new SqlOutParameter("OUTMES", Types.VARCHAR),
					new SqlOutParameter("OUTMONTO", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("val", persona);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("OUTMES")) && GenericUtil.isNotNull(out.get("OUTMONTO"))) {
				
				DescuentoPagoResultViewModel cPago = new DescuentoPagoResultViewModel();
				cPago.setMesvalidopago((String) out.get("OUTMES"));
				cPago.setMontoapagar((String) out.get("OUTMONTO"));
				return cPago;
			}
			else if(GenericUtil.isNull(out.get("OUTMES")) && GenericUtil.isNull(out.get("OUTMONTO"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
