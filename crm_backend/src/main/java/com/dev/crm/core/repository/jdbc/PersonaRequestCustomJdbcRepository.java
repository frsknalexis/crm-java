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

import com.dev.crm.core.dto.PersonaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("PersonaRequestJdbcRepository")
public class PersonaRequestCustomJdbcRepository implements PersonaRequestJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spInsertarPersona(PersonaRequest valor) {

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_AGREGAR_PERSONA);
			simpleJdbcCall.declareParameters(new SqlParameter("DOCPER", Types.VARCHAR),
					new SqlParameter("NOMBREPERSONA", Types.VARCHAR),
					new SqlParameter("PATERNOPERSONA", Types.VARCHAR),
					new SqlParameter("MATERNOPERSONA", Types.VARCHAR), 
					new SqlParameter("DIRECCIONPERSONAR", Types.VARCHAR),
					new SqlParameter("DIRECCIONPERSONA", Types.VARCHAR),
					new SqlParameter("REFERENCIAPERSONA", Types.VARCHAR),
					new SqlParameter("PRIMERTELEFONO", Types.VARCHAR),
					new SqlParameter("SEGUNDOTELEFONO", Types.VARCHAR),
					new SqlParameter("TERCERTELEFONO", Types.VARCHAR),
					new SqlParameter("IPMAQUINAS", Types.VARCHAR),
					new SqlParameter("CREADOPOR", Types.VARCHAR),
					new SqlParameter("USUARIOMAQUINA", Types.VARCHAR),
					new SqlParameter("USUARIOSISTEMA", Types.VARCHAR),
					new SqlParameter("CODIGOUBIGEO", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DOCPER", valor.getDocumentopersoma());
			inParams.put("NOMBREPERSONA", valor.getNombrepersona());
			inParams.put("PATERNOPERSONA", valor.getPaternopersona());
			inParams.put("MATERNOPERSONA", valor.getMaternopersona());
			inParams.put("DIRECCIONPERSONAR", valor.getDireccionreniecpersona());
			inParams.put("DIRECCIONPERSONA", valor.getDireccionactualpersona());
			inParams.put("REFERENCIAPERSONA", valor.getReferenciapersona());
			inParams.put("PRIMERTELEFONO", valor.getPrimertelefono());
			inParams.put("SEGUNDOTELEFONO", valor.getSegundotelefono());
			inParams.put("TERCERTELEFONO", valor.getTercertelefono());
			inParams.put("IPMAQUINAS", valor.getIpmaquina());
			inParams.put("CREADOPOR", valor.getCreadopor());
			inParams.put("USUARIOMAQUINA", valor.getUsuariomaquina());
			inParams.put("USUARIOSISTEMA", valor.getUsuariosistema());
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
