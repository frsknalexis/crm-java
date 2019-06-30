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

import com.dev.crm.core.dto.DatosClienteResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("recuperarDatosClienteJdbcRepository")
public class RecuperarDatosClienteCustomJdbcRepository implements RecuperarDatosClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public DatosClienteResultViewModel recuperarDatosCliente(String documentoPersonaCliente) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_RECUPERAR_DATOS_EDIT_CLIENTE);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("DOCCOD");
			simpleJdbcCall.declareParameters(new SqlParameter("DOCCOD", Types.VARCHAR),
					new SqlOutParameter("VDOCU", Types.VARCHAR),
					new SqlOutParameter("VAPPA", Types.VARCHAR),
					new SqlOutParameter("VAPMA", Types.VARCHAR),
					new SqlOutParameter("VNOPE", Types.VARCHAR),
					new SqlOutParameter("VTEUN", Types.VARCHAR),
					new SqlOutParameter("VTEDO", Types.VARCHAR),
					new SqlOutParameter("VTETR", Types.VARCHAR),
					new SqlOutParameter("VDIAC", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DOCCOD", documentoPersonaCliente);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			System.out.println(result);
			
			if(GenericUtil.isNotNull(result.get("VDOCU")) && GenericUtil.isNotNull(result.get("VAPPA")) && GenericUtil.isNotNull(result.get("VAPMA"))
					&& GenericUtil.isNotNull(result.get("VNOPE"))) {
				
				DatosClienteResultViewModel clienteDatos = new DatosClienteResultViewModel();
				clienteDatos.setDocumentoPersonaCliente((String) result.get("VDOCU"));
				clienteDatos.setApellidoPaternoCliente((String) result.get("VAPPA"));
				clienteDatos.setApellidoMaternoCliente((String) result.get("VAPMA"));
				clienteDatos.setNombresCliente((String) result.get("VNOPE"));
				clienteDatos.setTelefonoUnoCliente((String) result.get("VTEUN"));
				clienteDatos.setTelefonoDosCliente((String) result.get("VTEDO"));
				clienteDatos.setTelefonoTresCliente((String) result.get("VTETR"));
				clienteDatos.setDireccionActualCliente((String) result.get("VDIAC"));
				return clienteDatos;
			}
			else if(GenericUtil.isNull(result.get("VDOCU")) && GenericUtil.isNull(result.get("VAPPA")) && GenericUtil.isNull(result.get("VAPMA"))
					&& GenericUtil.isNull(result.get("VNOPE"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
