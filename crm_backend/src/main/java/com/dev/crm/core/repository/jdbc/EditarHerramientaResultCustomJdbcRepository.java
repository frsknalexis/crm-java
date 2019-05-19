package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.util.Constantes;

@Repository("EditarHerramintaResultJdbcRepository")
public class EditarHerramientaResultCustomJdbcRepository implements EditarHerramintaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public EditarHerramientaResultViewModel spBuscarDatosEditar(String codherra) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_DATOS_GENERAL_HERRAMIENTA);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("CODIHERRA");
			simpleJdbcCall.declareParameters(new SqlParameter("CODIHERRA", Types.INTEGER),
					new SqlOutParameter("DESCRIPCIONHERRA", Types.VARCHAR),
					new SqlOutParameter("SECHERRA", Types.INTEGER),
					new SqlOutParameter("FECHAI", Types.DATE),
					new SqlOutParameter("FECHAF", Types.DATE),
					new SqlOutParameter("CODITIPO", Types.INTEGER),
					new SqlOutParameter("CANTIDAD", Types.INTEGER),
					new SqlOutParameter("FECHAEE", Types.DATE),
					new SqlOutParameter("COD_INT", Types.INTEGER));
			
			Map<String, Object> inParam = new HashMap<String, Object>();
			inParam.put("CODIHERRA", codherra);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParam);
			
			EditarHerramientaResultViewModel cHerra = new EditarHerramientaResultViewModel();
			cHerra.setHerramienta((String) out.get("CODIHERRA"));
			cHerra.setDescripcionherramienta((String) out.get("DESCRIPCIONHERRA"));
			cHerra.setFechaemision((Date) out.get("FECHAEE"));
			cHerra.setSecuencial((Integer) out.get("SECHERRA"));
			cHerra.setCantidad((Integer) out.get("CANTIDAD"));
			cHerra.setFechainicio((Date) out.get("FECHAI"));
			cHerra.setFechafinal((Date) out.get("FECHAF"));
			cHerra.setCodigoTipoComprobante((Integer) out.get("CODITIPO"));
			cHerra.setCodigoUusario((Integer) out.get("COD_INT"));
			return cHerra;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
