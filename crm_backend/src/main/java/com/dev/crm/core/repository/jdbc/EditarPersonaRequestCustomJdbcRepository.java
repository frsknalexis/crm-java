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

import com.dev.crm.core.dto.PersonaRequestE;
import com.dev.crm.core.util.Constantes;

@Repository("EditarPersonaResultJdbcRepository")
public class EditarPersonaRequestCustomJdbcRepository implements EditarPersonaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spEditarPersona(PersonaRequestE valor) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_EDITAR_PERSONA);
			simpleJdbcCall.declareParameters(new SqlParameter("CODDOC", Types.VARCHAR),
					new SqlParameter("NOMBREPERSONA", Types.VARCHAR),
					new SqlParameter("PATERNO", Types.VARCHAR),
					new SqlParameter("MATERNO", Types.VARCHAR), 
					new SqlParameter("DIRECCIONRENIEC", Types.VARCHAR),
					new SqlParameter("DIRECCIONACTUAL", Types.VARCHAR),
					new SqlParameter("REFERENCIA", Types.VARCHAR),
					new SqlParameter("TELEFONOUNO", Types.VARCHAR),
					new SqlParameter("TELEFONODOS", Types.VARCHAR),
					new SqlParameter("TELEFONOTRES", Types.VARCHAR),
					new SqlParameter("MODIFICADOPOR", Types.VARCHAR),
					new SqlParameter("CODIGOUBIGEO", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODDOC", valor.getDocumentopersoma());
			inParams.put("NOMBREPERSONA", valor.getNombrepersona());
			inParams.put("PATERNO", valor.getPaternopersona());
			inParams.put("MATERNO", valor.getMaternopersona());
			inParams.put("DIRECCIONRENIEC", valor.getDireccionreniecpersona());
			inParams.put("DIRECCIONACTUAL", valor.getDireccionactualpersona());
			inParams.put("REFERENCIA", valor.getReferenciapersona());
			inParams.put("TELEFONOUNO", valor.getPrimertelefono());
			inParams.put("TELEFONODOS", valor.getSegundotelefono());
			inParams.put("TELEFONOTRES", valor.getTercertelefono());
			inParams.put("MODIFICADOPOR", valor.getModificadopor());
			inParams.put("CODIGOUBIGEO", valor.getCodigoubigeo());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("MENSAJE");
			System.out.print(result);
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
