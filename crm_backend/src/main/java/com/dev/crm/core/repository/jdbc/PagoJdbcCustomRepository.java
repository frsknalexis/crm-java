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

import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.util.Constantes;

@Repository("pagoJdbcRepository")
public class PagoJdbcCustomRepository implements PagoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spPagoServicio(PagoRequest pR) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_PAGO_SERVICIO);
			//simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			//simpleJdbcCall.useInParameterNames("CDOCOMP", "CODDOC", "DNI_RUC", "PAGO", "COD_CAJ");
			simpleJdbcCall.declareParameters(new SqlParameter("CDOCOMP", Types.INTEGER),
					new SqlParameter("CODDOC", Types.VARCHAR),
					new SqlParameter("DNI_RUC", Types.VARCHAR),
					new SqlParameter("PAGO", Types.FLOAT),
					new SqlParameter("COD_CAJ", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CDOCOMP", pR.getCodigoComprobante());
			inParams.put("CODDOC", pR.getDocumentoPersonaPago());
			inParams.put("DNI_RUC", pR.getDocumentoPersonaCliente());
			inParams.put("PAGO", pR.getCantidadPago());
			inParams.put("COD_CAJ", pR.getNumeroCaja());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("MENSAJE");
			return result;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
