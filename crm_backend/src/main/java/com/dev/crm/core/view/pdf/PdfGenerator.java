package com.dev.crm.core.view.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.dto.ConsolidadoInternetResultViewModel;
import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;
import com.dev.crm.core.dto.DiasDeudasResultViewModel;
import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;
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
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
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
	
	public static ByteArrayInputStream reporteDiasDeudas(List<DiasDeudasResultViewModel> diasDeudas) {
		
		Document document = new  Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			String imageUrl = "https://scontent.flim19-1.fna.fbcdn.net/v/t1.0-9/61296693_2742619672420355_3895064617646292992_n.jpg?_nc_cat=107&_nc_ht=scontent.flim19-1.fna&oh=275d98534984bba9612bb14e98a96f10&oe=5D900E4A";
			
			Image img = Image.getInstance(new URL(imageUrl));
			img.scaleAbsolute(100f, 45f);
			img.disableBorderSide(Rectangle.BOX);
			
			PdfPTable tables = new PdfPTable(1);
			tables.setWidthPercentage(35f);
			tables.setHorizontalAlignment(Element.ALIGN_LEFT);
			
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
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {.7f, 1, 1.3f, 1.5f, 1.5f});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("#", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("DNI-RUC", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("MES DEUDA", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
						
			hcell = new PdfPCell(new Phrase("DIRECCION ACTUAL", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(DiasDeudasResultViewModel diaDeuda : diasDeudas) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(diaDeuda.getNumeracion()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(diaDeuda.getDocumentoPersonaCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(diaDeuda.getMesPago(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(diaDeuda.getDireccionCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(diaDeuda.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);	
			}
			
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(tables);
			document.add(new Phrase("\n"));
			document.add(table);
			
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
	
	public static ByteArrayInputStream deudasGestorAcumuladoReportToPDF(List<DeudasGestorMontoAcumuladoResultViewModel> listaDeudasGestorAcumulado) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(11);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1.2f, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("GESTOR", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("UNA CUOTA", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("DOS CUOTAS", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("TRES CUOTAS", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CUATRO CUOTAS", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CINCO CUOTAS", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("IMPORTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(DeudasGestorMontoAcumuladoResultViewModel deudaGestorAcumulado : listaDeudasGestorAcumulado) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(deudaGestorAcumulado.getGestor(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(deudaGestorAcumulado.getMorosidadUnMesCantidad()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(deudaGestorAcumulado.getMorosidadUnMes()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
					
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(deudaGestorAcumulado.getMorosidadDosMesesCantidad()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(deudaGestorAcumulado.getMorosidadDosMeses()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(deudaGestorAcumulado.getMorosidadTresMesesCantidad()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(deudaGestorAcumulado.getMorosidadTresMeses()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(deudaGestorAcumulado.getMorosidadCuatroMesesCantidad()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(deudaGestorAcumulado.getMorosidadCuatroMeses()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(deudaGestorAcumulado.getMorosidadCincoMesesCantidad()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(StringUtil.bigDecimalToString(deudaGestorAcumulado.getMorosidadCincoMeses()), f));
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
	
	public static ByteArrayInputStream activacionesInstalacionReportToPDF(List<ActivacionesResultViewModel> activacionesInstalacion) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1, 1.2f, 1, 1.3f, 1, 1, 1.1f, 1.4f});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("#", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CLIENTE", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("DNI-RUC", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("DIRECCION", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("FECHA INICIO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("INTERNET", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("UBICACION", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("OBSERVACION", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(ActivacionesResultViewModel activacion : activacionesInstalacion) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(StringUtil.integerToString(activacion.getNumeracion()), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getDocumentoPersonaCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getDireccionCliente(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(DateUtil.getDateFromStringReport(activacion.getFechaInicioServicio(), "yyyy-MM-dd"), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getInternet(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getUbicacion(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(activacion.getObservacion(), f));
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
	
	public static ByteArrayInputStream consolidadoInternetReportToPDF(List<ConsolidadoInternetResultViewModel> listaConsolidadoInternet) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.setWidths(new float[] {1.5f, 1, 1, 1});
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
			font.setColor(BaseColor.WHITE);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("FECHA PAGO", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CAJA 1", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CAJA 2", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CAJA 3", font));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.DARK_GRAY);
			table.addCell(hcell);
			
			for(ConsolidadoInternetResultViewModel consolidadoInternet : listaConsolidadoInternet) {
				
				PdfPCell cell;
				
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 10);
				
				cell = new PdfPCell(new Phrase(consolidadoInternet.getFechaPago(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(consolidadoInternet.getCajaUno(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(consolidadoInternet.getCajaDos(), f));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(consolidadoInternet.getCajaTres(), f));
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
	
	public static ByteArrayInputStream generarReciboLiquidacion(LiquidacionMaterialResultViewModel liquidacion) {
		
		Document document = new Document(PageSize.A4);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			String imageUrl = "https://scontent.flim19-1.fna.fbcdn.net/v/t1.0-9/61296693_2742619672420355_3895064617646292992_n.jpg?_nc_cat=107&_nc_ht=scontent.flim19-1.fna&oh=275d98534984bba9612bb14e98a96f10&oe=5D900E4A";
			
			Image img = Image.getInstance(new URL(imageUrl));
			img.scaleAbsolute(120f, 45f);
			img.disableBorderSide(Rectangle.BOX);
			
			PdfPTable table  = new PdfPTable(2);
			PdfPTable tables = new PdfPTable(3);
			PdfPTable tablesx = new PdfPTable(3);
			PdfPTable tablees = new PdfPTable(1);
			PdfPTable stables = new PdfPTable(1);
			PdfPTable stabless = new PdfPTable(2);
			
			table.setWidthPercentage(75f);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			tables.setWidthPercentage(75f);
			tables.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.setWidthPercentage(75f);
			tablesx.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablees.setWidthPercentage(75f);
			tablees.setHorizontalAlignment(Element.ALIGN_CENTER);
			stables.setWidthPercentage(75f);
			stables.setHorizontalAlignment(Element.ALIGN_CENTER);
			stabless.setWidthPercentage(75f);
			stabless.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcells;
			Paragraph celda = new Paragraph();
			Paragraph celdas = new Paragraph();
			Font ff = new Font (FontFamily.HELVETICA, 7, Font.NORMAL, GrayColor.BLACK);
			Font fff = new Font (FontFamily.HELVETICA, 9, Font.NORMAL, GrayColor.BLACK);
			Font f = new Font (FontFamily.HELVETICA, 10, Font.NORMAL, GrayColor.BLACK);
			hcells = new PdfPCell();
			hcells.disableBorderSide(Rectangle.BOX);
			celdas.add(new Phrase(new Chunk(img, 55, 0)));
			celda.add(new Paragraph(  " "
									+ "Vip Channel S.A.C.    .",f));
			celda.setAlignment(Element.ALIGN_RIGHT);
			hcells.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcells.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcells.addElement(celdas);
			hcells.addElement(celda);
			table.addCell(hcells);
			
			PdfPCell hcellss;
			hcellss = new PdfPCell(new Phrase("INSTALACIÓN  - ACTIVACIÓN", fff));
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
			hcelll = new PdfPCell(new Phrase("Cod. " +liquidacion.getCodigoServicioInternet(), fff));
			hcelll.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcelll.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcelll.setColspan (3);
			hcelll.disableBorderSide(Rectangle.BOX);
			table.addCell(hcelll);
			
			PdfPCell celldatos; 
			String cliente = liquidacion.getCliente();
			String direccion = liquidacion.getDireccionCliente();
			String fechainsta =liquidacion.getFechaInicio();
			String documento = liquidacion.getDocumentoCliente();
			String correoe = liquidacion.getCorreoCliente();
			Paragraph celdass = new Paragraph();
			Paragraph celdasdi = new Paragraph();
			Paragraph celdasin = new Paragraph();
			Paragraph caldasdo = new Paragraph();
			celldatos = new PdfPCell();
			celdass  = new Paragraph(new Chunk ("Señor: "     + new Chunk(cliente).setUnderline(0.1f, -2f),f));
			celdasdi = new Paragraph(new Chunk ("N°: " + new Chunk(documento).setUnderline(0.1f, -2f) + "	-	Dirección: " + new Chunk(direccion).setUnderline(0.1f, -2f),f));
			celdasin = new Paragraph(new Chunk ("Correo E.: " + new Chunk(correoe).setUnderline(0.1f, -2f) + "	-	Fecha de Instalación: " + new Chunk(fechainsta).setUnderline(0.1f, -2f),f));
			celldatos.addElement(celdass);
			celldatos.addElement(celdasdi);
			celldatos.addElement(celdasin);
			celldatos.addElement(caldasdo);
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
			PdfPCell celldatospagos;			
			celldatospago = new PdfPCell(new Phrase("Codigo"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Materiales"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Total"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getCodigoMaterial(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getDescripcionMaterial(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getCantidadMaterial(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase( " ",f));
			celldatospago.setHorizontalAlignment(Element.ALIGN_TOP);
			celldatospago.disableBorderSide(Rectangle.BOX);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase( " ",f));
			celldatospago.setHorizontalAlignment(Element.ALIGN_TOP);
			celldatospago.disableBorderSide(Rectangle.BOX);
			tables.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase( " ",f));
			celldatospago.setHorizontalAlignment(Element.ALIGN_TOP);
			celldatospago.disableBorderSide(Rectangle.BOX);
			tables.addCell(celldatospago);
			
			celldatospagos = new PdfPCell(new Phrase("EQUIPO EN CALIDAD DE COMODATO"));
			celldatospagos.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospagos.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablees.addCell(celldatospagos);
			
			celldatospago = new PdfPCell(new Phrase("Serie"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Wifi User"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Wifi Password"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getSerieOnu(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getWifiUser(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getWifiPassword(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Marca"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Modelo"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Tipo de Equipo"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("yyy",ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getTipoOnu(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("ONU",ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Potencia"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Tipo de Servicio"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("Medio Físico"));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			celldatospago.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase(liquidacion.getPotenciaOnu(),ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("INTERNET",ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			celldatospago = new PdfPCell(new Phrase("FIBRA ÓPTICA",ff));
			celldatospago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablesx.addCell(celldatospago);
			
			/**/
			
			PdfPCell pdfcel;
			pdfcel = new PdfPCell(new Phrase( "Observacion: \n \n"
					+ "							" + liquidacion.getObservacion(),f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( " ",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( "El presente documento deja constancia que EL CLIENTE entregará el equipo ONU a "
											+ "VIP Channel - Internet Color	después de finalizado el servicio de Internet.",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( " ",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( " ",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( " ",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( " ",f));
			pdfcel.setHorizontalAlignment(Element.ALIGN_TOP);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stables.addCell(pdfcel);
			pdfcel = new PdfPCell(new Phrase( "\n\n_________________________________  \n"
											+ "Firma del Cliente \n"
											+ liquidacion.getCliente() + "\n"
											+ "N° de documento: " + liquidacion.getDocumentoCliente(),ff));
			pdfcel.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stabless.addCell(pdfcel);
			
			pdfcel = new PdfPCell(new Phrase( "\n\n____________________________  \n"
					+ "p. VipChannel S.A.C. \n"
					+ "Técnico: " + liquidacion.getTecnicoResponsable(),ff));
			pdfcel.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfcel.disableBorderSide(Rectangle.BOX);
			stabless.addCell(pdfcel);
			
			PdfWriter.getInstance(document, baos);
			
			
			document.open();
			document.add(table);
			document.add(tables);
			document.add(tablees);
			document.add(tablesx);
			document.add(new Phrase("\n"));
			document.add(stables);
			document.add(stabless);
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
	
	public static ByteArrayInputStream generarReciboToPDF(ReciboResultViewModel recibo) {
		
		Document documento = new Document(PageSize.A5.rotate());
		documento.setMargins( 20, 20, 10, 0 );
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try{
			
			PdfWriter pdfw = PdfWriter.getInstance(documento, baos);
			
			String imageUrl = "https://scontent.flim19-1.fna.fbcdn.net/v/t1.0-9/61296693_2742619672420355_3895064617646292992_n.jpg?_nc_cat=107&_nc_ht=scontent.flim19-1.fna&oh=275d98534984bba9612bb14e98a96f10&oe=5D900E4A";
	
			Image img = Image.getInstance(new URL(imageUrl));
			img.scaleAbsolute(100f, 35f);
			img.disableBorderSide(Rectangle.BOX);
			
			Font ff = new Font (FontFamily.HELVETICA, 8, Font.NORMAL, GrayColor.BLACK);
			Font ffss = new Font (FontFamily.HELVETICA, 7, Font.BOLD, GrayColor.BLACK);
			Font fffSS = new Font (FontFamily.HELVETICA, 7, Font.NORMAL, GrayColor.BLACK);
			Font AA = new Font (FontFamily.HELVETICA, 10, Font.NORMAL, GrayColor.WHITE);
			Font fsf = new Font (FontFamily.HELVETICA, 8, Font.NORMAL, GrayColor.BLACK);
			Font fff = new Font (FontFamily.HELVETICA, 9, Font.NORMAL, GrayColor.BLACK);
			Font fffX = new Font (FontFamily.HELVETICA, 9, Font.BOLD, GrayColor.BLACK);
			fsf.setStyle(Font.UNDERLINE);
			
			PdfPTable table  = new PdfPTable(3);
			PdfPTable centro  = new PdfPTable(3);
			PdfPTable contenido  = new PdfPTable(5);
			PdfPTable pago  = new PdfPTable(7);
			PdfPTable pie  = new PdfPTable(2);
			
			table.setWidthPercentage(100f);
			table.setWidths(new float[] {0.6f, 1.4f, 1.3f});
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			centro.setWidthPercentage(100f);
			centro.setWidths(new float[] { 0.8f, 1.2f , 1.3f });
			
			pie.setWidthPercentage(100f);
			pie.setWidths(new float[] { 2f,1.5f });
			pie.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pago.setWidthPercentage(100f);
			pago.setWidths(new float[] {0.8f, 0.4f,0.4f,0.4f, 0.38f,0.38f, 0.54f});
			
			contenido.setWidthPercentage(100f);
			contenido.setWidths(new float[] {0.8f, 1.2f, 0.38f,0.38f, 0.54f});
			
			
			Paragraph callimag = new Paragraph();
			Paragraph calldada = new Paragraph();
			Paragraph calldatoemprtiutlo__ = new Paragraph();
			Paragraph calldadaq = new Paragraph();
			Paragraph calldatoemprtiutloq = new Paragraph();
			Paragraph calldatoemprtiutlo = new Paragraph();
			Paragraph calldatoempr__ = new Paragraph();
			Paragraph calldatoruc = new Paragraph();
			Paragraph calldatos = new Paragraph();
			Paragraph calldatoblack = new Paragraph();
			Paragraph calldatoblack1 = new Paragraph();
			Paragraph calldatoblack2 = new Paragraph();
			Paragraph calldatocliente = new Paragraph();
			Paragraph calldatodatos = new Paragraph();
			Paragraph calldatocont = new Paragraph();
			Paragraph calldatocont1 = new Paragraph();
			Paragraph calldatocont2 = new Paragraph();
			Paragraph calldatocont3 = new Paragraph();
			Paragraph calldatocont4 = new Paragraph();
			Paragraph calldatocont5 = new Paragraph();
			Paragraph calldatocont6 = new Paragraph();
			Paragraph calldatocont7 = new Paragraph();
			Paragraph calldatocont8 = new Paragraph();
			Paragraph calldatocont9 = new Paragraph();
			Paragraph calldatocont10 = new Paragraph();
			Paragraph calldatocont11 = new Paragraph();
			Paragraph calldatocont12 = new Paragraph();
			Paragraph calldatocont13 = new Paragraph();
			Paragraph calldatocont14 = new Paragraph();
			Paragraph calldatocont15 = new Paragraph();
			Paragraph calldatocont16 = new Paragraph();
			Paragraph calldatocont17 = new Paragraph();
			Paragraph calldatocont18 = new Paragraph();
			Paragraph calldatocont19 = new Paragraph();
			Paragraph calldatocont20 = new Paragraph();
			Paragraph calldatocont21 = new Paragraph();
			Paragraph calldatocont22 = new Paragraph();
			Paragraph calldatocont23 = new Paragraph();
			Paragraph calldatocont24 = new Paragraph();
			Paragraph calldatocont25 = new Paragraph();
			Paragraph calldatocont26 = new Paragraph();
			Paragraph calldatocont27 = new Paragraph();
			
			PdfPCell cellcabecera;
			cellcabecera = new PdfPCell();
			PdfPCell cellcabecera_1;
			cellcabecera_1 = new PdfPCell();
			PdfPCell cellcabecera_3;
			cellcabecera_3 = new PdfPCell();
			PdfPCell cellcabecera_4;
			cellcabecera_4 = new PdfPCell();
			PdfPCell cellcabecera_5;
			cellcabecera_5 = new PdfPCell();
			PdfPCell cellcabecera_6;
			cellcabecera_6 = new PdfPCell();
			PdfPCell cellcabecera_7;
			cellcabecera_7 = new PdfPCell();
			PdfPCell cellcabecera_8;
			cellcabecera_8 = new PdfPCell();
			PdfPCell cellcabecera_9;
			cellcabecera_9 = new PdfPCell();
			PdfPCell cellcabecera_10;
			cellcabecera_10 = new PdfPCell();
			PdfPCell cellcabecera_11;
			cellcabecera_11 = new PdfPCell();
			PdfPCell cellcabecera_12;
			cellcabecera_12 = new PdfPCell();
			PdfPCell cellcabecera_13;
			cellcabecera_13 = new PdfPCell();
			PdfPCell cellcabecera_14;
			cellcabecera_14 = new PdfPCell();
			PdfPCell cellcabecera_15;
			cellcabecera_15 = new PdfPCell();
			PdfPCell cellcabecera_16;
			cellcabecera_16 = new PdfPCell();
			PdfPCell cellcabecera_17;
			cellcabecera_17 = new PdfPCell();
			PdfPCell cellcabecera_18;
			cellcabecera_18 = new PdfPCell();
			PdfPCell cellcabecera_19;
			cellcabecera_19 = new PdfPCell();
			PdfPCell cellcabecera_20;
			cellcabecera_20 = new PdfPCell();
			PdfPCell cellcabecera_21;
			cellcabecera_21 = new PdfPCell();
			PdfPCell cellcabecera_22;
			cellcabecera_22 = new PdfPCell();
			PdfPCell cellcabecera_23;
			cellcabecera_23 = new PdfPCell();
			PdfPCell cellcabecera_24;
			cellcabecera_24 = new PdfPCell();
			PdfPCell cellcabecera_25;
			cellcabecera_25 = new PdfPCell();
			PdfPCell cellcabecera_26;
			cellcabecera_26 = new PdfPCell();
			PdfPCell cellcabecera_27;
			cellcabecera_27 = new PdfPCell();
			PdfPCell cellcabecera_28;
			cellcabecera_28 = new PdfPCell();
			PdfPCell cellcabecera_29;
			cellcabecera_29 = new PdfPCell();
			PdfPCell cellcabecera_30;
			cellcabecera_30 = new PdfPCell();
			PdfPCell cellcabecera_31;
			cellcabecera_31 = new PdfPCell();
			PdfPCell cellcabecera_32;
			cellcabecera_32 = new PdfPCell();
			PdfPCell cellcabecera_33;
			cellcabecera_33 = new PdfPCell();
			PdfPCell cellcabecera_34;
			cellcabecera_34 = new PdfPCell();
			
			cellcabecera_1.disableBorderSide(Rectangle.BOX);
			callimag.setAlignment(Element.ALIGN_CENTER);
			calldatos.setAlignment(Element.ALIGN_CENTER);
			callimag.setAlignment(Element.ALIGN_CENTER);
			callimag.add(new Phrase(new Chunk(img, 0, 0)));
			cellcabecera_1.addElement(callimag);
			calldatos.add(new Phrase("Para Huacho lo mejor...!", ff));
			cellcabecera_1.addElement(calldatos);
			table.addCell(cellcabecera_1);
			
			cellcabecera.disableBorderSide(Rectangle.BOX);
			calldada.add(new Phrase( "Razón Social                          Sucursal",ffss));
			calldatoemprtiutlo.add(new Phrase( "VIP CHANNEL S.A.C." +"             "+        recibo.getSucursal(),fffSS));
			calldada.setAlignment(Element.ALIGN_LEFT);
			calldatoemprtiutlo.setAlignment(Element.ALIGN_LEFT);
			calldadaq.add(new Phrase( "Dom. Fiscal",ffss));
			calldatoemprtiutloq.add(new Phrase( "Parque Hernán Velarde N° 239 "
									+ "Santa Beatriz - Lima",fffSS));
			calldadaq.setAlignment(Element.ALIGN_LEFT);
			calldatoemprtiutloq.setAlignment(Element.ALIGN_LEFT);
			cellcabecera.addElement(calldada);
			cellcabecera.addElement(calldatoemprtiutlo);
			cellcabecera.addElement(calldadaq);
			cellcabecera.addElement(calldatoemprtiutloq);
			table.addCell(cellcabecera);
			
			calldatoempr__.add(new Phrase("R.U.C. 20515090640",fffX));
			calldatoemprtiutlo__.add(new Phrase(recibo.getTipoComprobante() + " DE VENTA ELECTRÓNICA",fffX));
			calldatoruc.add(new Phrase(recibo.getCodigoPago(),fffX));
			calldatoemprtiutlo__.setAlignment(Element.ALIGN_CENTER);
			calldatoempr__.setAlignment(Element.ALIGN_CENTER);
			calldatoruc.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_3.addElement(calldatoempr__);
			cellcabecera_3.addElement(calldatoemprtiutlo__);
			cellcabecera_3.addElement(calldatoruc);
			table.addCell(cellcabecera_3);			
			
			cellcabecera_4.disableBorderSide(Rectangle.BOX);
			calldatoblack.add(new Phrase(  new  Chunk("               R.U.C. / D.N.I: ", fffX).setBackground(BaseColor.LIGHT_GRAY)));
			calldatoblack.setAlignment(Element.ALIGN_RIGHT);
			cellcabecera_4.addElement(calldatoblack);
			calldatoblack1.setAlignment(Element.ALIGN_RIGHT);
			calldatoblack1.add(new Phrase(  new Chunk("                 SEÑOR(ES):  ", fffX).setBackground(BaseColor.LIGHT_GRAY)));
			cellcabecera_4.addElement(calldatoblack1);
			calldatoblack2.add(new Phrase(new Chunk("                 DIRECCIÓN:  ", fffX).setBackground(BaseColor.LIGHT_GRAY)));
			calldatoblack2.setAlignment(Element.ALIGN_RIGHT);
			cellcabecera_4.addElement(calldatoblack2);
			centro.addCell(cellcabecera_4);
			
			cellcabecera_5.disableBorderSide(Rectangle.BOX);
			calldatocliente.add(new Phrase(recibo.getDocumento()
											+ "\n" + new Chunk(recibo.getCliente()).setUnderline(0.1f, -2f) + "\n"
											+ "" + recibo.getDireccion() ,fsf));
			calldatocliente.setAlignment(Element.ALIGN_LEFT);
			cellcabecera_5.addElement(calldatocliente);
			centro.addCell(cellcabecera_5);	
			
			calldatodatos.add(new Phrase(  	  "TIPO DE MONEDA        : Soles \n"
											+ "FECHA DE EMISIÓN     : " + recibo.getFechaPago()
											+ "\nCONDICIÓN DE PAGO : CONTADO",ff));
			calldatodatos.setAlignment(Element.ALIGN_LEFT);
			centro.setHorizontalAlignment(Element.ALIGN_MIDDLE);
			cellcabecera_6.addElement(calldatodatos);
			centro.addCell(cellcabecera_6);
			
			calldatocont.add(new Phrase( "CÓDIGO",ff));
			calldatocont.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_7.addElement(calldatocont);
			cellcabecera_7.setBackgroundColor(BaseColor.LIGHT_GRAY);
			contenido.addCell(cellcabecera_7);
			
			calldatocont1.add(new Phrase( "DESCRIPCIÓN",ff));
			calldatocont1.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_8.addElement(calldatocont1);
			cellcabecera_8.setBackgroundColor(BaseColor.LIGHT_GRAY);
			contenido.addCell(cellcabecera_8);
			
			calldatocont2.add(new Phrase( "UNIDAD",ff));
			calldatocont2.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_9.addElement(calldatocont2);
			cellcabecera_9.setBackgroundColor(BaseColor.LIGHT_GRAY);
			contenido.addCell(cellcabecera_9);
			
			calldatocont3.add(new Phrase( "PRE UNIT.",ff));
			calldatocont3.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_10.addElement(calldatocont3);
			cellcabecera_10.setBackgroundColor(BaseColor.LIGHT_GRAY);
			contenido.addCell(cellcabecera_10);
			
			calldatocont4.add(new Phrase( "IMPORTE",ff));
			calldatocont4.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_11.addElement(calldatocont4);
			cellcabecera_11.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_11.setBackgroundColor(BaseColor.LIGHT_GRAY);
			contenido.addCell(cellcabecera_11);
			
			calldatocont5.add(new Phrase(recibo.getCodigoCliente(),ff));
			calldatocont5.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_12.addElement(calldatocont5);
			cellcabecera_12.setHorizontalAlignment(Element.ALIGN_TOP);
			contenido.addCell(cellcabecera_12);
			
			calldatocont6.add(new Phrase( "MENSUALIDAD - " + recibo.getMesValido()
										+ "\n"
										+ "\n"
										+ "\n"
										+ "\n"
										+ "\n"
										+ recibo.getValorMonto() + "\n"
										+ "GRACIAS POR SU PREFERENCIA...!"
										+ "\n",ff));
			calldatocont6.setAlignment(Element.ALIGN_LEFT);
			cellcabecera_13.addElement(calldatocont6);
			cellcabecera_13.setHorizontalAlignment(Element.ALIGN_TOP);
			contenido.addCell(cellcabecera_13);
			
			calldatocont7.add(new Phrase( "1",ff));
			calldatocont7.setAlignment(Element.ALIGN_RIGHT);
			cellcabecera_14.addElement(calldatocont7);
			cellcabecera_14.setHorizontalAlignment(Element.ALIGN_TOP);
			contenido.addCell(cellcabecera_14);
			
			Double monto = (double) Math.round((recibo.getMonto() / 1.18) * 100.0) / 100.0;
			Double valor = (double) Math.round((recibo.getMonto()) * 100.0)/100.0;
			Double resultado =  (double) Math.round((- monto + valor)  * 100.0) / 100.0;
			
			calldatocont8.add(new Phrase( monto.toString(),ff));
			calldatocont8.setAlignment(Element.ALIGN_RIGHT);
			cellcabecera_15.addElement(calldatocont8);
			cellcabecera_15.setHorizontalAlignment(Element.ALIGN_TOP);
			contenido.addCell(cellcabecera_15);
			
			calldatocont9.add(new Phrase(  monto.toString(),ff));
			calldatocont9.setAlignment(Element.ALIGN_RIGHT);
			cellcabecera_16.addElement(calldatocont9);
			contenido.addCell(cellcabecera_16);
			
			calldatocont10.add(new Phrase( "OP. EXONERADA",ff));
			calldatocont10.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_17.addElement(calldatocont10);
			cellcabecera_17.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_17.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_17);
			
			calldatocont11.add(new Phrase( "OP. INAFECTA",ff));
			calldatocont11.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_18.addElement(calldatocont11);
			cellcabecera_18.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_18.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_18);
			
			calldatocont12.add(new Phrase( "OP. GRAVADA",ff));
			calldatocont12.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_19.addElement(calldatocont12);
			cellcabecera_19.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_19.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_19);
			
			calldatocont13.add(new Phrase( "TOT.DSCTO",ff));
			calldatocont13.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_20.addElement(calldatocont13);
			cellcabecera_20.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_20.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_20);
			
			calldatocont14.add(new Phrase( "I.S.C",ff));
			calldatocont14.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_21.addElement(calldatocont14);
			cellcabecera_21.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_21.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_21);
			
			calldatocont15.add(new Phrase( "I.G.V",ff));
			calldatocont15.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_22.addElement(calldatocont15);
			cellcabecera_22.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_22.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_22);
			
			calldatocont16.add(new Phrase( "IMPORTE TOTAL",ff));
			calldatocont16.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_23.addElement(calldatocont16);
			cellcabecera_23.setHorizontalAlignment(Element.ALIGN_TOP);
			cellcabecera_23.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pago.addCell(cellcabecera_23);
			
			calldatocont17.add(new Phrase( "0.00",ff));
			calldatocont17.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_24.addElement(calldatocont17);
			pago.addCell(cellcabecera_24);
			
			calldatocont18.add(new Phrase( "0.00",ff));
			calldatocont18.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_25.addElement(calldatocont18);
			pago.addCell(cellcabecera_25);
			
			calldatocont19.add(new Phrase(monto.toString(),ff));
			calldatocont19.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_26.addElement(calldatocont19);
			pago.addCell(cellcabecera_26);
			
			calldatocont20.add(new Phrase( "0.00",ff));
			calldatocont20.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_27.addElement(calldatocont20);
			pago.addCell(cellcabecera_27);
			
			calldatocont21.add(new Phrase( "0.00",ff));
			calldatocont21.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_28.addElement(calldatocont21);
			pago.addCell(cellcabecera_28);
			
			calldatocont22.add(new Phrase( resultado.toString(),ff));
			calldatocont22.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_29.addElement(calldatocont22);
			pago.addCell(cellcabecera_29);
			
			calldatocont23.add(new Phrase( "S/. " + valor.toString(),AA));
			calldatocont23.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_30.addElement(calldatocont23);
			cellcabecera_30.setBackgroundColor(BaseColor.BLACK);
			pago.addCell(cellcabecera_30);
			
			
			documento.open();
			Image imagendemo ;
			BarcodeEAN codeEAN = new BarcodeEAN();
			codeEAN.setCodeType(Barcode.EAN8);
			codeEAN.setCode("00"+""+recibo.getCodigoBarra());
			
			cellcabecera_31.disableBorderSide(Rectangle.BOX);
			calldatocont24.add(new Phrase(" ",ff));
			calldatocont24.setAlignment(Element.ALIGN_LEFT);
			cellcabecera_31.addElement(calldatocont24);
			pie.addCell(cellcabecera_31);
			
			cellcabecera_32.disableBorderSide(Rectangle.BOX);
			imagendemo = codeEAN.createImageWithBarcode( pdfw.getDirectContent(), BaseColor.BLACK, BaseColor.WHITE);
			calldatocont25.add(new Phrase(new Chunk(imagendemo,0, 0)));
			calldatocont25.setAlignment(Element.ALIGN_LEFT);
			cellcabecera_32.addElement(calldatocont25);
			pie.addCell(cellcabecera_32);
			
			cellcabecera_33.disableBorderSide(Rectangle.BOX);
			calldatocont26.add(new Phrase("Página Web Cable   : www.cablecolor.pe\n"
										+ "Página Web Internet: www.internetcolor.pe",ff));
			calldatocont26.setAlignment(Element.ALIGN_LEFT);
			cellcabecera_33.addElement(calldatocont26);
			pie.addCell(cellcabecera_33);
			
			cellcabecera_34.disableBorderSide(Rectangle.BOX);
			calldatocont27.add(new Phrase("Representación impresa del " + recibo.getTipoComprobante() +  " DE VENTA ELECTRÓNICA",ff));
			calldatocont27.setAlignment(Element.ALIGN_CENTER);
			cellcabecera_34.addElement(calldatocont27);
			pie.addCell(cellcabecera_34);
			
			documento.add(table);
			documento.add(new Phrase("\n"));
			documento.add(centro);
			documento.add(contenido);
			documento.add(pago);
			documento.add(pie);
			documento.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(baos.toByteArray());
	}
}