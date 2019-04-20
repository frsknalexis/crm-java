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

import com.dev.crm.core.dto.PersonaDTO;

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
}
