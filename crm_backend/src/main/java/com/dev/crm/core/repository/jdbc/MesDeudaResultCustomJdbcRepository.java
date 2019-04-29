package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.mapper.MesDeudaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("mesDeudaResultJdbcRepository")
public class MesDeudaResultCustomJdbcRepository implements MesDeudaResultJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja) {
		
		List<MesDeudaResultViewModel> mesesDeuda = new ArrayList<MesDeudaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_MESES_DEUDAS);
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
					new SqlParameter("COD_CAJA", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("mesesDeudas", new MesDeudaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("COD_DOC", documentoPersonaCliente);
			inParams.addValue("COD_CAJA", numeroCaja);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			mesesDeuda = (List<MesDeudaResultViewModel>) result.get("mesesDeudas");
			return mesesDeuda;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
