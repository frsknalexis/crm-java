$(document).on('ready', function() {
	
	var tablaCortes;
	redireccionarViewInstalacionesDelDia();
	listarCortes();
	/**
	 *
	 *Funcion para redireccionar instalaciones del dia
	 * 
	 */
	function redireccionarViewInstalacionesDelDia() {
		
		$('#buttonInstalacionesDelDia').on('click', function() {
			
			$(location).attr('href', '/instalacion/instalaciones/view');
		});
	}
	
	/**
	 * 
	 *function para listar Cortes
	 * 
	 */
	function listarCortes() {
		tablaCortes = $('#tablaCortes').dataTable({
			
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
	
});