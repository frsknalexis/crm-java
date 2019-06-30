package com.dev.crm.core.repository.jdbc;

import java.math.BigDecimal;
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

import com.dev.crm.core.dto.ReciboResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("reciboJdbcRepository")
public class ReciboCustomJdbcRepository implements ReciboJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_GENERAR_RECIBO);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("CODPAG", "CODUSU");
			simpleJdbcCall.declareParameters(new SqlParameter("CODPAG", Types.INTEGER),
					new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlOutParameter("VPAGO", Types.VARCHAR),
					new SqlOutParameter("VCLIENTE", Types.VARCHAR),
					new SqlOutParameter("VDIRECCION", Types.VARCHAR),
					new SqlOutParameter("VFECHAI", Types.DATE),
					new SqlOutParameter("VMES", Types.VARCHAR),
					new SqlOutParameter("VCANTIDAD", Types.FLOAT),
					new SqlOutParameter("VDESCUENTO", Types.FLOAT),
					new SqlOutParameter("VFECHA", Types.DATE));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODPAG", codigoPago);
			inParams.put("CODUSU", usuario);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("VPAGO")) && GenericUtil.isNotNull(out.get("VCLIENTE")) && GenericUtil.isNotNull(out.get("VDIRECCION"))
				&& GenericUtil.isNotNull(out.get("VFECHAI")) && GenericUtil.isNotNull(out.get("VMES")) && GenericUtil.isNotNull(out.get("VCANTIDAD"))
				&& GenericUtil.isNotNull(out.get("VDESCUENTO")) && GenericUtil.isNotNull(out.get("VFECHA"))) {
				
				ReciboResultViewModel recibo = new ReciboResultViewModel();
				recibo.setCodigoPago((String) out.get("VPAGO"));
				recibo.setCliente((String) out.get("VCLIENTE"));
				recibo.setDireccion((String) out.get("VDIRECCION"));
				recibo.setFechaInicio((Date) out.get("VFECHAI"));
				recibo.setMesValido((String) out.get("VMES"));
				recibo.setMonto(new BigDecimal((Double) out.get("VCANTIDAD")));
				recibo.setDescuento(new BigDecimal((Double) out.get("VDESCUENTO")));
				recibo.setFechaPago((Date) out.get("VFECHA"));
				return recibo;
			}
			else if(GenericUtil.isNull(out.get("VPAGO")) && GenericUtil.isNull(out.get("VCLIENTE")) && GenericUtil.isNull(out.get("VDIRECCION"))
					&& GenericUtil.isNull(out.get("VFECHAI")) && GenericUtil.isNull(out.get("VMES")) && GenericUtil.isNull(out.get("VCANTIDAD"))
					&& GenericUtil.isNull(out.get("VDESCUENTO")) && GenericUtil.isNull(out.get("VFECHA"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
