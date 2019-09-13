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

import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("clienteJdbcRepository")
public class ClienteCustomRepository implements ClienteJdbcRepository {
	
	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ClienteResultViewModel spBuscarPersonaClienteVendedor(ClienteFiltroRequest filtro) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_BUSCAR_PERSONA_CLIENTE_VENDEDOR);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("COD_DOC", "CREADOP");
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
					new SqlParameter("CREADOP", Types.VARCHAR),
					new SqlOutParameter("VCLIENTE", Types.VARCHAR),
					new SqlOutParameter("VDOCUMENTO", Types.VARCHAR),
					new SqlOutParameter("VDIRECCION", Types.VARCHAR),
					new SqlOutParameter("VREFERENCIA", Types.VARCHAR),
					new SqlOutParameter("VANIO", Types.CHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("COD_DOC", filtro.getDocumentoPersona());
			inParams.put("CREADOP", filtro.getCreadoPor());
					
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			
			System.out.println(result);
			
			if(GenericUtil.isNotNull(result.get("VDOCUMENTO")) && GenericUtil.isNotNull(result.get("VCLIENTE"))
				&& GenericUtil.isNotNull(result.get("VDIRECCION")) && GenericUtil.isNotNull(result.get("VANIO"))) {
				ClienteResultViewModel cliente = new ClienteResultViewModel();
				cliente.setCliente((String) result.get("VCLIENTE"));
				cliente.setDocumentoPersona((String) result.get("VDOCUMENTO"));
				cliente.setDireccionPersona((String) result.get("VDIRECCION"));
				cliente.setReferenciaPersona((String) result.get("VREFERENCIA"));
				cliente.setAnio((Integer.valueOf((String) result.get("VANIO"))));
				return cliente;
			}
			else if(GenericUtil.isNull(result.get("VDOCUMENTO")) && GenericUtil.isNull(result.get("VCLIENTE"))
					&& GenericUtil.isNull(result.get("VDIRECCION")) && GenericUtil.isNull(result.get("VANIO"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
