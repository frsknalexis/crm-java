package com.dev.crm.core.view.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PdfPagoDiaResultViewModel;
import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.dto.ReciboResultViewModel;
import com.dev.crm.core.util.DateUtil;
import com.dev.crm.core.util.StringUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
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
	
	public static ByteArrayInputStream pagosToPdf(List<ListaPagosPorCajaResultViewModel> pagosPorCaja) {
		
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1.7f, 1, 1, 1, 1, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MARZO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("ABRIL", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MAYO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("JUNIO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("JULIO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(ListaPagosPorCajaResultViewModel pagoPorCaja : pagosPorCaja) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getMarzo(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getAbril(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getMayo(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getJunio(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getJulio(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(table);
			
			document.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public static ByteArrayInputStream PdfPagoDia(List<PdfPagoDiaResultViewModel> pagosPorCaja) {
		
		Document document = new Document(PageSize.A4.rotate());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			
			String imageUrl = "https://scontent.flim19-1.fna.fbcdn.net/v/t1.0-9/61296693_2742619672420355_3895064617646292992_n.jpg?_nc_cat=107&_nc_ht=scontent.flim19-1.fna&oh=275d98534984bba9612bb14e98a96f10&oe=5D900E4A";
			
			Image img = Image.getInstance(new URL(imageUrl));
			img.scaleAbsolute(100f, 45f);
			img.disableBorderSide(Rectangle.BOX);
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {0.2f, 1, 1, 1, 1.7f, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPTable tables = new PdfPTable(1);
			tables.setWidthPercentage(35f);
			tables.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			PdfPTable tabla = new PdfPTable(6);
			tabla.setWidthPercentage(100);
			tabla.setWidths(new float[] {0.2f, 1, 1, 1, 1.7f, 1});
			Font fant = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcells;
			Paragraph celda = new Paragraph();
			Paragraph celdas = new Paragraph();
			hcells = new PdfPCell();
			hcells.disableBorderSide(Rectangle.BOX);
			celdas.add(new Phrase(new Chunk(img, 45, 0)));
			celda.add(new Paragraph(  " "
					+ "Vip Channel S.A.C.                                    ."));
			celda.setAlignment(Element.ALIGN_RIGHT);
			hcells.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcells.setVerticalAlignment(Element.ALIGN_MIDDLE);;
			hcells.addElement(celdas);
			hcells.addElement(celda);
			tables.addCell(hcells);
			
			hcells = new PdfPCell(new Phrase(" "));
			hcells.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcells.disableBorderSide(Rectangle.BOX);
			tables.addCell(hcells);
			
			
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("N°:", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("N° DE RECIBO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MENSUALIDAD", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("FECHA DE PAGO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("ABONADO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			
			
			for(PdfPagoDiaResultViewModel pagoPorCaja : pagosPorCaja) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getNumero_interno_x_dia().toString(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getCodigo_pago_general().toString(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getNombre_del_mes(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getFecha_dia_pago(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorCaja.getMonto_pago(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(cell);
			}
			
			PdfPCell hcelda;
			hcelda = new PdfPCell(new Phrase(" ", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			hcelda = new PdfPCell(new Phrase("______________________ \n"
											+"Supervisor de Cobranzas", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			hcelda = new PdfPCell(new Phrase(" ", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			hcelda = new PdfPCell(new Phrase("______________________ \n"
											+"Caja", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			hcelda = new PdfPCell(new Phrase(" ", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			hcelda = new PdfPCell(new Phrase(" ", fant));
			hcelda.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcelda.setBackgroundColor(BaseColor.WHITE);
			hcelda.disableBorderSide(Rectangle.BOX);
			tabla.addCell(hcelda);
			
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(tables);
			document.add(new Phrase("\n"));
			document.add(table);
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(tabla);
			document.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public static ByteArrayInputStream clientesReportToPDF(List<PdfClienteResultViewModel> pdfClientes) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1, 1.7f, 1.7f, 1, 1, 1, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("DNI-RUC", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("DIRECCION", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CODIGO CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CORREO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("FACEBOOK", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("ESTADO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(PdfClienteResultViewModel pdfCliente : pdfClientes) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getDocumentoPersonaCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getDireccionCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getCodigoCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getCorreoCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getFacebookCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pdfCliente.getEstadoCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(table);
			
			document.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public static ByteArrayInputStream pagosPorDiaReportToPDF(List<PagosPorDiaResultViewModel> pagosPorDia) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1.7f, 1, 1, 1, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("CODIGO PAGO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MONTO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MES PAGO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("FECHA PAGO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(PagosPorDiaResultViewModel pagoPorDia : pagosPorDia) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(String.valueOf(pagoPorDia.getCodigoPago()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorDia.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(pagoPorDia.getMonto()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(pagoPorDia.getMesPago(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(DateUtil.getDateFromStringReport(pagoPorDia.getFechaPago(), "yyyy-MM-dd"), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(table);
			
			document.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public static ByteArrayInputStream generarReciboToPDF(ReciboResultViewModel recibo) {
		
		Document documento = new Document(PageSize.A4.rotate());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try{
			
			String imageUrl = "https://scontent.flim19-1.fna.fbcdn.net/v/t1.0-9/61296693_2742619672420355_3895064617646292992_n.jpg?_nc_cat=107&_nc_ht=scontent.flim19-1.fna&oh=275d98534984bba9612bb14e98a96f10&oe=5D900E4A";
	
			Image img = Image.getInstance(new URL(imageUrl));
			img.scaleAbsolute(100f, 45f);
			img.disableBorderSide(Rectangle.BOX);
			
			PdfPTable table  = new PdfPTable(2);
			PdfPTable tables = new PdfPTable(2);
			
			table.setWidthPercentage(45f);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.setWidthPercentage(35f);
			tables.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			PdfPCell hcells;
			Paragraph celda = new Paragraph();
			Paragraph celdas = new Paragraph();
			Font ff = new Font (FontFamily.HELVETICA, 7, Font.NORMAL, GrayColor.BLACK);
			Font fff = new Font (FontFamily.HELVETICA, 9, Font.NORMAL, GrayColor.BLACK);
			Font f = new Font (FontFamily.HELVETICA, 10, Font.NORMAL, GrayColor.BLACK);
			hcells = new PdfPCell();
			hcells.disableBorderSide(Rectangle.BOX);
			celdas.add(new Phrase(new Chunk(img, 45, 0)));
			celda.add(new Paragraph(  " "
									+ "Vip Channel S.A.C.    .",f));
			celda.setAlignment(Element.ALIGN_RIGHT);
			hcells.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcells.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcells.addElement(celdas);
			hcells.addElement(celda);
			table.addCell(hcells);
			
			PdfPCell hcellss;
			hcellss = new PdfPCell(new Phrase("RECIBO DE CAJA", fff));
			hcellss.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcellss.setVerticalAlignment(Element.ALIGN_BOTTOM);
			hcellss.setColspan (3);
			hcellss.disableBorderSide(Rectangle.BOX);
			table.addCell(hcellss);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Paragraph(   "Av. Tupac Amaru #306 - 2do Piso .\n"
												+ "    Telf: 2326163- 2327395      .\n"
												+ "            HUACHO              .", ff));
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.disableBorderSide(Rectangle.BOX);
			table.addCell(hcell);
			
			PdfPCell hcelll;
			hcelll = new PdfPCell(new Phrase("Cod. " + recibo.getCodigoPago(), fff));
			hcelll.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcelll.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcelll.setColspan (3);
			hcelll.disableBorderSide(Rectangle.BOX);
			table.addCell(hcelll);
			
			PdfPCell celldatos;
			String cliente = recibo.getCliente();
			String direccion = recibo.getDireccion();
			String fechainsta = DateUtil.getDateFromStringReport(recibo.getFechaInicio(), "yyyy-MM-dd");
			String monto = StringUtil.bigDecimalToString(recibo.getMonto());
			String mes = recibo.getMesValido();
			Paragraph celdass = new Paragraph();
			Paragraph celdasdi = new Paragraph();
			Paragraph celdasin = new Paragraph();
			celldatos = new PdfPCell();
			celdass  = new Paragraph(new Chunk ("        Señor: "     + new Chunk(cliente).setUnderline(0.1f, -2f),fff));
			celdasdi = new Paragraph(new Chunk ("        Direccion: " + new Chunk(direccion).setUnderline(0.1f, -2f),fff));
			celdasin = new Paragraph(new Chunk ("        Fecha de Instalación: " + new Chunk(fechainsta).setUnderline(0.1f, -2f),fff));
			celldatos.addElement(celdass);
			celldatos.addElement(celdasdi);
			celldatos.addElement(celdasin);
			celldatos.setHorizontalAlignment(Element.ALIGN_RIGHT);
			celldatos.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celldatos.setColspan (3);
			celldatos.disableBorderSide(Rectangle.BOX);
			table.addCell(celldatos);
			
			PdfPCell celldatospag;
			Paragraph celdaspag = new Paragraph();
			celldatospag = new PdfPCell();
			celdaspag  = new Paragraph(new Chunk (" ",ff));
			celldatospag.addElement(celdaspag);
			celldatospag.setHorizontalAlignment(Element.ALIGN_TOP);
			celldatospag.setVerticalAlignment(Element.ALIGN_TOP);
			celldatospag.setColspan(3);
			celldatospag.disableBorderSide(Rectangle.BOX);
			table.addCell(celldatospag);
			
			
			PdfPCell celldatospago;
			celldatospago = new PdfPCell(new Phrase("CONCEPTO"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("IMPORTE"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Inscripción",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Mensualidad: " + mes,fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("S/. " + monto,fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Corte",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Reconexión",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("TV Adicional",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Servicio Técnio",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Otros",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(" ",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			tables.addCell(celldatospago);
			
			
			celldatospago = new PdfPCell(new Phrase("TOTAL",fff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("S/. " + monto ,fff));
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celldatospago.setHorizontalAlignment(Element.ALIGN_LEFT);
			celldatospago.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tables.addCell(celldatospago);
			
			PdfPCell pdfcel;
			pdfcel = new PdfPCell(new Phrase("R.U.C. 205515090640",ff));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			tables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase("\nHuacho, " + DateUtil.getDayOfDateWithZeroLeft(recibo.getFechaPago()) + " de " + DateUtil.getMonthOfDateWithZeroLeft(recibo.getFechaPago()) + " del " + DateUtil.getYearOfDateWithString(recibo.getFechaPago()), fff));
			pdfcel.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			pdfcel.disableBorderSide(Rectangle.BOX);
			tables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase(" ",ff));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			tables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( "\n\n____________________  \n"
											+ "p. VipChannel S.A.C.",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			tables.addCell(pdfcel);
			
			PdfWriter.getInstance(documento, baos);
			
			
			documento.open();
			documento.add(table);
			documento.add(tables);
			documento.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(baos.toByteArray());
	}
}
