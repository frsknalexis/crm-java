package com.dev.crm.core.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.MesDeudaResultViewModel;

public class MesDeudaResultViewModelMapper implements RowMapper<MesDeudaResultViewModel> {

	@Override
	public MesDeudaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		MesDeudaResultViewModel mesDeuda = new MesDeudaResultViewModel();
		mesDeuda.setMesDeuda(rs.getInt("mes"));
		mesDeuda.setSumaPago(BigDecimal.valueOf(rs.getFloat("suma_pago")).setScale(2, RoundingMode.HALF_UP));
		mesDeuda.setAnioValido(rs.getInt("anio_valido"));
		mesDeuda.setTipoServicio(rs.getString("servicio_cod"));
		mesDeuda.setDescuento(rs.getBigDecimal("descuento_mes"));
		mesDeuda.setDocumentoPersonaCliente(rs.getString("COD_DOC"));
		mesDeuda.setNumeroCaja(rs.getString("CODIGOCAJA"));
		return mesDeuda;
	}

}
