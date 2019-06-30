package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PdfPagoDiaResultViewModel;

public class PdfPagosDelDiaResultViewModelMapper implements RowMapper<PdfPagoDiaResultViewModel> {

	@Override
	public PdfPagoDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PdfPagoDiaResultViewModel pagosDelDia = new PdfPagoDiaResultViewModel();
		pagosDelDia.setNumero_interno_x_dia(rs.getString("NU"));
		pagosDelDia.setCodigo_pago_general(rs.getString("codigo_pago"));
		pagosDelDia.setNombre_del_mes(rs.getString("mes_pago"));
		pagosDelDia.setMonto_pago(rs.getString("cant_pago"));
		pagosDelDia.setFecha_dia_pago(rs.getString("fecha_pago_dia"));
		pagosDelDia.setCliente(rs.getString("cliente"));
		return pagosDelDia;
	}

}
