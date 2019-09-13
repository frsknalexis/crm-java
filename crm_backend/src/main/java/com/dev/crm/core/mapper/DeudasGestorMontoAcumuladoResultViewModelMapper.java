package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;

public class DeudasGestorMontoAcumuladoResultViewModelMapper implements RowMapper<DeudasGestorMontoAcumuladoResultViewModel> {

	@Override
	public DeudasGestorMontoAcumuladoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DeudasGestorMontoAcumuladoResultViewModel deudasGestorMontoAcumulado = new DeudasGestorMontoAcumuladoResultViewModel();
		deudasGestorMontoAcumulado.setGestor(rs.getString("GESTOR"));
		deudasGestorMontoAcumulado.setMorosidadUnMes(rs.getBigDecimal("MOROSIDAD_UN_MES_VALOR"));
		deudasGestorMontoAcumulado.setMorosidadUnMesCantidad(rs.getInt("MOROSIDAD_UN_MES_CANTIDAD"));
		deudasGestorMontoAcumulado.setMorosidadDosMeses(rs.getBigDecimal("MOROSIDAD_DOS_MES_VALOR"));
		deudasGestorMontoAcumulado.setMorosidadDosMesesCantidad(rs.getInt("MOROSIDAD_DOS_MESES_CANTIDAD"));
		deudasGestorMontoAcumulado.setMorosidadTresMeses(rs.getBigDecimal("MOROSIDAD_TRES_MES_VALOR"));
		deudasGestorMontoAcumulado.setMorosidadTresMesesCantidad(rs.getInt("MOROSIDAD_TRES_MESES_CANTIDAD"));
		deudasGestorMontoAcumulado.setMorosidadCuatroMeses(rs.getBigDecimal("MOROSIDAD_CUATRO_MES_VALOR"));
		deudasGestorMontoAcumulado.setMorosidadCuatroMesesCantidad(rs.getInt("MOROSIDAD_CUATRO_MESES_CANTIDAD"));
		deudasGestorMontoAcumulado.setMorosidadCincoMeses(rs.getBigDecimal("MOROSIDAD_CINCO_MES_VALOR"));
		deudasGestorMontoAcumulado.setMorosidadCincoMesesCantidad(rs.getInt("MOROSIDAD_CINCO_MESES_CANTIDAD"));
		return deudasGestorMontoAcumulado;
	}
}
