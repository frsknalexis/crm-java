package com.dev.crm.core.report;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import com.dev.crm.core.dto.CuentasResultViewModel;
import com.dev.crm.core.enums.ExportReportType;
import com.dev.crm.core.util.Constantes;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service("reportService")
public class ReportService {

	public ByteArrayResource generateReportCuentas(List<CuentasResultViewModel> cuentas, ExportReportType exportReportType) {
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(Constantes.REPORTE_CUENTAS);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reporteCuentas(cuentas));
		
		switch(exportReportType) {
		
			case PDF:
				
				try {
					
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					
					JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
					
					JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					
					byte[] reportContent = outputStream.toByteArray();
					return new ByteArrayResource(reportContent);
					
				}
				catch(Exception e) {
					return null;
				}
			case DOCX:
				
				try {
					
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					
					JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
					
					JRDocxExporter exporter = new JRDocxExporter();
					exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
					exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
					exporter.exportReport();
					
					byte[] reportContent = outputStream.toByteArray();
					return new ByteArrayResource(reportContent);
				}
				catch(Exception e) {
					return null;
				}
			
			default: 
				return null;
		}
	}
	
	
	protected List<Map<String, Object>> reporteCuentas(List<CuentasResultViewModel> cuentas) {
		
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		for(CuentasResultViewModel cuenta: cuentas) {
			
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("codigoDetalleCuenta", cuenta.getCodigoDetalleCuenta());
			item.put("codigoCuenta", cuenta.getCodigoCuenta());
			item.put("documentoPersona", cuenta.getDocumentoPersona());
			item.put("cliente", cuenta.getCliente());
			item.put("observacion", cuenta.getObservacion());
			result.add(item);
		}
		return result;
	}
}
