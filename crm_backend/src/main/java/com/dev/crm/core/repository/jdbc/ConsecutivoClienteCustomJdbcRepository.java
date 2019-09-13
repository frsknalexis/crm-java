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

import com.dev.crm.core.dto.CodigoConsecutivoClienteRequest;
import com.dev.crm.core.dto.CodigoConsecutivoClienteResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("consecutivoClienteJdbcRepository")
public class ConsecutivoClienteCustomJdbcRepository implements ConsecutivoClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	 }
	
	@Override
	public CodigoConsecutivoClienteResultViewModel generarCodigoConsecutivoCliente(CodigoConsecutivoClienteRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.RECUPERAR_CODIGO_CONSECUTIVO_CLIENTE)
					.declareParameters(new SqlParameter("DNIRUC", Types.VARCHAR),
							new SqlOutParameter("DNIOUT", Types.VARCHAR),
							new SqlOutParameter("NOMBREOUT", Types.VARCHAR),
							new SqlOutParameter("PATERNO", Types.VARCHAR),
							new SqlOutParameter("MATERNO", Types.VARCHAR),
							new SqlOutParameter("TELEFONOU", Types.VARCHAR),
							new SqlOutParameter("CORREO", Types.VARCHAR),
							new SqlOutParameter("EMPRESA", Types.VARCHAR));
		
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DNIRUC", request.getDocumentoPersonaCliente());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("DNIOUT"))) {
				
				CodigoConsecutivoClienteResultViewModel codigoCliente = new CodigoConsecutivoClienteResultViewModel();
				codigoCliente.setDocumentoCliente((String) out.get("DNIOUT"));
				codigoCliente.setNombreCliente((String) out.get("NOMBREOUT"));
				codigoCliente.setApellidoPaternoCliente((String) out.get("PATERNO"));
				codigoCliente.setApellidoMaternoCliente((String) out.get("MATERNO"));
				codigoCliente.setTelefonoCliente((String) out.get("TELEFONOU"));
				codigoCliente.setCorreoCliente((String) out.get("CORREO"));
				codigoCliente.setEmpresaCliente((String) out.get("EMPRESA"));
				return codigoCliente;
			}
			else if(GenericUtil.isNull(out.get("DNIOUT"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
