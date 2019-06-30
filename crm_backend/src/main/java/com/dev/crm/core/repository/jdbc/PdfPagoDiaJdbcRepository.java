package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.PdfPagoDiaResultViewModel;;

public interface PdfPagoDiaJdbcRepository {

	List<PdfPagoDiaResultViewModel> spListaPlanilla(String usuario);
}
