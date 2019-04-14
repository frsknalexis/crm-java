
$(document).on('ready', function() {
	
	setTimeout(function() {
		 mostrarForm(false);
	}, 100);
	
	cargarComboCargo();
	
	function limpiar() {
		$('#codigoEmpleado').val('');
		$('#documentoPersonaEmpleado').val('');
		$('#empleadoNombrePersona').val('');
		$('#empleadoApellidosPersona').val('');
		$('#codigoCargo').val('');
	}
	
	function mostrarForm(flag) {
		
		limpiar();
		if(flag) {
			$('#listadoPersonasEmpleadosRegistro').hide();
			$('#formularioEmpleadosRegistro').show();
		}
		else {
			$('#listadoPersonasEmpleadosRegistro').show();
			$('#formularioEmpleadosRegistro').hide();
		}
	}
	
	function cancelarForm() {
		limpiar();
		mostrarForm(false);
	}
	
	$.ajax({
		
		type: 'GET',
		url: 'http://localhost:8080/api/v1/persona/personas/listaPersonasNoEmpleados',
		dataType: 'json',
		success: function(response){
			console.log(response);
		}
	});
	
	var tablaPersonas = $('#tablaPersonasEmpleados').dataTable({
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
		"ajax": {
			"url": "http://localhost:8080/api/v1/persona/personas/listaPersonasNoEmpleados",
			"dataSrc": ""
		},
		"columns": [
			{"data": "documentoPersona"},
			{"data": "nombrePersona"},
			{"data": "apellidoPaternoPersona"},
			{"data": "apellidoMaternoPersona"},
			{"data": "direccionActualPersona"},
			{"data": "referenciaPersona"},
			{"data": "telefonoUnoPersona"},
			{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnAgregarPersonaEmpleado" idDocumentoPersona><i class="fa fa-users"></i> Añadir a Empleados</button>'}
		]
	}).DataTable();
	
	$('#tablaPersonasEmpleados tbody').on('click', 'button', function() {
		var data = tablaPersonas.row( $(this).parents('tr')).data();
		$(this).attr('idDocumentoPersona', data.documentoPersona);
	});
	
	/**
	 * 
	 * Evento para agregar empleado
	 * 
	 * */
	
	$('#tablaPersonasEmpleados tbody').on('click', 'button.btnAgregarPersonaEmpleado', function() {
		var documentoPersonaEmpleado = $(this).attr('idDocumentoPersona');
		console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		mostrarForm(true);
		$('#documentoPersonaEmpleado').attr('disabled', true);
		$('#documentoPersonaEmpleado').val(documentoPersonaEmpleado);
		$('#empleadoNombrePersona').attr('disabled', true);
		$('#empleadoApellidosPersona').attr('disabled', true);
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#empleadoNombrePersona').val(response.nombrePersona);
				$('#empleadoApellidosPersona').val(response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
			}
		});
	});
	
	$('#cancelarAccionEmpleado').on('click', function() {
		cancelarForm();
	});
	
	/**
	 * 
	 * Funcion para cargar en el combo el cargo
	 */
	function cargarComboCargo() {
		
		var $codigoCargo = $('#codigoCargo');
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/cargo/cargos',
			dataType: 'json',
			success: function(response){
				console.log(response);
				$codigoCargo.html('');
				$codigoCargo.append('<option value="">Seleccione un Cargo</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoCargo.append('<option value="' + response[i].codigoCargo + '">' + response[i].descripcionCargo + '</option>');
				}
			}
		});
	}
	
	$('#guardarEmpleado').on('click', function(e) {
		e.preventDefault();
		
		if($('#codigoCargo').val().trim() != "") {
			
			var formData = {
				
					codigoEmpleado: $('#codigoEmpleado').val(),
					documentoPersonaEmpleado: $('#documentoPersonaEmpleado').val(),
					cargo: {
						codigoCargo: $('#codigoCargo').val()
					}
			};
			
			if(formData.codigoEmpleado) {
				codigoEmpleado = formData.codigoEmpleado;
				console.log("codigoEmpleado: " + codigoEmpleado);
			}
			else {
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/empleado/save',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status == 'CREATED') {
							
							swal({
								type: "success",
								title: "Empleado Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/empleado/view');
								}
							});
						}
						else if(response.status == 'ERROR') {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar al Empleado, verifique si ya existe !'
				            });
							
							 limpiar();
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Empleado !'
			            });
					}
				});
			}
		}
		
		if($('#codigoCargo').val().trim() == "") {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'Debe seleccionar un Cargo'
            });
			
	    	return false;
		}
	});
});
