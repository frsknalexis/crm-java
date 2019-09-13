package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ClienteRequest;
import com.dev.crm.core.util.Constantes;

@Repository("inserccionClienteJdbcRepository")
public class InserccionClienteCustomJdbcRepository implements InserccionClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public void insertarCliente(ClienteRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_INSERCCION_CLIENTE)
						.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
								new SqlParameter("NOM_COM", Types.VARCHAR),
								new SqlParameter("ACT_CLI", Types.BOOLEAN),
								new SqlParameter("COR_CLI", Types.VARCHAR),
								new SqlParameter("FAX_CLI", Types.VARCHAR),
								new SqlParameter("COD_SEX", Types.INTEGER));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("COD_DOC", request.getDocumentoPersonaCliente());
			inParams.put("NOM_COM", request.getNombreComercialCliente());
			inParams.put("ACT_CLI", request.getEstado());
			inParams.put("COR_CLI", request.getCorreoCliente());
			inParams.put("FAX_CLI", request.getFacebookCliente());
			inParams.put("COD_SEX", request.getCodigoSexo());
			
			simpleJdbcCall.execute(inParams);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
