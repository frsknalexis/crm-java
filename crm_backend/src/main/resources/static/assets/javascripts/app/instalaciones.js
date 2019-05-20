$(document).on('ready', function() {
	
	var tablaInstalacionesDiaCable;
	
	var tablaInstalacionesDiaInternet;
	
	redireccionarCortesView();
	
	listarInstalacionDiaCable();
	
	listarInstalacionDiaInternet();
	
	/**
	 * 
	 *function para redireccionar a la vista de cortes
	 * 
	 */
	function redireccionarCortesView() {
		
		$('#buttonCortes').on('click', function() {
			$(location).attr('href', '/instalacion/cortes/view');
		});
	}
	
	/**
	 * 
	 * function para listar instalaciones dia cable
	 * 
	 */
	function listarInstalacionDiaCable() {
		tablaInstalacionesDiaCable = $('#tablaInstalacionesDiaCable').dataTable({
			"language": {
				"sProcessing":     "Procesando...",
				"sLengthMenu":     "Mostrar _MENU_ registros",
				"sZeroRecords":    "No se encontraron resultados",
				"sEmptyTable":     "Ningún dato disponible en esta tabla",
				"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				"sInfoPostFix":    "",
				"sSearch":         "Buscar:",
				"sUrl":            "",
				"sInfoThousands":  ",",
				"sLoadingRecords": "Cargando...",
				"oPaginate": {
					"sFirst":    "Primero",
					"sLast":     "Último",
					"sNext":     "Siguiente",
					"sPrevious": "Anterior"
				},
				"oAria": {
					"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
					"sSortDescending": ": Activar para ordenar la columna de manera descendente"
				}
			},
			'bProcessing': true,
			"bDestroy": true
		}).DataTable();
	}
	
	/**
	 * 
	 *function para listar instalaciones del dia internet 
	 * 
	 */
	function listarInstalacionDiaInternet() {
		
		tablaInstalacionesDiaInternet = $('#tablaInstalacionesDiaInternet').dataTable({
			"language": {
				"sProcessing":     "Procesando...",
				"sLengthMenu":     "Mostrar _MENU_ registros",
				"sZeroRecords":    "No se encontraron resultados",
				"sEmptyTable":     "Ningún dato disponible en esta tabla",
				"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				"sInfoPostFix":    "",
				"sSearch":         "Buscar:",
				"sUrl":            "",
				"sInfoThousands":  ",",
				"sLoadingRecords": "Cargando...",
				"oPaginate": {
					"sFirst":    "Primero",
					"sLast":     "Último",
					"sNext":     "Siguiente",
					"sPrevious": "Anterior"
				},
				"oAria": {
					"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
					"sSortDescending": ": Activar para ordenar la columna de manera descendente"
				}
			},
			'bProcessing': true,
			"bDestroy": true,
			"ajax": {
				"url": "/api/v1/instalacion/instalacionesDiaInternet",
				"dataSrc": ""
			},
			"columns": [
				{"data": "codigoDetalleCuenta"},
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "direccionActualCliente"},
				{"data": "referenciaDireccion"},
				{"data": "telefonoCliente"},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs"><i class="fa fa-hand-o-up "></i> Asignar Técnico</button>'},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs"><i class="fa fa-plus-square"></i> Agregar Materiales</button>'}
			]
		}).DataTable();
	}
});