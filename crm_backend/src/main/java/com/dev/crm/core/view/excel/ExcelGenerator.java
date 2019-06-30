package com.dev.crm.core.view.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.util.DateUtil;
import com.dev.crm.core.util.StringUtil;

public class ExcelGenerator {

	public static ByteArrayInputStream personasToExcel(List<PersonaDTO> personasDTO) throws IOException {
		
		Workbook workBook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			Sheet sheet = workBook.createSheet("PERSONAS");
			sheet.setDefaultColumnWidth(32);
			
			CellStyle style = workBook.createCellStyle();
			Font font = workBook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);
			
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("DNI/RUC");
			header.getCell(0).setCellStyle(style);
			header.createCell(1).setCellValue("NOMBRE");
			header.getCell(1).setCellStyle(style);
			header.createCell(2).setCellValue("APELLIDO PATERNO");
			header.getCell(2).setCellStyle(style);
			header.createCell(3).setCellValue("APELLIDO MATERNO");
			header.getCell(3).setCellStyle(style);
			header.createCell(4).setCellValue("DIRECCION RENIEC");
			header.getCell(4).setCellStyle(style);
			header.createCell(5).setCellValue("DIRECCION ACTUAL");
			header.getCell(5).setCellStyle(style);
			header.createCell(6).setCellValue("REFERENCIA");
			header.getCell(6).setCellStyle(style);
			header.createCell(7).setCellValue("TELEFONO UNO");
			header.getCell(7).setCellStyle(style);
			header.createCell(8).setCellValue("TELEFONO DOS");
			header.getCell(8).setCellStyle(style);
			header.createCell(9).setCellValue("UBIGEO");
			header.getCell(9).setCellStyle(style);
			
			int rowCount = 1;
			
			CellStyle rowStyle = workBook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			
			for(PersonaDTO personaDTO : personasDTO) {
					
				Row personaRow = sheet.createRow(rowCount++);
				personaRow.createCell(0).setCellValue(personaDTO.getDocumentoPersona());
				personaRow.getCell(0).setCellStyle(rowStyle);
				personaRow.createCell(1).setCellValue(personaDTO.getNombrePersona());
				personaRow.getCell(1).setCellStyle(rowStyle);
				personaRow.createCell(2).setCellValue(personaDTO.getApellidoPaternoPersona());
				personaRow.getCell(2).setCellStyle(rowStyle);
				personaRow.createCell(3).setCellValue(personaDTO.getApellidoMaternoPersona());
				personaRow.getCell(3).setCellStyle(rowStyle);
				personaRow.createCell(4).setCellValue(personaDTO.getDireccionReniecPersona());
				personaRow.getCell(4).setCellStyle(rowStyle);
				personaRow.createCell(5).setCellValue(personaDTO.getDireccionActualPersona());
				personaRow.getCell(5).setCellStyle(rowStyle);
				personaRow.createCell(6).setCellValue(personaDTO.getReferenciaPersona());
				personaRow.getCell(6).setCellStyle(rowStyle);
				personaRow.createCell(7).setCellValue(personaDTO.getTelefonoUnoPersona());
				personaRow.getCell(7).setCellStyle(rowStyle);
				personaRow.createCell(8).setCellValue(personaDTO.getTelefonoDosPersona());
				personaRow.getCell(8).setCellStyle(rowStyle);
				personaRow.createCell(9).setCellValue(personaDTO.getUbigeo().getNombreUbigeo());
				personaRow.getCell(9).setCellStyle(rowStyle);
			}
			
			workBook.write(out);
			workBook.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	public static ByteArrayInputStream clientesToExcel(List<PdfClienteResultViewModel> pdfClientes) throws IOException {
		
		Workbook workBook = new XSSFWorkbook();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			Sheet sheet = workBook.createSheet("CLIENTES");
			sheet.setDefaultColumnWidth(32);
			
			CellStyle style = workBook.createCellStyle();
			Font font = workBook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);
			
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("DNI-RUC");
			header.getCell(0).setCellStyle(style);
			header.createCell(1).setCellValue("CLIENTE");
			header.getCell(1).setCellStyle(style);
			header.createCell(2).setCellValue("DIRECCION");
			header.getCell(2).setCellStyle(style);
			header.createCell(3).setCellValue("CODIGO CLIENTE");
			header.getCell(3).setCellStyle(style);
			header.createCell(4).setCellValue("CORREO");
			header.getCell(4).setCellStyle(style);
			header.createCell(5).setCellValue("FACEBOOK");
			header.getCell(5).setCellStyle(style);
			header.createCell(6).setCellValue("ESTADO");
			header.getCell(6).setCellStyle(style);
			
			int rowCount = 1;
			
			CellStyle rowStyle = workBook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			
			for(PdfClienteResultViewModel pdfCliente : pdfClientes) {
				
				Row clienteRow = sheet.createRow(rowCount++);
				clienteRow.createCell(0).setCellValue(pdfCliente.getDocumentoPersonaCliente());
				clienteRow.getCell(0).setCellStyle(rowStyle);
				clienteRow.createCell(1).setCellValue(pdfCliente.getCliente());
				clienteRow.getCell(1).setCellStyle(rowStyle);
				clienteRow.createCell(2).setCellValue(pdfCliente.getDireccionCliente());
				clienteRow.getCell(2).setCellStyle(rowStyle);
				clienteRow.createCell(3).setCellValue(pdfCliente.getCodigoCliente());
				clienteRow.getCell(3).setCellStyle(rowStyle);
				clienteRow.createCell(4).setCellValue(pdfCliente.getCorreoCliente());
				clienteRow.getCell(4).setCellStyle(rowStyle);
				clienteRow.createCell(5).setCellValue(pdfCliente.getFacebookCliente());
				clienteRow.getCell(5).setCellStyle(rowStyle);
				clienteRow.createCell(6).setCellValue(pdfCliente.getEstadoCliente());
				clienteRow.getCell(6).setCellStyle(rowStyle);
			}
			
			workBook.write(baos);
			workBook.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public static ByteArrayInputStream pagosToExcel(List<PagosDelDiaResultViewModel> pagosDelDia) throws IOException {
		
		Workbook workBook = new XSSFWorkbook();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			Sheet sheet = workBook.createSheet("PAGOS");
			sheet.setDefaultColumnWidth(32);
			
			CellStyle style = workBook.createCellStyle();
			Font font = workBook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);
			
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("CODIGO PAGO");
			header.getCell(0).setCellStyle(style);
			header.createCell(1).setCellValue("DESCUENTO");
			header.getCell(1).setCellStyle(style);
			header.createCell(2).setCellValue("MONTO");
			header.getCell(2).setCellStyle(style);
			header.createCell(3).setCellValue("MES");
			header.getCell(3).setCellStyle(style);
			header.createCell(4).setCellValue("CLIENTE");
			header.getCell(4).setCellStyle(style);
			header.createCell(5).setCellValue("FECHA PAGO");
			header.getCell(5).setCellStyle(style);
			
			int rowCount = 1;
			
			CellStyle rowStyle = workBook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			
			for(PagosDelDiaResultViewModel pagoDelDia : pagosDelDia) {
				
				Row personaRow = sheet.createRow(rowCount++);
				personaRow.createCell(0).setCellValue(String.valueOf(pagoDelDia.getCodigoPago()));
				personaRow.getCell(0).setCellStyle(rowStyle);
				personaRow.createCell(1).setCellValue(StringUtil.bigDecimalToString(pagoDelDia.getDescuento()));
				personaRow.getCell(1).setCellStyle(rowStyle);
				personaRow.createCell(2).setCellValue(StringUtil.bigDecimalToString(pagoDelDia.getCantidadPago()));
				personaRow.getCell(2).setCellStyle(rowStyle);
				personaRow.createCell(3).setCellValue(pagoDelDia.getMesValido());
				personaRow.getCell(3).setCellStyle(rowStyle);
				personaRow.createCell(4).setCellValue(pagoDelDia.getCliente());
				personaRow.getCell(4).setCellStyle(rowStyle);
				personaRow.createCell(5).setCellValue(DateUtil.getDateFromStringReport(pagoDelDia.getFechaPagoDia(), "yyyy-MM-dd"));
				personaRow.getCell(5).setCellStyle(rowStyle);
				
			}
			
			workBook.write(baos);
			workBook.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
}
