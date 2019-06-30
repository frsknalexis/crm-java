package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PdfClienteResultViewModel;

public interface PdfListaClienteJdbcRepository {

	List<PdfClienteResultViewModel> spListarPdfCliente(String usuario);
}
