$(document).on('ready', function() {
	
	var tablaCortesCable;
	
	var tablaCortesInternet;
	
	redireccionarViewInstalacionesDelDia();
	
	listarCortesCable();
	
	listarCortesInternet();
	
	 realizarCorte();
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
	 *function para listar cortes cable 
	 * 
	 */
	function listarCortesCable() {
		
		tablaCortesCable = $('#tablaCortesCable').dataTable({
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
	 *function para listar Cortes
	 * 
	 */
	function listarCortesInternet() {
		tablaCortesInternet = $('#tablaCortesInternet').dataTable({
			
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
				"url": "/api/v1/corte/corteInternet",
				"dataSrc": ""
			},
			"columns": [
				{"defaultContent": '<button type="button" class="btn btn-danger btn-xs buttonRealizarCorte" codigoServicioInternet><i class="fa fa-check"></i> Realizar Corte</button>'},
				{"data": "codigoServicioInternet"},
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "deudaTotal"}
			]
		}).DataTable();
		
		$('#tablaCortesInternet tbody').on('click', 'button', function() {
			
			var data = tablaCortesInternet.row( $(this).parents('tr')).data();
			console.log(data);
			$(this).attr('codigoServicioInternet', data.codigoServicioInternet);
		});
	}
	
	/**
	 * 
	 *function para lanzar el evento realizar corte 
	 * 
	 */
	function realizarCorte() {
		
		$('#tablaCortesInternet tbody').on('click', 'button.buttonRealizarCorte', function() {
			
			var codigoServicioInternet = $(this).attr('codigoServicioInternet');
			console.log("codigoServicioInternet: " + codigoServicioInternet);
			
			swal({
		        title: '¿Esta Seguro de realizar el Corte a este Cliente ?',
		        text: '¡Si no lo esta puede Cancelar la accion!',
		        type: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        cancelButtonText: 'Cancelar',
		        confirmButtonText: '¡Si, realizar Corte !'
		    }).then((result) => {
		        if(result.value){
		           
		        	$.ajax({
		        		
		        		url: '/api/v1/corte/actualizarServicio/' + codigoServicioInternet,
		        		type: 'GET',
		        		success: function(response){
		        			
		        			console.log(response);
		        			
		        			swal({
		        				type: "success",
		                        title: "El Corte se ha realizado correctamente",
		                        showConfirmButton: true,
		                        confirmButtonText: "Cerrar",
		                        closeOnConfirm: false
		                       }).then((result) => {
		                         if(result.value) {
		                            $(location).attr("href", "/instalacion/cortes/view");
		                        }
		                     })
		                 }
		        	});
		        }
		        else {
		            swal({
		                type: "error",
		                title: "Cancelado", 
		                text: "Usted ha cancelado la acción de Realizar Corte"
		            });
		        }
		    });
		});
	}
});