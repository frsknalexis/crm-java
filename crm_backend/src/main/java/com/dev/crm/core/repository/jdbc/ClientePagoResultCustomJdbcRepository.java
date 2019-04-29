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

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.util.Constantes;

@Repository("clientePagoResultJdbcRepository")
public class ClientePagoResultCustomJdbcRepository implements ClientePagoResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ClientePagoResultViewModel spBuscarClientePago(String documentoPersona) {
	
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_BUSCAR_CLIENTE_PAGO);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("COD_DOC");
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
					new SqlOutParameter("VDOCUMENTO", Types.VARCHAR),
					new SqlOutParameter("VNOMBRECOMERCIAL", Types.VARCHAR),
					new SqlOutParameter("VCLIENTE", Types.VARCHAR),
					new SqlOutParameter("VDIRECCION", Types.VARCHAR),
					new SqlOutParameter("VREFERENCIA", Types.VARCHAR));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("COD_DOC", documentoPersona);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			ClientePagoResultViewModel cPago = new ClientePagoResultViewModel();
			cPago.setDireccionActualCliente((String) out.get("VDIRECCION"));
			cPago.setCliente((String) out.get("VCLIENTE"));
			cPago.setDocumentoPersonaCliente((String) out.get("VDOCUMENTO"));
			cPago.setReferencia((String) out.get("VREFERENCIA"));
			cPago.setNombreComercialCliente((String) out.get("VNOMBRECOMERCIAL"));
			return cPago;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
