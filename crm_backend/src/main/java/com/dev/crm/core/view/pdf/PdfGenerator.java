package com.dev.crm.core.view.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.dev.crm.core.dto.PersonaDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {

	public static ByteArrayInputStream personasToPDF(List<PersonaDTO> personasDTO) {
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1, 1.3f, 1.3f, 1.8f, 1.5f, 1.1f});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("DNI/RUC", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("NOMBRE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("APELLIDOS", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
						
			hcell = new PdfPCell(new Phrase("DIRECCION ACTUAL", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("REFERENCIA", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("TELEFONO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
						
			for(PersonaDTO personaDTO : personasDTO) {
				
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase(personaDTO.getDocumentoPersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(personaDTO.getNombrePersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(personaDTO.getApellidoPaternoPersona() + ' ' + personaDTO.getApellidoMaternoPersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
					
				cell = new PdfPCell(new Phrase(personaDTO.getDireccionActualPersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(personaDTO.getReferenciaPersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(personaDTO.getTelefonoUnoPersona()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			
			document.close();
		}
		catch(DocumentException ex) {
			ex.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}
